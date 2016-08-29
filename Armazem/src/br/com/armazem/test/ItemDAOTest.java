package br.com.armazem.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.armazem.dao.ItemDAO;
import br.com.armazem.dao.ProdutoDAO;
import br.com.armazem.dao.VendaDAO;
import br.com.armazem.domain.Item;
import br.com.armazem.domain.Produto;
import br.com.armazem.domain.Venda;

public class ItemDAOTest {
	
	@Test
	public void salvar(){
	ProdutoDAO pdao = new ProdutoDAO();
	Produto produto = pdao.buscarPorCodigo(8L);
	
	VendaDAO vdao = new VendaDAO();
	Venda venda = vdao.buscarPorCodigo(6L);
	
	Item item = new Item();
	item.setProduto(produto);
	item.setQuantidade(2);
	item.setValorParcial(new BigDecimal(15.60D));
	item.setVenda(venda);

	ItemDAO idao = new ItemDAO();
	idao.salvar(item);
	
	}	
	@Ignore
	@Test
	public void listar(){
		ItemDAO idao = new ItemDAO();
		
		List<Item>itens = idao.listar();
		
		System.out.println(itens);
		
	}
	@Ignore
	@Test
	public void buscarPorCodigo(){
		ItemDAO idao = new ItemDAO();
		
		Item item = idao.buscarPorCodigo(22L);
		
		System.out.println(item);
			
	}
	@Test
	@Ignore
	public void excluir(){
		ItemDAO idao = new ItemDAO();
		
		Item item = idao.buscarPorCodigo(22L);
		
		idao.excluir(item);
	}
	@Test
	@Ignore
	public void editar(){
		ProdutoDAO pdao = new ProdutoDAO();
		Produto produto = pdao.buscarPorCodigo(11L);
		
		VendaDAO vdao = new VendaDAO();
		Venda venda = vdao.buscarPorCodigo(19L);
		
		ItemDAO idao = new ItemDAO();
		Item item = idao.buscarPorCodigo(22L);
		
		item.setProduto(produto);
		item.setVenda(venda);
		item.setQuantidade(5);
		item.setValorParcial(new BigDecimal(35.00D));
		
		idao.editar(item);
		
		
		
	}
}

