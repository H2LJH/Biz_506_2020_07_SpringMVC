package com.biz.bbs.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeesVO {

	private long e_id;
	private String e_first_name;
	private String e_last_name;
	private String e_address;
	private String e_tel;
	private String e_email;
}
