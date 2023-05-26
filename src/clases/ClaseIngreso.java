package clases;

public class ClaseIngreso {
	int codigoIngreso,codigoSocio;
	 int fechaIngreso, horaIngreso ; 
	int numeroInvitados;
	double  costoIngreso ;
	int estado;
	
	

	public ClaseIngreso(int codigoIngreso, int codigoSocio, int fechaIngreso, int horaIngreso,
			int numeroInvitados, double costoIngreso, int estado) {
		super();
		this.codigoIngreso = codigoIngreso;
		this.codigoSocio = codigoSocio;
		this.fechaIngreso = fechaIngreso;
		this.horaIngreso = horaIngreso;
		this.numeroInvitados = numeroInvitados;
		this.costoIngreso = costoIngreso;
		this.estado = estado;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getNumeroInvitados() {
		return numeroInvitados;
	}

	public void setNumeroInvitados(int numeroInvitados) {
		this.numeroInvitados = numeroInvitados;
	}

	public int getCodigoSocio() {
		return codigoSocio;
	}

	public void setCodigoSocio(int codigoSocio) {
		this.codigoSocio = codigoSocio;
	}

	public int getCodigoIngreso() {
		return codigoIngreso;
	}

	public void setCodigoIngreso(int codigoIngreso) {
		this.codigoIngreso = codigoIngreso;
	}

	public int getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(int horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	public int getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(int fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public double getCostoIngreso() {
		return costoIngreso;
	}

	public void setCostoIngreso(double costoIngreso) {
		this.costoIngreso = costoIngreso;
	}
	
	
	
}
