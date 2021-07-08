package test;

import datos.Cliente;
import negocio.ClienteABM;
import negocio.ContactoABM;


public class TestAgregarContactoACliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			long idCliente = 3;
			long idContacto = 0;
			Cliente cliente = ClienteABM.getInstance().traer(idCliente);
			idContacto = ContactoABM.getInstance().agregar("merlinolucia@gmail", "42147737", "15340236", cliente);
			System.out.println(cliente + "\n" + ContactoABM.getInstance().traer(idContacto));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
