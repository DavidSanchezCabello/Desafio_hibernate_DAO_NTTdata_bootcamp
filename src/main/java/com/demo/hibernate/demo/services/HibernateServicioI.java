package com.demo.hibernate.demo.services;

import java.util.List;

import com.demo.hibernate.demo.entities.Cliente;

public interface HibernateServicioI {

	public Cliente buscarCliente(Long id);
	
	public void insertarCliente(Cliente cliente);
	
	public Cliente delete(Cliente cliente);
	
	public void update(Cliente cliente);
	
	public List<Cliente> findAll();
	
	public List<Cliente> findFullName(String name, String surname1, String surname2);
}
