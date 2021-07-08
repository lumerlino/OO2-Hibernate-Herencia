package negocio;

import java.util.List;

import dao.InscripcionAfipDao;
import datos.Cliente;
import datos.InscripcionAfip;

public class InscripcionAfipABM {
	private static InscripcionAfipABM instancia = null;
	
	protected InscripcionAfipABM () {}
	
	public static InscripcionAfipABM getInstance() {
		if(instancia==null) {
			instancia=new InscripcionAfipABM();
		}
		return instancia;
	}
	
	public InscripcionAfip traer(long idInscripcionAfip) {
		return InscripcionAfipDao.getInstance().traer(idInscripcionAfip);
	}
	
	public InscripcionAfip traer (String inscripcionAfip) {
		return InscripcionAfipDao.getInstance().traer(inscripcionAfip);
	}
	
	public int agregar(String inscripcionAfip, Cliente cliente) throws Exception{
		if (traer(inscripcionAfip) != null) throw new Exception("Ya existe InscripcionAfip: "+inscripcionAfip);
		InscripcionAfip ins = new InscripcionAfip(inscripcionAfip, cliente);
		return InscripcionAfipDao.getInstance().agregar(ins);
	}
	
	public List<InscripcionAfip> traerInscripcionAfipPorCliente(long idCliente){
		return InscripcionAfipDao.getInstance().traerInscripcionesAfipPorCliente(idCliente);
	}

}
