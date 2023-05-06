package com.app.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.backend.Entity.mobile;
import com.app.backend.Exception.myexception;
import com.app.backend.Repository.mobilerepository;
import com.app.backend.Response.Reponsestructure;
import com.app.backend.service.mobileservice;


@RestController
@RequestMapping("user")
public class mobilecontroller {
	
	@Autowired
	mobileservice ms;
	@PostMapping("add")
	public Reponsestructure<mobile> save(@RequestBody mobile m)
	{
		return ms.save(m);
	}
	
	@PutMapping("otp/{id}/{otp}")
	public Reponsestructure<mobile> otpverification(@PathVariable int id,@PathVariable int otp) throws myexception{
		return ms.verfiy(id,otp);
	}
	
}
