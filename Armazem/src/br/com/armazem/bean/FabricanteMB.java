package br.com.armazem.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.armazem.dao.FabricanteDAO;
import br.com.armazem.domain.Fabricante;
import br.com.armazem.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FabricanteMB {
	private Fabricante fabricante;
	private List<Fabricante> listaFabricantes;
	private List<Fabricante> listaFabricantesFiltrados;
	
	public List<Fabricante> getListaFabricantes() {
		return listaFabricantes;
	}

	public void setListaFabricantes(List<Fabricante> listaFabricantes) {
		this.listaFabricantes = listaFabricantes;
	}

	public List<Fabricante> getListaFabricantesFiltrados() {
		return listaFabricantesFiltrados;
	}

	public void setListaFabricantesFiltrados(List<Fabricante> listaFabricantesFiltrados) {
		this.listaFabricantesFiltrados = listaFabricantesFiltrados;
	}

	public Fabricante getFabricante() {
		if (fabricante == null){
			fabricante = new Fabricante();
		}
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public void novo(){
		fabricante = new Fabricante();
	}
	
	public void salvar(){
		FabricanteDAO dao = new FabricanteDAO();
		dao.salvar(fabricante);
		
		fabricante = new Fabricante();
		try{
		FacesUtil.adicionarMsgInfo("Fabricante salvo com sucesso");
		}catch (RuntimeException e){
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar salvar um fabricante" + e.getMessage());
		}
	}
	
	public void carregarPesquisa(){
		try{
			FabricanteDAO dao = new FabricanteDAO();
			listaFabricantes = dao.listar();
			
		}catch(RuntimeException e){
			FacesUtil.adicionarMsgErro(" Erro ao tentar acessar listagem fabricantes" + e.getMessage());
		}
	}
	public void carregarCadastro(){
		try{
			String valor = FacesUtil.getParam("fabcod");
			
			if(valor != null){
				Long codigo = Long.parseLong(valor);
				
				FabricanteDAO dao = new FabricanteDAO();
				
				fabricante = dao.buscarPorCodigo(codigo);
			}
			
		}catch(RuntimeException e){
			FacesUtil.adicionarMsgErro(" Erro ao tentar obter os dados do fabricante" + e.getMessage());
		}
		
	}
	public void excluir(){
		FabricanteDAO dao = new FabricanteDAO();
		dao.excluir(fabricante);
		
		try{
		FacesUtil.adicionarMsgInfo("Fabricante excluido com sucesso");
		}catch (RuntimeException e){
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar excluir um fabricante" + e.getMessage());
		}
	}
	public void editar(){
		FabricanteDAO dao = new FabricanteDAO();
		dao.editar(fabricante);
		
		try{
		FacesUtil.adicionarMsgInfo("Fabricante editado com sucesso");
		}catch (RuntimeException e){
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar editar um fabricante" + e.getMessage());
		}
	}
}
