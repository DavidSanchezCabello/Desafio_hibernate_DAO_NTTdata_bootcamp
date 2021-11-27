package com.demo.hibernate.demo.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_CLIENT")
public class Cliente {

	private List<Contrato> contractsList;
	
	private Long idClient;

	private String name;

	private String surname1;
	
	private String surname2;

	private String dni;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="clientId", fetch = FetchType.LAZY)
	public List<Contrato> getContractsList() {
		return contractsList;
	}

	public void setContractsList(List<Contrato> contractsList) {
		this.contractsList = contractsList;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLIENT_ID", precision = 15)
	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "surname1")
	public String getSurname1() {
		return surname1;
	}

	public void setSurname1(String surname1) {
		this.surname1 = surname1;
	}

	@Column(name = "surname2")
	public String getSurname2() {
		return surname2;
	}

	public void setSurname2(String surname2) {
		this.surname2 = surname2;
	}


	@Column(name = "dni", length = 9, unique = true)
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}	
	
}
