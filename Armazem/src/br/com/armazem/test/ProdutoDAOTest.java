package br.com.armazem.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;


import br.com.armazem.dao.FabricanteDAO;
import br.com.armazem.dao.ProdutoDAO;
import br.com.armazem.domain.Fabricante;
import br.com.armazem.domain.Produto;

public class ProdutoDAOTest {
	
	
	@Test
	@Ignore
	public void salvar(){
		Fabricante fabricante = new Fabricante();
		FabricanteDAO dao = new FabricanteDAO();
		
		fabricante = dao.buscarPorCodigo(4L);
		
		Produto produto = new Produto();
		ProdutoDAO pdao = new ProdutoDAO();
		produto.setDescricao("Descrição X");
		produto.setFabricante(fabricante);
		produto.setPreco(new BigDecimal(22.5));
		produto.setQuantidade(17);
		
		pdao.salvar(produto);
		
	}
	@Test
	@Ignore
	public void buscarPorCodigo(){
		ProdutoDAO dao = new ProdutoDAO();
		Produto produto = dao.buscarPorCodigo(18L);
		
		System.out.println(produto);
	}
	@Test
	public void listar(){
		ProdutoDAO dao = new ProdutoDAO();
		
		List<Produto> produtos = dao.listar();
		System.out.println(produtos	);
		
		
	}
}

