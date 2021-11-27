package com.demo.hibernate.demo.entities;

import java.util.List;

public interface ContratoDaoI {

	public void insertarContrato(Contrato contrato);
	
	public Contrato findById(Long contrato);
	
	public void delete(Contrato contrato);
	
	public void update(Contrato contrato);
	
	public List<Contrato> findAll();
	
	public List<Contrato> findContractByClient(Long cliente);

}
