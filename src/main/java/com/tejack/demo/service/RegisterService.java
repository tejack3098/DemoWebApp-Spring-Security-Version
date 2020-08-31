package com.tejack.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tejack.demo.dao.UserDao;
import com.tejack.demo.model.User;

@Service
@Transactional
public class RegisterService {


	@Autowired
	private UserDao dao;

	public boolean RegisterUser(User user) {

		try {
			dao.saveUser(user);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

}
