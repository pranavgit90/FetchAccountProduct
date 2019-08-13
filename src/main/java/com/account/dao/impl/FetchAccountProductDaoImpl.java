package com.account.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.account.dao.FetchAccountProductDao;
import com.account.model.Account;
import com.account.model.FetchAccountProduct;

@Component
public class FetchAccountProductDaoImpl implements FetchAccountProductDao {

	final String SELECT_PROD_LBL_CODE_QUERY = "SELECT PRODUCT_LBL_CODE FROM account_product WHERE ACCOUNT_ID=:ACCOUNT_ID";

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public FetchAccountProductDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public ResponseEntity<Object> fetchAccountProductCode(Account account) {

		SqlParameterSource namedParameter = new MapSqlParameterSource("ACCOUNT_ID", account.getAccountId());
		String productLblCode = namedParameterJdbcTemplate.queryForObject(SELECT_PROD_LBL_CODE_QUERY, namedParameter,
				String.class);

		FetchAccountProduct fetchAccountProduct = new FetchAccountProduct();
		fetchAccountProduct.setAccountId(account.getAccountId());
		fetchAccountProduct.setProductLblCode(productLblCode);

		return new ResponseEntity<>(fetchAccountProduct, HttpStatus.OK);

	}

}
