package com.demo.hibernate.demo.entities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContratoDaoImpl implements ContratoDaoI {

	@Autowired
	EntityManager entityManager;
	
	@Override
	@Transactional
	public void insertarContrato(Contrato contrato) {
		Session session = entityManager.unwrap(Session.class);
		
		session.save(contrato);
		
		session.close();		
	}

	@Override
	@Transactional
	public Contrato findById(Long idContrato) {
		Session session = entityManager.unwrap(Session.class);
		
		Contrato contrato = (Contrato) session.createQuery("FROM Contrato WHERE id =" + idContrato).uniqueResult();	
		
		session.close();
		
		return contrato;
	}

	@Override
	@Transactional
	public void delete(Contrato contrato) {
		Session session = entityManager.unwrap(Session.class);
		
		entityManager.remove(entityManager.merge(contrato));
		
		session.close();
	}

	@Override
	@Transactional
	public void update(Contrato contrato) {
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(contrato);
		
		session.close();
	}

	@Override
	@Transactional
	public List<Contrato> findAll() {
		Session session = entityManager.unwrap(Session.class);
		
		List<Contrato> contractList = session.createQuery("FROM Contrato").getResultList();
		
		session.close();
		return contractList;
	}

	@Override
	@Transactional
	public List<Contrato> findContractByClient(Long cliente) {
		Session session = entityManager.unwrap(Session.class);
		
		List<Contrato> contractList = session.createQuery("FROM Contrato WHERE clientId = '" + cliente + "'").getResultList();
		
		session.close();
		return contractList;
	}

}
