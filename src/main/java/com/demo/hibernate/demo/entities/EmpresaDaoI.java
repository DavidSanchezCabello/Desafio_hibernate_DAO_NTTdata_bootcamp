package com.demo.hibernate.demo.entities;

import java.util.List;

public interface EmpresaDaoI {

	public void insertarEmpresa(Empresa empresa);
	
	public Empresa findByIdEmpresa(Long idEmpresa);

	public List<Empresa> findAllEmpresas();
	
	public void deleteEmpresa(Empresa empresa);
	
	public void updateEmpresa(Empresa empresa);
}
