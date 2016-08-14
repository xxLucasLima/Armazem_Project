package br.com.armazem.test;

import org.junit.Test;

import br.com.armazem.util.HibernateUtil;

public class GeraTabelasTest {

	@Test
	public void gerar(){
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}
}
