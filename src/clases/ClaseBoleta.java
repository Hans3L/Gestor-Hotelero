package clases;

public class ClaseBoleta {
	  int codigoBoleta;
	 int codigoIngreso;
	 double pagoTotal;
	 
	 
	 public ClaseBoleta(int codigoBoleta,int codigoIngreso,double pagoTotal){
		 super();
		 this.codigoBoleta=codigoBoleta;
		 this.codigoIngreso=codigoIngreso;
		 this.pagoTotal=pagoTotal;
	 }


	public int getCodigoBoleta() {
		return codigoBoleta;
	}


	public void setCodigoBoleta(int codigoBoleta) {
		this.codigoBoleta = codigoBoleta;
	}


	public int getCodigoIngreso() {
		return codigoIngreso;
	}


	public void setCodigoIngreso(int codigoIngreso) {
		this.codigoIngreso = codigoIngreso;
	}


	public double getPagoTotal() {
		return pagoTotal;
	}


	public void setPagoTotal(double pagoTotal) {
		this.pagoTotal = pagoTotal;
	}
	 
}
