package com.demo.hibernate.demo;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.hibernate.demo.entities.Cliente;
import com.demo.hibernate.demo.entities.Contrato;
import com.demo.hibernate.demo.entities.ContratoDaoI;
import com.demo.hibernate.demo.entities.Empresa;
import com.demo.hibernate.demo.entities.EmpresaDaoI;
import com.demo.hibernate.demo.services.HibernateServicioI;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private HibernateServicioI servicio;

	@Autowired
	private EmpresaDaoI empresaDao;
	
	@Autowired
	private ContratoDaoI contratoDao;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public void run(String... args) throws Exception {
		
		// Instancias Clientes
		Cliente cliente = new Cliente();
		cliente.setName("Arancha");
		cliente.setSurname1("Palacios");
		cliente.setSurname2("Espi");
//		cliente.setDni("45874125T");
		Cliente cliente1 = new Cliente();
		cliente1.setName("Pablo");
		cliente1.setSurname1("Acosta");
		cliente1.setSurname2("Gomez");
//		cliente1.setDni("24574125T");
		Cliente cliente2 = new Cliente();
		cliente2.setName("Raúl");
		cliente2.setSurname1("Aparicio");
		cliente2.setSurname2("Perez");
//		cliente2.setDni("12544125T");
		
		// Inserts clientes
		servicio.insertarCliente(cliente);
		servicio.insertarCliente(cliente1);
		servicio.insertarCliente(cliente2);
		
		cliente = servicio.buscarCliente(3L);
		
		// Instancias Contrato
		Contrato contract = new Contrato();
		Contrato contract1 = new Contrato();
		Contrato contract2 = new Contrato();
		Contrato contract3 = new Contrato();
		
		contract.setEffectiveDate("2019-02-12");
		contract.setExpiantionDate("2020-02-12");
		contract.setMonthlyRate(210.00);
		contract.setClientId(cliente1);
		
		contract1.setEffectiveDate("2020-01-09");
		contract1.setExpiantionDate("2021-02-12");
		contract1.setMonthlyRate(1195.00);
		contract1.setClientId(cliente2);
		
		contract2.setEffectiveDate("2021-12-05");
		contract2.setExpiantionDate("2022-02-12");
		contract2.setMonthlyRate(513.00);
		contract2.setClientId(cliente);
		
		contract3.setEffectiveDate("2021-12-05");
		contract3.setExpiantionDate("2022-02-12");
		contract3.setMonthlyRate(513.00);
		contract3.setClientId(cliente2);

		// Inserts contrato
		contratoDao.insertarContrato(contract);
		contratoDao.insertarContrato(contract1);
		contratoDao.insertarContrato(contract2);
		contratoDao.insertarContrato(contract3);
		
		// Instancias Empresa
		Empresa empresa = new Empresa();
		Empresa empresa1 = new Empresa();
		Empresa empresa2 = new Empresa();

		empresa.setNombre("FORD");
		empresa.setDireccion("C/Peral S/N");
		empresa1.setNombre("RENAULT");
		empresa1.setDireccion("C/Paloma S/N");
		empresa2.setNombre("SEAT");
		empresa2.setDireccion("C/Relator 49");

		// Inserts empresa
		empresaDao.insertarEmpresa(empresa1);
		empresaDao.insertarEmpresa(empresa);
		empresaDao.insertarEmpresa(empresa2);
		List<Empresa> empreList = empresaDao.findAllEmpresas();
		Empresa company = empresaDao.findByIdEmpresa(2L);
		
		Cliente cl1 = servicio.buscarCliente(cliente1.getIdClient());
		System.out.println("Resultado función buscarCliente()= " + cl1.getName());
		
		List<Cliente> fullName = servicio.findFullName("Arancha", "Palacios", "Espi");

		System.out.println(" Muestreo datos de un contrato: " + contract.getEffectiveDate() + " - " + contract.getExpiantionDate() + " - " + contract.getMonthlyRate() + "€  -" + contract.getClientId());
		System.out.println(" Muestreo contratos de un cliente: " + contratoDao.findContractByClient(1L));
		System.out.println(" Muestreo nombre de un cliente por su ID: " + cliente.getName());
		System.out.println(" Muestreo datos de una compañia: " + company.getNombre() + company.getDireccion());

		for (Iterator iterator = empreList.iterator(); iterator.hasNext();) {
			Empresa company1 = (Empresa) iterator.next();
			System.out.println(company1.getNombre());
		}
		
		for (Cliente item : fullName) {
			System.out.println(item.getName() + item.getSurname1() + item.getSurname2());
		}
		
		List<Contrato> contractsByClient = contratoDao.findContractByClient(cliente2.getIdClient());
		for (Contrato item : contractsByClient) {
			System.out.println("Muestreo id contratos asociado al cliente: "+ cliente2.getIdClient() + "\n ID contrato: " + item.getId() + "\n fecha vigencia: " + item.getEffectiveDate() + "\n fecha expiración: " + item.getExpiantionDate());
		}
		
		for (Cliente item : fullName) {
			System.out.println(item.getName() + item.getSurname1() + item.getSurname2());
		}
		
	}
}
