package br.com.armazem.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.armazem.dao.FuncionarioDAO;
import br.com.armazem.dao.VendaDAO;
import br.com.armazem.domain.Funcionario;
import br.com.armazem.domain.Venda;

public class VendaDAOTest {
	

	@Test
	public void salvar(){
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario funcionario = dao.buscarPorCodigo(5L);
		Venda venda = new Venda();
		venda.setFuncionario(funcionario);
		venda.setHorario(new Date());
		venda.setValor(new BigDecimal(15.0D));
		
		VendaDAO vdao = new VendaDAO();
		vdao.salvar(venda);		
	}
	@Ignore
	@Test
	public void listar(){
		VendaDAO dao = new VendaDAO();
		
		List<Venda>vendas = dao.listar();
			
		System.out.println(vendas);
		
			
		}
	@Ignore
	@Test
	public void buscarPorCodigo(){
		VendaDAO dao = new VendaDAO();
		
		Venda venda = dao.buscarPorCodigo(19L);
		
		System.out.println(venda);
	}
	@Ignore
	@Test
	public void excluir(){
		VendaDAO dao = new VendaDAO();
		Venda venda = dao.buscarPorCodigo(19L);
		dao.excluir(venda);
		
	}
	@Ignore
	@Test
	public void editar(){
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario funcionario = dao.buscarPorCodigo(4L);
		
		VendaDAO vdao = new VendaDAO();
		Venda venda = vdao.buscarPorCodigo(19L);
		
		venda.setFuncionario(funcionario);
		venda.setHorario(new Date());
		venda.setValor(new BigDecimal(50.00D));
		
		vdao.editar(venda);
	}
	
}
