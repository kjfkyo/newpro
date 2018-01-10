package com.hm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.hm.entity.account.User;
import com.hm.service.account.UserService;
import com.hm.util.Digests;
import com.hm.util.Encodes;
import com.hm.util.Utils;

@Controller
@RequestMapping("/Chpa")
public class ChpaController {
	@Autowired
	UserService userService;
	  public static final int HASH_INTERATIONS = 1024;
	  @ResponseBody
	  @RequestMapping("vali")	
	  public String vali(String oldpa) {	
		User user= userService.findUserById(Utils.getUserId()+"");
	
		System.out.println(user.getName());
		byte[] salt = Encodes.decodeHex(user.getSalt());
		byte[] hashPassword = Digests.sha1(oldpa.getBytes(), salt, HASH_INTERATIONS);
		System.out.println(Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword));
			if((user.getSalt()+user.getPassword()).equals(Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword))){
				
				return  Utils.toJson(true);
			}else{
				return  Utils.toJson(false);
			}
	  }
	  @ResponseBody
	  @RequestMapping("update")	
	  public String update(String plainPassword) {	
			
			User user= userService.findUserById(Utils.getUserId()+"");
			user.setPlainPassword(plainPassword);
			userService.updatePassword(user);
			return  Utils.toJson(true);
		  }
 
}
