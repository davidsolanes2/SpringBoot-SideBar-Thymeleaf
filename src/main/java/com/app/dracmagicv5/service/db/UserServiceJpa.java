package com.app.dracmagicv5.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dracmagicv5.model.User;
import com.app.dracmagicv5.repository.UserRepository;
import com.app.dracmagicv5.service.UserService;

@Service
public class UserServiceJpa implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void guardar(User user) {
		userRepo.save(user);
	}
	
	@Override
	public void eliminar(Integer idUser) {
		userRepo.deleteById(idUser);
	}
	
	@Override
	public List<User> buscarTodos() {
		return userRepo.findAll();
	}
	
	@Override
	public User buscarPorId(Integer idUser) {
		Optional<User> optional = userRepo.findById(idUser);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	@Override
	public User buscarPorUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public User buscarPorFirstName(String firstName) {
		return userRepo.findByFirstName(firstName);
	}
	
	@Override
	public User buscarPorEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	@Override
	public List<User> buscarRegistrados() {
		return userRepo.findByFechaRegistroNotNull();
	}
	

	@Transactional
	@Override
	public int bloquear(Integer idUser) {
		int rows = userRepo.lock(idUser);
		return rows;
	}
	
	@Transactional
	@Override
	public int activar(Integer idUser) {
		int rows = userRepo.unlock(idUser);
		return rows;
	}
	
	
	
}
