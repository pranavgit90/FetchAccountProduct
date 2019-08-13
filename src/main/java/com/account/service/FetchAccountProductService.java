package com.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.account.dao.FetchAccountProductDao;
import com.account.model.Account;

@Service
public class FetchAccountProductService {

	@Autowired
	private FetchAccountProductDao fetchAccountProductDao;

	public ResponseEntity<Object> fetchAccountProductCode(Account account) {
		return fetchAccountProductDao.fetchAccountProductCode(account);
	}

}
