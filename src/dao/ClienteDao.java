package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;
import datos.PersonaFisica;
import datos.PersonaJuridica;

public class ClienteDao {
	private static Session session;
	private Transaction tx;
	private static ClienteDao instancia=null;
	
	protected ClienteDao() {}
	
	public static ClienteDao getInstance() {
		if(instancia==null) {
			instancia=new ClienteDao();
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
	
	public int agregar(Cliente objeto) {
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

	public void actualizar(Cliente objeto) throws HibernateException {
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

	public void eliminar(Cliente objeto) throws HibernateException {
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
	
	public Cliente traer(long idCliente) {
		Cliente objeto = null;
		try {
			iniciaOperacion();
			objeto = (Cliente) session.createQuery("from Cliente c where c.idCliente="+idCliente).uniqueResult();
			Hibernate.initialize(objeto.getContacto());
		}finally {
			session.close();
		}
		return objeto;
	}
	
	public PersonaFisica traer(int dni) throws HibernateException {
		PersonaFisica objeto = null;
		try {
			iniciaOperacion();
			objeto = (PersonaFisica) session.createQuery("from PersonaFisica pf where pf.dni=" + dni).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public PersonaJuridica traer(String cuit) throws HibernateException {
		PersonaJuridica objeto = null;
		try {
			iniciaOperacion();
			objeto = (PersonaJuridica) session.createQuery("from PersonaJuridica pj where pj.cuit='" + cuit + "'").uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> traer() throws HibernateException{
		List<Cliente> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Cliente").list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	


}
