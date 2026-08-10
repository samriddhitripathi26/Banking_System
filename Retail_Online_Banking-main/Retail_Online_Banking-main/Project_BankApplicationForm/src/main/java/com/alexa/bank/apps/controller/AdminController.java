package com.alexa.bank.apps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alexa.bank.apps.entity.Role;
import com.alexa.bank.apps.service.AdminService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping(value = "/alluname")
	public List<String> getAllUname(){
		System.out.println("Check API calling");
		List<String> list = adminService.getAllUserNames();
		return list;
		
	}
	
	@GetMapping(value = "/allrole")
	public List<Role> getAllRole(){
		List<Role> rlist = adminService.getAllRoles();
	    return rlist;
	}
	
	@PostMapping(value = "/assign/{uname}")
	public String AssignRole(@PathVariable String uname,@RequestBody Role role) {
		System.out.println("Check Data : " + uname + "  " + role);
		adminService.assignRole(uname, role);
		return "Role Assigned Successfully.";
	}

}
