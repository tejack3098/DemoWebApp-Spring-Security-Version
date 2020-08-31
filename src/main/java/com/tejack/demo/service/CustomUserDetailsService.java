package com.tejack.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tejack.demo.dao.UserDao;
import com.tejack.demo.model.User;

@Service
@Transactional
public class CustomUserDetailsService {

	@Autowired
	private UserDao dao;


	public Boolean chk_email(User user) {

		Boolean status;

		status = dao.check_emailId(user);

		return status;
	}

	public String getusername(User user) {

		return dao.getUserUname(user);

	}
}
