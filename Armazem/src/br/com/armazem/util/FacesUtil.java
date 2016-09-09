package br.com.armazem.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import java.util.Map;

public class FacesUtil {
	public static void adicionarMsgInfo (String msg){
		FacesMessage f = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null, f);
		
	}
	public static void adicionarMsgErro (String msg){
		FacesMessage f = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null, f);
		
	}
	
	public static String getParam(String nome){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		ExternalContext externalContext = facesContext.getExternalContext();
		
		Map<String, String> parametros = externalContext.getRequestParameterMap();
		
		String valor = parametros.get(nome);
		
		return valor;
	}
}
