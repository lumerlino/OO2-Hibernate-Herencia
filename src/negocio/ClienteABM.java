package negocio;

import java.util.List;

import dao.ClienteDao;
import datos.Cliente;
import datos.Contacto;
import datos.PersonaFisica;
import datos.PersonaJuridica;

public class ClienteABM {
	private static ClienteABM instancia = null;
	
	protected ClienteABM () {}
	
	public static ClienteABM getInstance() {
		if(instancia==null) {
			instancia=new ClienteABM();
		}
		return instancia;
	}
	
	public Cliente traer(long idCliente) {
		return ClienteDao.getInstance().traer(idCliente);
	}
	
	public PersonaFisica traer(int dni) {
		return ClienteDao.getInstance().traer(dni);
	}
	
	public PersonaJuridica traer(String cuit) {
		return ClienteDao.getInstance().traer(cuit);
	}
	
	public int agregarPersonaFisica(String nroCliente, String apellido, String nombre, int dni, Contacto contacto) throws Exception{
		if (traer(dni) != null) throw new Exception ("ERROR: Ya existe un Cliente con DNI: "+dni);
		PersonaFisica pf = new PersonaFisica(nroCliente, contacto, apellido, nombre, dni);
		return ClienteDao.getInstance().agregar(pf);
	}
	
	public int agregarPersonaJuridica(String nroCliente, String razonSocial, String cuit, Contacto contacto) throws Exception{
		if (traer(cuit) != null) throw new Exception("ERROR: Ya existe el Cliente con CUIT: "+cuit);
		PersonaJuridica pj = new PersonaJuridica(nroCliente, contacto, razonSocial, cuit);
		return ClienteDao.getInstance().agregar(pj);
	}
	
	public List<Cliente> traer(){
		return ClienteDao.getInstance().traer();
	}
	

}
