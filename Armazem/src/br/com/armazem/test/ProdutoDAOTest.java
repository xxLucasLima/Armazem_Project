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
	public void salvar(){
		Fabricante fabricante = new Fabricante();
		FabricanteDAO dao = new FabricanteDAO();
		fabricante = dao.buscarPorCodigo(1L);
		
		Produto produto = new Produto();
		ProdutoDAO pdao = new ProdutoDAO();
		Produto produto2 = new Produto();
		
		produto.setDescricao("Descrição X");
		produto.setFabricante(fabricante);
		produto.setPreco(new BigDecimal(22.5D));
		produto.setQuantidade(17);
		
		Fabricante fabricante2 = new Fabricante();
		FabricanteDAO dao2 = new FabricanteDAO();
		fabricante2 = dao2.buscarPorCodigo(2L);
		
		produto2.setDescricao("Descrição Z");
		produto2.setFabricante(fabricante2);
		produto2.setPreco(new BigDecimal(45.5D));
		produto2.setQuantidade(10);
		
		pdao.salvar(produto);
		pdao.salvar(produto2);
		
	}
	@Test
	@Ignore
	public void buscarPorCodigo(){
		ProdutoDAO dao = new ProdutoDAO();
		Produto produto = dao.buscarPorCodigo(18L);
		
		System.out.println(produto);
	}
	@Ignore
	@Test
	public void listar(){
		ProdutoDAO dao = new ProdutoDAO();
		
		List<Produto> produtos = dao.listar();
		System.out.println(produtos	);
		
	}
	@Ignore
	@Test
	public void excluir(){
		ProdutoDAO dao = new ProdutoDAO();
		
		Produto produto = dao.buscarPorCodigo(18L);
		
		dao.excluir(produto);
		
	}
	@Ignore
	@Test
	public void editar(){
		ProdutoDAO dao = new ProdutoDAO();
		Produto produto = dao.buscarPorCodigo(19L);
		
		produto.setDescricao("Testando sa porra");
		produto.setPreco(new BigDecimal(6.37D));
		produto.setQuantidade(10);
		
		FabricanteDAO fdao = new FabricanteDAO();
		
		Fabricante fabricante = fdao.buscarPorCodigo(4L);
		produto.setFabricante(fabricante);
		
		dao.editar(produto);
		
		
		
		
	}
}

