package br.com.armazem.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

import br.com.armazem.domain.Produto;
import br.com.armazem.util.HibernateUtil;

public class ProdutoDAO {

		public void salvar(Produto produto){
			Session sessao = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = null;
			
			try{
				transacao = sessao.beginTransaction();
				sessao.save(produto);
				transacao.commit();
				
			}catch(RuntimeException ex){ 
				if(transacao != null){
				transacao.rollback();
				}
				throw ex;
			}finally{
				sessao.close();
			}	
		}
		@SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
		public List<Produto> listar(){
			Session sessao = HibernateUtil.getSessionFactory().openSession();
			List<Produto> produtos = null;
			
			try{
				Query consulta = sessao.getNamedQuery("Produto.listar");
				produtos = consulta.list();
				
			}catch(RuntimeException ex){ 
				throw ex;
				}finally{
				sessao.close();
			}	
			return produtos;
		}
		@SuppressWarnings({"deprecation", "rawtypes" })
		public Produto buscarPorCodigo(Long codigo){
			Session sessao = HibernateUtil.getSessionFactory().openSession();
			Produto produto = null;
			
			try{
				Query consulta = sessao.getNamedQuery("Produto.buscarPorCodigo");
				consulta.setLong("codigo", codigo);
				
				produto = (Produto) consulta.uniqueResult();
				
			}catch(RuntimeException ex){ 
				throw ex;
				}finally{
				sessao.close();
			}	
			return produto;
		}
}
