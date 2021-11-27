package com.demo.hibernate.demo.entities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpresaDaoImpl implements EmpresaDaoI{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void insertarEmpresa(Empresa empresa) {
		Session session = entityManager.unwrap(Session.class);
		
		session.save(empresa);
		
		session.close();
	}
	
	@Override
	@Transactional
	public Empresa findByIdEmpresa(Long idEmpresa) {
		Session session = entityManager.unwrap(Session.class);
		
		Empresa empresa = (Empresa) session.createQuery("FROM Empresa WHERE id =" + idEmpresa).uniqueResult();	
		
		session.close();
		
		return empresa;
	}
	
	@Override
	@Transactional
	public List<Empresa> findAllEmpresas() {
		Session session = entityManager.unwrap(Session.class);
		
		List<Empresa> listaEmpresas = session.createQuery("FROM Empresa").getResultList();
		
		session.close();
		return listaEmpresas;
		
	}

	@Override
	@Transactional
	public void deleteEmpresa(Empresa empresa) {
		Session session = entityManager.unwrap(Session.class);
		
		entityManager.remove(entityManager.merge(empresa));
		
		session.close();
	}

	@Override
	@Transactional
	public void updateEmpresa(Empresa empresa) {
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(empresa);
		
		session.close();
	}


	
	
}
