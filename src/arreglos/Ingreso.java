package arreglos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.ClaseIngreso;




public class Ingreso {
	
	
	
	private String  archivo;
	
 private ArrayList <ClaseIngreso> ci;

 
public Ingreso(String archivo) {
	  ci=new ArrayList <ClaseIngreso>();
	  this.archivo=archivo;
	  
     cargarIngreso();
	
}	
public void adicionar(ClaseIngreso c) {
	ci.add(c);
}

public int tamano() {
	return ci.size();
}

public ClaseIngreso obtener(int i) {
	return ci.get(i);
}

public void eliminar(ClaseIngreso c) {
	ci.remove(c);
}

public ClaseIngreso buscar(int codigo) {
	ClaseIngreso c;
	for (int i = 0; i < tamano(); i++) {
		c = obtener(i);
		if (c.getCodigoIngreso() == codigo)
			return c;
	}
	return null;
}

public int codigoCorrelativo() {
	if (tamano() == 0) {
		return 40001;
	}
	else {
		return obtener(tamano() - 1).getCodigoIngreso() + 1;
	}
}


 //**********************Escribir en texto*******************
public void GrabarIngreso() {
  try {
	  PrintWriter pw;
		String linea;
		ClaseIngreso x;
		pw = new PrintWriter(new FileWriter(archivo));
		for (int i = 0; i < tamano(); i++) {
			x = obtener(i);
			linea = x.getCodigoIngreso() + ";" + x.getCodigoSocio() + ";" + x.getFechaIngreso() + ";"+ x.getHoraIngreso() +";" + x.getNumeroInvitados() + ";"
					+ x.getCostoIngreso() + ";" + x.getEstado() + ";"
					+ x.getEstado();
			pw.println(linea);
		}
		pw.close();
	}
	  
      catch(Exception e){
	  
	  
  }
 
}
	//********************Leer en texto ***************************
	
	public void cargarIngreso() {
		
		
		try {
			BufferedReader br;

			String linea, s[];
			int codIngre, codSoci, Fechaingre, horaIngre, invi,  Estado;
            double costo;
            
			ClaseIngreso nuevo;
			br = new BufferedReader(new FileReader(archivo));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codIngre = Integer.parseInt(s[0].trim());
				codSoci = Integer.parseInt(s[1].trim());
				Fechaingre = Integer.parseInt(s[2].trim());
				horaIngre = Integer.parseInt(s[3].trim());
				invi = Integer.parseInt(s[4].trim());
				costo = Double.parseDouble(s[5].trim());
				Estado = Integer.parseInt(s[6].trim());
				

				nuevo = new ClaseIngreso(codIngre, codSoci, Fechaingre, horaIngre, invi, costo, Estado);
				adicionar(nuevo);
			}
			br.close();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	//**********Confirma la existencia del archivo****
	public boolean existeArchivo() {
		File f = new File(archivo);
		return f.exists();
	}
	
	//**********retorno del texto
	
	public String getArchivo() {
		return archivo;
	}
	
	
}
