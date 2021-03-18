package com.app.dracmagicv5.service;

import java.util.List;

import com.app.dracmagicv5.model.User;

public interface UserService {
	
	public void guardar(User user);
	public void eliminar(Integer idUser);
	
	List<User> buscarTodos();
	List<User> buscarRegistrados();
	
	User buscarPorId(Integer idUser);
	User buscarPorUsername(String username);
	User buscarPorFirstName(String firstName);
	
	int bloquear(Integer idUser);
	int activar(Integer idUser);

	User buscarPorEmail(String email);

}
