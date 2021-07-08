package datos;

public class InscripcionAfip {
	private long idInscripcionAfip;
	private String inscripcionAfip;
	private Cliente cliente;
	
	public InscripcionAfip() {}

	public InscripcionAfip(String inscripcionAfip, Cliente cliente) {
		super();
		this.inscripcionAfip = inscripcionAfip;
		this.setCliente(cliente);
	}

	public long getIdInscripcionAfip() {
		return idInscripcionAfip;
	}

	protected void setIdInscripcionAfip(long idInscripcionAfip) {
		this.idInscripcionAfip = idInscripcionAfip;
	}

	public String getInscripcionAfip() {
		return inscripcionAfip;
	}

	public void setInscripcionAfip(String inscripcionAfip) {
		this.inscripcionAfip = inscripcionAfip;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "\nInscripcionAfip [idInscripcionAfip=" + idInscripcionAfip + ", inscripcionAfip=" + inscripcionAfip + "]";
	}
	
	

}
