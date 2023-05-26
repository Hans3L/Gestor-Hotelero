package clases;

public class ClaseSocio {
	int codigoSocio ;
	String nombres ;
	String apellidos ;
	String dni ;
	String telefono ;
	
	//constructor
	public  ClaseSocio(int codigoSocio,String dni ,String nombres ,String apellidos ,String telefono ){
	super();
	this.codigoSocio=codigoSocio ;
	this.nombres=nombres;
	this.apellidos=apellidos;
	this.dni=dni;
	this.telefono=telefono;
	
	}

//metodos
	public int getCodigoSocio() {
		return codigoSocio;
	}


	public void setCodigoSocio(int codigoSocio) {
		this.codigoSocio = codigoSocio;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
	
	
	
}
