package br.com.armazem.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.armazem.dao.FabricanteDAO;
import br.com.armazem.domain.Fabricante;

public class FabricanteDAOTest {
	@Ignore
	@Test
	public void salvar(){
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("DESCRI��O");
		
		Fabricante fabricante2 = new Fabricante();
		fabricante2.setDescricao("DESCRI��O1");
		
		FabricanteDAO fdao = new FabricanteDAO();
		
		fdao.salvar(fabricante);
		fdao.salvar(fabricante2);
		
	}
	@Test
	@Ignore
	public void listar(){
		FabricanteDAO dao = new FabricanteDAO();
		List<Fabricante>fabricantes = dao.listar();
		
		for(Fabricante fabricante : fabricantes ){
			System.out.println(fabricante);
		}
	}
	@Test
	public void buscarPorCodigo(){
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante f1 = dao.buscarPorCodigo(2L);
		
		System.out.println(f1);
		
	}
}
