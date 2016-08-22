package br.com.armazem.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.armazem.dao.FabricanteDAO;
import br.com.armazem.domain.Fabricante;

public class FabricanteDAOTest {
	
	@Test
	public void salvar(){
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("DESCRI플O 1");
		
		Fabricante fabricante2 = new Fabricante();
		fabricante2.setDescricao("DESCRI플O 2");
		
		Fabricante fabricante3 = new Fabricante();
		fabricante3.setDescricao("DESCRI플O 3");
		
		FabricanteDAO fdao = new FabricanteDAO();
		
		fdao.salvar(fabricante);
		fdao.salvar(fabricante2);
		fdao.salvar(fabricante3);
		
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
	@Ignore
	@Test
	public void buscarPorCodigo(){
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante f1 = dao.buscarPorCodigo(2L);
		
		System.out.println(f1);
		
	}
	@Ignore
	@Test
	public void excluir(){
		FabricanteDAO dao = new FabricanteDAO();

		Fabricante fabricante = dao.buscarPorCodigo(2L);
		
		dao.excluir(fabricante);
		
	}
	
	@Ignore
	@Test
	public void editar(){
		FabricanteDAO dao = new FabricanteDAO();

		Fabricante fabricante = dao.buscarPorCodigo(2L);
		fabricante.setDescricao("DECRI플O EDITADA DE NOVO");
		
		dao.editar(fabricante);
		
	}
}
