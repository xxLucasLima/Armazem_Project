package br.com.armazem.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.armazem.domain.Fabricante;
import br.com.armazem.util.HibernateUtil;

@SuppressWarnings("deprecation")
public class FabricanteDAO {

	public void salvar(Fabricante fabricante) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(fabricante);
			transacao.commit();
		} catch (Exception ex) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Fabricante> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Fabricante> fabricantes = null;

		try {
			Query consulta = sessao.getNamedQuery("Fabricante.listar");
			fabricantes = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;

		} finally {
			sessao.close();
		}
		return fabricantes;
	}

	@SuppressWarnings({ "rawtypes" })
	public Fabricante buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Fabricante fabricante = null;

		try {
			Query consulta = sessao.getNamedQuery("Fabricante.buscarPorCodigo");
			consulta.setLong("codigo", codigo);

			fabricante = (Fabricante) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;

		} finally {
			sessao.close();
		}
		return fabricante;
	}

	public void excluir(Long codigo) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			Fabricante fabricante = buscarPorCodigo(codigo);
			sessao.delete(fabricante);
			transacao.commit();
		} catch (Exception ex) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}
	}

	public void editar(Fabricante fabricante) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(fabricante);
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
