package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TestCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long idCliente=1;		
		System.out.println( ClienteABM.getInstance().traer(idCliente));
		
		long idCliente2 = 2;
		System.out.println( ClienteABM.getInstance().traer(idCliente2));
		
		for (Cliente c: ClienteABM.getInstance().traer()) {
			System.out.println(c);
		}

	}

}
