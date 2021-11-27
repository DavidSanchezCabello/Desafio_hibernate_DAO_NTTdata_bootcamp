package com.demo.hibernate.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_CONTRACT")
public class Contrato {

	private Cliente clientId;
	
	private Long id;
	
	private String effectiveDate;
	private String expiantionDate;
	private Double monthlyRate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CLIENT_ID")
	public Cliente getClientId() {
		return clientId;
	}	
	public void setClientId(Cliente clientId) {
		this.clientId = clientId;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONTRACT_ID")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "fecha_vigencia")
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	
	@Column(name = "fecha_caducidad")
	public String getExpiantionDate() {
		return expiantionDate;
	}
	public void setExpiantionDate(String expiantionDate) {
		this.expiantionDate = expiantionDate;
	}
	
	@Column(name = "precio")
	public Double getMonthlyRate() {
		return monthlyRate;
	}
	public void setMonthlyRate(Double monthlyRate) {
		this.monthlyRate = monthlyRate;
	}
	
	

	
	
	
}
