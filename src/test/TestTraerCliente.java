package test;

import datos.Cliente;
import datos.PersonaFisica;
import negocio.ClienteABM;

public class TestTraerCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (Cliente c : ClienteABM.getInstance().traer()) {
			if (c instanceof PersonaFisica) {
				System.out.println(c);
			}
		}
		
		
		
		
		

	}

}
