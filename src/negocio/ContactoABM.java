package negocio;

import dao.ContactoDao;
import datos.Cliente;
import datos.Contacto;

public class ContactoABM {
	private static ContactoABM instancia = null;
	
	protected ContactoABM () {}
	
	public static ContactoABM getInstance() {
		if(instancia==null) {
			instancia=new ContactoABM();
		}
		return instancia;
	}
	
	public Contacto traer(long idContacto) {
		return ContactoDao.getInstance().traer(idContacto);
	}
	
	public Contacto traer(String email) {
		return ContactoDao.getInstance().traer(email);
	}
	
	public int agregar (String email, String telefonoFijo, String movil, Cliente cliente) throws Exception{
		if (traer(email) != null) throw new Exception("Ya existe Cliente con ese Email");
		Contacto c = new Contacto(email, telefonoFijo, movil, cliente);
		return ContactoDao.getInstance().agregar(c);		
	}


}
