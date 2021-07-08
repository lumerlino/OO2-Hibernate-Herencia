package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.InscripcionAfip;

public class InscripcionAfipDao {
	private static Session session;
	private Transaction tx;
	private static InscripcionAfipDao instancia=null;
	
	protected InscripcionAfipDao() {}
	
	public static InscripcionAfipDao getInstance() {
		if(instancia==null) {
			instancia=new InscripcionAfipDao();
		}
		return instancia;
	}
	
	protected void iniciaOperacion() throws HibernateException { 
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	protected void manejaExcepcion(HibernateException he) throws HibernateException { 
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public int agregar(InscripcionAfip objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}

	public void actualizar(InscripcionAfip objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public void eliminar(InscripcionAfip objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public InscripcionAfip traer(long idInscripcionAfip) {
		InscripcionAfip objeto = null;
		try {
			iniciaOperacion();
			objeto = (InscripcionAfip) session.createQuery("from InscripcionAfip ins where ins.idInscripcionAfip="+idInscripcionAfip).uniqueResult();
			//Hibernate.initialize(objeto.getCliente());
		}finally {
			session.close();
		}
		return objeto;
	}
	
	public InscripcionAfip traer(String inscripcionAfip) {
		InscripcionAfip objeto = null;
		try {
			iniciaOperacion();
			objeto = (InscripcionAfip) session.createQuery("from InscripcionAfip ins where ins.inscripcionAfip='"+inscripcionAfip+"'").uniqueResult();
			//Hibernate.initialize(objeto.getCliente());
		}finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<InscripcionAfip> traerInscripcionesAfipPorCliente(long idCliente) throws HibernateException{
		List<InscripcionAfip> lista = null;
		try {
			iniciaOperacion();
			String hQL = "from InscripcionAfip ins inner join fetch ins.cliente c where c.idCliente=" + idCliente;
			lista = session.createQuery(hQL).list();
		} finally {
			session.close();
		}
		return lista;
	}

}
