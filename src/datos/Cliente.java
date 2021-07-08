package datos;

import java.util.Set;

public class Cliente {
	private long idCliente;
	private String nroCliente;
	private Contacto contacto;
	private Set<InscripcionAfip> inscripcionAfip;
	
	public Cliente() {}

	public Cliente(String nroCliente, Contacto contacto) {
		super();
		this.nroCliente = nroCliente;
		this.setContacto(contacto);
	}

	public long getIdCliente() {
		return idCliente;
	}

	protected void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(String nroCliente) {
		this.nroCliente = nroCliente;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public Set<InscripcionAfip> getInscripcionAfip() {
		return inscripcionAfip;
	}

	public void setInscripcionAfip(Set<InscripcionAfip> inscripcionAfip) {
		this.inscripcionAfip = inscripcionAfip;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nroCliente=" + nroCliente + "]";
	}
	
	

}
