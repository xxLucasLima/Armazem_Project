package br.com.armazem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

import br.com.armazem.domain.Item;
import br.com.armazem.util.HibernateUtil;

@SuppressWarnings("deprecation")
public class ItemDAO {

	public void salvar(Item item){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try{
			transacao = sessao.beginTransaction();
			sessao.save(item);
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Item> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Item> item = null;

		try{
			Query consulta = sessao.getNamedQuery("Produto.listar");
			item = consulta.list();

		}catch(RuntimeException ex){ 
			throw ex;
		}finally{
			sessao.close();
		}	
		return item;
	}
	@SuppressWarnings({ "rawtypes" })
	public Item buscarPorCodigo(Long codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Item item = null;

		try{
			Query consulta = sessao.getNamedQuery("Produto.buscarPorCodigo");
			consulta.setLong("codigo", codigo);

			item = (Item) consulta.uniqueResult();

		}catch(RuntimeException ex){ 
			throw ex;
		}finally{
			sessao.close();
		}	
		return item;
	}
	public void excluir (Item item){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try{
			transacao = sessao.beginTransaction();
			sessao.delete(item);
			transacao.commit();
		}catch (RuntimeException ex){
			if(transacao != null){
				transacao.rollback();
			}
			throw ex;
		} finally{
			sessao.close();
		}
	}
	public void editar(Item item) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(item);
			transacao.commit();
		} catch (Exception ex) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}
	}

}



