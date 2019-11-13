
package com.food101.project.theFood;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.context.annotation.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import data.AppUser;
import supply.Search;

public class userLoginService implements UserDetailsService {
	
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
/*
    Here we are using dummy data, you need to load user data from
     database or other third party application 
	  need change to search in firebase
*/
	  Search s = new Search();
    AppUser user;
	try {
		user = s.findUserbyUsername(username);
		
		if(user == null) {
			System.out.println("fuck off");
		}
		
	    UserBuilder builder = null;
	    if (user != null) {
	      builder = org.springframework.security.core.userdetails.User.withUsername(username);
	      builder.password(new BCryptPasswordEncoder().encode(user.getEncrytedPassword()));
	      builder.roles(user.getRoles());
	    } else {
	      throw new UsernameNotFoundException("User not found.");
	    }

	    return builder.build();
	    
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ExecutionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
/*
    UserBuilder builder = null;
    if (user != null) {
      builder = org.springframework.security.core.userdetails.User.withUsername(username);
      builder.password(new BCryptPasswordEncoder().encode(user.getEncrytedPassword()));
     // builder.roles(user.getRoles());
    } else {
      throw new UsernameNotFoundException("User not found.");
    }
    return builder.build();
    */
	return null;
  }

  /*
  private AppUser findUserbyUername(String username) {
    if(username.equalsIgnoreCase("admin")) {
      return new AppUser(username, "admin123", "ADMIN");
    }
    return null;
  }
  
 */
  
  

  }
 
