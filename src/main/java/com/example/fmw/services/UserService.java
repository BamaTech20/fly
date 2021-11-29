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
		Role roleUser = roleRepository.findByName("ROLE_ADMIN");
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

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);

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
