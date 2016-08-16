package br.com.armazem.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.armazem.dao.FuncionarioDAO;
import br.com.armazem.domain.Funcionario;

public class FuncionarioDAOTest {

	@Ignore
	@Test
	public void salvar(){
		Funcionario f1 = new Funcionario();
		f1.setCpf("010.486.314-51");
		f1.setNome("Lucas Lima Pinheiro Silva");
		f1.setSenha("123456");
		f1.setFuncao("Varredor");
		
		FuncionarioDAO fdao = new FuncionarioDAO();
		
		fdao.salvar(f1);
		
	}
	@Test
	@Ignore
	public void listar(){
		FuncionarioDAO dao = new FuncionarioDAO();
		List<Funcionario>funcionario = dao.listar();
		
		for(Funcionario funcionarios : funcionario){
			System.out.println(funcionarios);
		}
	}
	@Ignore
	@Test
	public void buscarPorCodigo(){
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario f1 = dao.buscarPorCodigo(12L);
		
		System.out.println(f1);
		
	}
	@Ignore
	@Test
	public void excluir(){
		FuncionarioDAO dao = new FuncionarioDAO();

		Funcionario funcionario = dao.buscarPorCodigo(2L);
		
		dao.excluir(funcionario);
		
	}
	

	@Test
	public void editar(){
		FuncionarioDAO dao = new FuncionarioDAO();

		Funcionario funcionario = dao.buscarPorCodigo(12L);
		funcionario.setNome("Creide Da Silva Moratto");
		
		dao.editar(funcionario);
		
	}
}
