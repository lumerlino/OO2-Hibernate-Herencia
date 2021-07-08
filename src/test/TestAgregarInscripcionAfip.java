package test;

import datos.Cliente;
import negocio.ClienteABM;
import negocio.InscripcionAfipABM;

public class TestAgregarInscripcionAfip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			long id = 3;
			InscripcionAfipABM.getInstance().agregar("Empresa de Trabajo", ClienteABM.getInstance().traer(id));
			Cliente c = ClienteABM.getInstance().traer(id);
			System.out.println(c + ", " + InscripcionAfipABM.getInstance().traerInscripcionAfipPorCliente(id));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
