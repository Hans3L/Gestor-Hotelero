package arreglos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.ClaseProducto;


public class Producto {

  	 private ArrayList <ClaseProducto> cp; 
	 private String archivo;
	 
	 
  	public Producto(String archivo){
  		cp = new ArrayList <ClaseProducto> ();
  		/*
  		cp.add(new ClaseProducto( 20001,"Cerveza inglesa 250 ml",10,15.5));
  		cp.add(new ClaseProducto( 20002,"Snack mix Gigante",8,20.5));
  		cp.add(new ClaseProducto( 20003,"Botella de Champange",2,50.0));
  		cp.add(new ClaseProducto( 20004,"Wisky Label Red",20,200.0));
  		cp.add(new ClaseProducto( 20005,"Preservativos Piel",150,25.0));
*/
  		this.archivo=archivo;
  		cargarProducto();
	}
  	 
  	 
  //adicionar
	
    public void adicionar(ClaseProducto cl){
       	
       cp.add(cl);
       }	
	
	//eliminar
	
    public void  eliminar(ClaseProducto cl) {
   	 
   	 cp.remove(cl);
   	 
    }
    
	//tamaño
    
    public int tamano() {
   	 
   	return  cp.size();
   	 
    }
    
	//obtener 
    
    public ClaseProducto obtener(int index) {
   	 
   	 return cp.get(index);
   	 
    }
    
    
	//buscar
    
	public ClaseProducto buscar (int i) {
		ClaseProducto cp;
    for(int j=0; j<tamano();j++) {
   	 cp=obtener(j);
   	  if (cp.getCodigoProducto()==i ) 
			return cp;
		
   	 
     }
    return null;
	}
    public int codigoCorrelativo() {
   	 
   	 if (tamano()==0) {
   		 return 20006;
   	 }
   	 else {
   		 return obtener(tamano()-1).getCodigoProducto()+1;
   	 }
    }
    //***************Grabar texto y carga**************
   
    
    public void GrabarProducto() {
   	  try {
   		  PrintWriter pw;
   			String linea;
   			ClaseProducto x;
   			pw = new PrintWriter(new FileWriter(archivo));
   			for (int i = 0; i < tamano(); i++) {
   				x = obtener(i);
   				linea = x.getCodigoProducto()+ ";" + x.getDetalle() + ";" + x.getStock() + ";" + x.getPrecioUnitario() + ";"
   						 ;
   				pw.println(linea);
   			}
   			pw.close();
   		}
   		  
   	      catch(Exception e){
   		  
   		  
   	  }
   	 
   	}
  //********************Leer en texto ***************************
  	 
    public void cargarProducto() {
		
		
		try {
			BufferedReader br;

			String linea, s[];
			int codiPro,stock;
			double preuni;
            String  detalle ;
            
			ClaseProducto nuevo;
			br = new BufferedReader(new FileReader(archivo));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codiPro = Integer.parseInt(s[0].trim());
				detalle = (s[1].trim());
				stock = Integer.parseInt(s[2].trim());
				preuni = Double.parseDouble(s[3].trim());
				
			
				

				nuevo = new ClaseProducto(codiPro, detalle, stock, preuni);
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
