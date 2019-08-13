package com.account;

import java.net.URI;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.account.model.Account;
import com.account.model.FetchAccountProduct;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@PropertySource(value = { "classpath:application.yml" })
public class FetchAccountProductTest {

	private static Account account;

	@Value("${spring.server.baseUrl}")
	private String baseUrl;

	@LocalServerPort
	protected int serverPort;

	@BeforeClass
	public static void setup() {
		account = new Account();
		account.setAccountId("60000012");
	}

	@Test
	public void contextLoads() {
	}

	/**
	 * rest api test cases
	 *
	 */
	@Test
	@DisplayName("Test case for rest endpoint test")
	public void fetchAccountProductCodeTest() {
		try {
			TestRestTemplate restTemplate = new TestRestTemplate();

			final String baseUrlContxt = baseUrl + ":" + serverPort + "/account/fetch-productcode";
			URI uri = new URI(baseUrlContxt);

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

			HttpEntity<Account> request = new HttpEntity<>(account, headers);

			ResponseEntity<FetchAccountProduct> result = restTemplate.postForEntity(uri, request,
					FetchAccountProduct.class);

			if (result.getStatusCodeValue() == 200) {
				Assert.assertNotNull(result.getBody().getProductLblCode());
			} else {
				Assert.fail(result.getBody().toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
