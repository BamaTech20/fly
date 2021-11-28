package com.example.fmw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.fmw.entity.Role;
import com.example.fmw.entity.User;
import com.example.fmw.repository.IRoleRepository;
import com.example.fmw.repository.IUserRepository;

@Service
public class UserService {

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IRoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public UserService(IUserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public User save(User user) {
		Role roleUser = roleRepository.findByName("ADMIN");
		user.addRole(roleUser);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	public User findByUsername(String username) {
		return userRepository.findByEmail(username);
	}

	public void delete(long id) {
		userRepository.deleteById(id);
	}

	public List<Role> listRoles() {
		return roleRepository.findAll();
	}

	public User get(long id) {
		return userRepository.findById(id).get();
	}

	public Iterable<User> listAll() {
		return userRepository.findAll();
	}

	public void update(User user) {

		User us = userRepository.findByid(user.getId());
		us.setFirstName(user.getFirstName());

		if (us.getFirstName() != null) {
			us.setFirstName(user.getFirstName());
		}
		if (us.getLastName() != null) {
			us.setLastName(user.getLastName());
		}
		if (us.getPassword() != null) {
			us.setPassword(user.getPassword());
		}

		userRepository.save(us);

	}

	/*
	 * @Override public User save2(AdminRegistration registrationDto) {
	 * 
	 * // Creating user role user User user = new
	 * User(registrationDto.getFirstName(), registrationDto.getLastName(),
	 * registrationDto.getUserName(),
	 * passwordEncoder.encode(registrationDto.getPassword()),
	 * Arrays.asList(roleRepository.findByName("USER")));
	 * 
	 * return userRepository.save(user); }
	 */

	/*
	 * public void update(AdminRegistration user, User use) {
	 * 
	 * userRepository.update(user.getFirstName(), user.getLastName(),
	 * passwordEncoder.encode(use.getPassword()), use.getId()); }
	 */
}
