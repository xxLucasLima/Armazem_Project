package br.com.armazem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

import br.com.armazem.domain.Venda;
import br.com.armazem.util.HibernateUtil;

@SuppressWarnings("deprecation")
public class VendaDAO {

	public void salvar(Venda venda){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try{
			transacao = sessao.beginTransaction();
			sessao.save(venda);
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
	public List<Venda> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Venda> venda = null;

		try{
			Query consulta = sessao.getNamedQuery("Produto.listar");
			venda = consulta.list();

		}catch(RuntimeException ex){ 
			throw ex;
		}finally{
			sessao.close();
		}	
		return venda;
	}
	@SuppressWarnings({ "rawtypes" })
	public Venda buscarPorCodigo(Long codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Venda venda = null;

		try{
			Query consulta = sessao.getNamedQuery("Produto.buscarPorCodigo");
			consulta.setLong("codigo", codigo);

			venda = (Venda) consulta.uniqueResult();

		}catch(RuntimeException ex){ 
			throw ex;
		}finally{
			sessao.close();
		}	
		return venda;
	}
	public void excluir (Venda venda){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try{
			transacao = sessao.beginTransaction();
			sessao.delete(venda);
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
	public void editar(Venda venda) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(venda);
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


