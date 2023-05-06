package com.app.backend.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.app.backend.Entity.mobile;
import com.app.backend.Exception.myexception;
import com.app.backend.Repository.mobilerepository;
import com.app.backend.Response.Reponsestructure;
import com.app.backend.Response.otp;

@Service
public class mobileservice {

	@Autowired
	mobilerepository mreop;
	@Autowired
	otp mailVerifaction;
	
	@Autowired
	mobile m;
	public Reponsestructure<mobile> save(mobile m)
	{
		Reponsestructure<mobile>  structure=new Reponsestructure<>();

	
			Random random=new Random();
			int otp=random.nextInt(100000,999999);
			m.setOtp(otp);

			mailVerifaction.sendMail(m);

			structure.setCode(HttpStatus.PROCESSING.value());
			structure.setMessgae("Varification Mail Sent ");
			structure.setData(mreop.save(m));
		

		return structure; 
	}

	public Reponsestructure<mobile> verfiy(int id, int otp) throws myexception {
		Reponsestructure<mobile> structure=new Reponsestructure<>();
		Optional<mobile> optional=mreop.findById(id);
		if(optional.isEmpty()) {
			throw new com.app.backend.Exception.myexception("check id and try again");
		}else {
			mobile customer=optional.get();
			if(customer.getOtp()==otp) {
				structure.setCode(HttpStatus.CREATED.value());
				
				structure.setMessgae("Account created successduly");
				
			
				structure.setData(mreop.save(customer));
			}else {
				throw new myexception("otp invalid");
			}
		}
		
		return structure;
	}
	}

