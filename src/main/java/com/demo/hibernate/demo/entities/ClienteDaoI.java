package com.demo.hibernate.demo.entities;

import java.util.List;

public interface ClienteDaoI {

	public void insertar(Cliente cliente);
	
	public Cliente findById(Long idCliente);
	
	public Cliente delete(Cliente cliente);
	
	public void update(Cliente cliente);
	
	public List<Cliente> findAll();
	
	public List<Cliente> findFullName(String name, String surname1, String surname2);
}
