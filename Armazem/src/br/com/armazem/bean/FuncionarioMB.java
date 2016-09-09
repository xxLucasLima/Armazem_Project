
package br.com.armazem.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

	
import br.com.armazem.domain.Funcionario;
import br.com.armazem.util.FacesUtil;

	@ManagedBean
	@ViewScoped
	public class FuncionarioMB {
		private Funcionario funcionario;
		
		public Funcionario getFuncionario() {
			if (funcionario == null){
				funcionario = new Funcionario();
			}
			return funcionario;
		}

		public void setFuncionario(Funcionario funcionario) {
			this.funcionario = funcionario;
		}

		public void salvar(){
			FacesUtil.adicionarMsgInfo("Funcionario salvo com sucesso");
			
		}
	}
