package com.app.backend.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.app.backend.Entity.mobile;



@Service
public class otp {
	@Autowired
	JavaMailSender mailSender;
	public void sendMail(mobile m)
	{
		javax.mail.internet.MimeMessage mimeMessage=mailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mimeMessage);
		
		
		try {
			helper.setFrom("anand1999m@gmail.com");
		}
		catch (javax.mail.MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			helper.setTo(m.getEmail());
		} catch (javax.mail.MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			helper.setSubject("Mail Verification");
		} catch (javax.mail.MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			helper.setText("Your OTP for Email verification is"+m.getOtp());
		} catch (javax.mail.MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mailSender.send(mimeMessage);
}
}
