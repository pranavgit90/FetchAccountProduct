package com.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.model.Account;
import com.account.service.FetchAccountProductService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping("/account")
public class FetchAccountProductController {

	@Autowired
	private FetchAccountProductService fetchAccountProductService;

	@ApiOperation("Fetch product lable code based on the account id given.")
	@PostMapping(path = "/fetch-productcode", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> fetchAccountProductCode(@RequestBody Account account) {
		return fetchAccountProductService.fetchAccountProductCode(account);
	}
}
