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
	
	@Ignore
	@Test
	public void salvar(){
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario funcionario = dao.buscarPorCodigo(4L);
		
		Venda venda = new Venda();
		venda.setFuncionario(funcionario);
		venda.setHorario(new Date());
		venda.setValor(new BigDecimal(15.56D));
		
		VendaDAO vdao = new VendaDAO();
		vdao.salvar(venda);
		
		Funcionario funcionario2 = dao.buscarPorCodigo(5L);
		
		Venda venda2 = new Venda();
		venda2.setFuncionario(funcionario2);
		venda2.setHorario(new Date());
		venda2.setValor(new BigDecimal(90.00D));
		
		vdao.salvar(venda2);
		
	}
	
	@Test
	public void listar(){
		VendaDAO dao = new VendaDAO();
		
			List<Venda>vendas = dao.listar();
			
			System.out.println(vendas);
		
			
		}
	
	@Test
	public void buscarPorCodigo(){
		VendaDAO dao = new VendaDAO();
		
		Venda venda = dao.buscarPorCodigo(19L);
		
		System.out.println(venda);
	}
	
	@Test
	public void excluir(){
		VendaDAO dao = new VendaDAO();
		Venda venda = dao.buscarPorCodigo(19L);
		dao.excluir(venda);
		
	}
	
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
