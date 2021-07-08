package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TestTraerClienteYContacto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		long idCliente = 3;
		Cliente c = ClienteABM.getInstance().traer(idCliente);
		System.out.println(c + "\n" + c.getContacto());
		
	}

}
