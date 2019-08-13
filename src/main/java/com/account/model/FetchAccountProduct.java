package com.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account_product")
public class FetchAccountProduct {

	@Id
	@Column(name = "ACCOUNT_ID", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String accountId;

	@Column(name = "PRODUCT_LBL_CODE")
	private String productLblCode;

}
