package com.alexa.bank.apps.service;

import java.util.List;

import com.alexa.bank.apps.entity.Role;

public interface AdminService {
	
	List<String> getAllUserNames();
	
	List<Role> getAllRoles();
	
	void assignRole(String uname,Role role);

}
