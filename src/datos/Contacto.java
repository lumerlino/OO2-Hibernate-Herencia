package datos;

public class Contacto {
	private long idContacto;
	private String email;
	private String telefonoFijo;
	private String movil;
	private Cliente cliente;
	
	public Contacto() {}

	public Contacto(String email, String telefonoFijo, String movil, Cliente cliente) {
		super();
		this.email = email;
		this.telefonoFijo = telefonoFijo;
		this.movil = movil;
		this.setCliente(cliente);
	}

	public long getIdContacto() {
		return idContacto;
	}

	protected void setIdContacto(long idContacto) {
		this.idContacto = idContacto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "\nContacto [idContacto=" + idContacto + ", email=" + email + ", telefonoFijo=" + telefonoFijo + ", movil="
				+ movil + "]";
	}
	
	

}
