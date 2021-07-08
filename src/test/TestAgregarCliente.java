package test;

import negocio.ClienteABM;

public class TestAgregarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			long id=0;
			ClienteABM.getInstance().agregarPersonaFisica("33333333", "Merlino", "Lucia", 40008847, null);
			System.out.println(ClienteABM.getInstance().traer(id) );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			long id=0;
			ClienteABM.getInstance().agregarPersonaJuridica("44444444", "La Serenisima", "330-25-587", null);
			System.out.println(ClienteABM.getInstance().traer(id) );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
