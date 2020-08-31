package com.tejack.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
public class OTPmailService {
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	@Autowired
	private OTP_Service gen_otp;
	
	
	boolean result;
	
	public boolean MailOTP(String email) {
		
		int otp = gen_otp.generateOTP(email);

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(email);
		msg.setSubject("OTP verification from DemoWeb App");
        msg.setText("Your OTP is: "+ otp);
		
		try{
	        javaMailSender.send(msg);	
	        result = true;
		}
		catch(Exception e) {
			result = false;
		}

		return result;	
	}
  
}
