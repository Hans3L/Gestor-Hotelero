package arreglos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.ClaseBungalow;
import clases.ClaseProducto;

public class Bungalow {
	
	    private ArrayList <ClaseBungalow> cb;
	    private String archivo;
	    

		public Bungalow(String archivo) {

			cb= new ArrayList<ClaseBungalow> ();
			
			/*cb.add(new ClaseBungalow(30001, 0,100,0 ));
			cb.add(new ClaseBungalow(30002, 1,200,0 ));
			cb.add(new ClaseBungalow(30003, 2,500,0 ));
			*/
			this.archivo=archivo;
			cargarBungalow();
		}
	
	public  void adicionar(ClaseBungalow e) {
	    	
	    	cb.add(e);
	    }
	
	 public int  tamano(){
		
		return cb.size();
	}
	 
 public ClaseBungalow  obtener (int index) {
	 
	  return cb.get(index);
	 
 }
 
    public void eliminar(ClaseBungalow index) {
    	
    	cb.remove(index);
    }
    
    public  ClaseBungalow buscar(int j) {
    	ClaseBungalow cb;
    	for (int i = 0; i < tamano(); i++) {
			cb=obtener(i);
			if (cb.getNumeroBungalow()==j) 
				return cb;
			
		}
    	return null;
    }
    
    public int codigoCorrelativo() {
   	 
   	 if (tamano()==0) {
   		 return 30001;
   	 }
   	 else {
   		 return obtener(tamano()-1).getNumeroBungalow()+1;
   	 }
    }
    
//***************Grabar texto y carga**************
   
    
    public void GrabarBungalow() {
   	  try {
   		  PrintWriter pw;
   			String linea;
   			ClaseBungalow x;
   			pw = new PrintWriter(new FileWriter(archivo));
   			for (int i = 0; i < tamano(); i++) {
   				x = obtener(i);
   				linea = x.getNumeroBungalow()+ ";" + x.getCategoria() + ";" + x.getPrecioDia() + ";" + x.getEstado() + ";"
   						 ;
   				pw.println(linea);
   			}
   			pw.close();
   		}
   		  
   	      catch(Exception e){
   		  
   		  
   	  }
   	 
   	}
  //********************Leer en texto ***************************
  	 /*
  	  * 
  	  * public ClaseBungalow (int numeroBungalow, int categoria,double precioDia,int estado ){
  	  * 
  	  */
    public void cargarBungalow() {
		
		
		try {
			BufferedReader br;

			String linea, s[];
			int numBun,categoria,estado;
			double precioDia;
         
            
            ClaseBungalow nuevo;
			br = new BufferedReader(new FileReader(archivo));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				numBun = Integer.parseInt(s[0].trim());
				categoria = Integer.parseInt(s[1].trim());
				precioDia = Double.parseDouble(s[2].trim());
				estado = Integer.parseInt(s[3].trim());
				
			
				

				nuevo = new ClaseBungalow(numBun, categoria, precioDia, estado);
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
