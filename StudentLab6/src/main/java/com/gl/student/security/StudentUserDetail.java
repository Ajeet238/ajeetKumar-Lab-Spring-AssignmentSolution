package com.gl.student.security;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gl.student.entity.Role;
import com.gl.student.entity.User;


public class StudentUserDetail implements UserDetails {
	
	
	private User user;

	public StudentUserDetail(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Role> rolesList=user.getRoles();
		List<SimpleGrantedAuthority> grantedAuthorities=new ArrayList<>();
		
		for(Role role:rolesList)
		{
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}