package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Contacto;

public class ContactoDao {
	private static Session session;
	private Transaction tx;
	private static ContactoDao instancia=null;
	
	protected ContactoDao() {}
	
	public static ContactoDao getInstance() {
		if(instancia==null) {
			instancia=new ContactoDao();
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
	
	public int agregar(Contacto objeto) {
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

	public void actualizar(Contacto objeto) throws HibernateException {
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

	public void eliminar(Contacto objeto) throws HibernateException {
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
	
	public Contacto traer(long idContacto) {
		Contacto objeto = null;
		try {
			iniciaOperacion();
			objeto = (Contacto) session.createQuery("from Contacto c where c.idContacto="+idContacto).uniqueResult();
		}finally {
			session.close();
		}
		return objeto;
	}
	
	public Contacto traer(String email) {
		Contacto objeto = null;
		try {
			iniciaOperacion();
			objeto = (Contacto) session.createQuery("from Contacto c where c.email='"+email+"'").uniqueResult();
		}finally {
			session.close();
		}
		return objeto;
	}

}
