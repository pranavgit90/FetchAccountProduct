package com.account.dao;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.account.model.Account;

@Component
public interface FetchAccountProductDao {

	public ResponseEntity<Object> fetchAccountProductCode(Account account);

}