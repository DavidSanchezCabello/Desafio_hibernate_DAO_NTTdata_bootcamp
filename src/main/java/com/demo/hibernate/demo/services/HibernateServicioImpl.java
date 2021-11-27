package com.demo.hibernate.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.hibernate.demo.entities.Cliente;
import com.demo.hibernate.demo.entities.ClienteDaoI;

@Service
public class HibernateServicioImpl implements HibernateServicioI {

	@Autowired
	private ClienteDaoI clienteDao;
	
	@Override
	public Cliente buscarCliente(Long id) {

		return clienteDao.findById(id);
	}

	@Override
	public void insertarCliente(Cliente cliente) {
		clienteDao.insertar(cliente);		
	}

	@Override
	public Cliente delete(Cliente cliente) {
		clienteDao.delete(cliente);
		return null;
	}

	@Override
	public void update(Cliente cliente) {
		clienteDao.update(cliente);		
	}

	@Override
	public List<Cliente> findAll() {
		clienteDao.findAll();
		return null;
	}

	@Override
	public List<Cliente> findFullName(String name, String surname1, String surname2) {
		return clienteDao.findFullName(name, surname1, surname2);		
	}

}
