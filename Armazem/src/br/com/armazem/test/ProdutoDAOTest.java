package br.com.armazem.test;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.armazem.dao.FabricanteDAO;
import br.com.armazem.dao.ProdutoDAO;
import br.com.armazem.domain.Fabricante;
import br.com.armazem.domain.Produto;

public class ProdutoDAOTest {
	
	
	@Test
	public void inserir(){
		Fabricante fabricante = new Fabricante();
		FabricanteDAO dao = new FabricanteDAO();
		
		fabricante = dao.buscarPorCodigo(4L);
		
		Produto produto = new Produto();
		ProdutoDAO pdao = new ProdutoDAO();
		produto.setDescricao("Descrição X");
		produto.setFabricante(fabricante);
		produto.setPreco(new BigDecimal(22.5));
		produto.setQuantidade(17);
		
		pdao.inserir(produto);
		
	}
}

