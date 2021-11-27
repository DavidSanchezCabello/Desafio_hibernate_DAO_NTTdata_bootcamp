package com.demo.hibernate.demo.entities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDaoImpl implements ClienteDaoI {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void insertar(Cliente cliente) {
		Session session = entityManager.unwrap(Session.class);
		
		session.save(cliente);
		
		session.close();
	}

	@Override
	@Transactional
	public Cliente findById(Long idCliente) {
		Session session = entityManager.unwrap(Session.class);
		
		Cliente cliente = (Cliente) session.createQuery("FROM Cliente WHERE id =" + idCliente).uniqueResult();	
		
		session.close();
		
		return cliente;
	}

	@Override
	@Transactional
	public Cliente delete(Cliente cliente) {
		Session session = entityManager.unwrap(Session.class);
		
		entityManager.remove(entityManager.merge(cliente));
		
		session.close();
		
		return cliente;
	}

	@Override
	@Transactional
	public void update(Cliente cliente) {
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(cliente);
		
		session.close();
	}

	@Override
	@Transactional
	public List<Cliente> findAll() {
		Session session = entityManager.unwrap(Session.class);
		
		List<Cliente> listaClientes = session.createQuery("FROM Cliente").getResultList();
		
		session.close();
		return listaClientes;
	}

	@Override
	@Transactional
	public List<Cliente> findFullName(String name, String surname1, String surname2) {
		Session session = entityManager.unwrap(Session.class);
		
		List<Cliente> nombreCliente = session.createQuery("FROM Cliente WHERE name='" + name +"' AND surname1 = '" + surname1 + "' AND surname2 = '"+ surname2 +"'").getResultList();
		
		session.close();
		return nombreCliente;
	}	

}
