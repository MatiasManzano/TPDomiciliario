package ar.com.logistica.controller;

import ar.com.logistica.dao.TransporteDAO;
import ar.com.logistica.dao.TransporteDAOimpl;
import ar.com.logistica.entity.Transporte;

public class Main {

	public static void main(String[] args) {
		
		TransporteDAO transporteDAO = new TransporteDAOimpl();
		
		Transporte lala = transporteDAO.findByModelo("i130");
		
		System.out.println(lala);

	}

}
