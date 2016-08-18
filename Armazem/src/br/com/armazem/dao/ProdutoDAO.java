package br.com.armazem.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.armazem.domain.Produto;
import br.com.armazem.util.HibernateUtil;

public class ProdutoDAO {

		public void inserir(Produto produto){
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
}
