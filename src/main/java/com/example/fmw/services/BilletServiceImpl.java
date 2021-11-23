package com.example.fmw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.fmw.entity.Billet;
import com.example.fmw.repository.IBilletRepository;

@Service
public class BilletServiceImpl implements IBilletService {

	@Autowired
	private IBilletRepository ibillet;

	public void save(Billet billet) {
		ibillet.save(billet);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
