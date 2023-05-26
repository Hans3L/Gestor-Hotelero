package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;


import clases.ClaseSocio;

public class Socio {
	
	private String archivo;
	
	private ArrayList <ClaseSocio> cs;
	//private int code = 10001;
	
	public Socio(String archivo ){
		
		cs = new ArrayList <ClaseSocio> ();
		/*
		cs.add(new ClaseSocio( 10001,"70069905","Ana","gamboa","99999999"));
		cs.add(new ClaseSocio( 10002,"70068505","Sofia","Lanzaduri","98989898"));
		cs.add(new ClaseSocio( 10003,"70048305","Kiara","Benavente","9797979797"));
		cs.add(new ClaseSocio( 10004,"70168305","Rebeca","Maldini","9696969696"));
		*/
		this.archivo=archivo;
		cargarSocio();
	}
	
	//operaciones basicas
	 
	//adicionar
	
     public void adicionar(ClaseSocio e){
        	
        cs.add(e);
        }	
	
	//eliminar
	
     public void  eliminar(ClaseSocio cl) {
    	 
    	 cs.remove(cl);
    	 
     }
     
	//tamaño
     
     public int tamano() {
    	 
    	return  cs.size();
    	 
     }
     
	//obtener 
     
     public ClaseSocio obtener(int index) {
    	 
    	 return cs.get(index);
    	 
     }
     
     
	//buscar
     
	public ClaseSocio buscar (int i) {
		ClaseSocio cs;
     for(int j=0; j<tamano();j++) {
    	 cs=obtener(j);
    	  if (cs.getCodigoSocio()==i ) 
			return cs;
      }
     return null;
	}
	//correlativo
	
     public int codigoCorrelativo() {
    	 
    	 if (tamano()==0) {
    		 return 10005;
    	 }
    	 else {
    		 return obtener(tamano()-1).getCodigoSocio()+1;
    	 }
     }
     
     //***************Grabar texto y carga**************
     
     
      
      
     public void GrabarSocio() {
    	  try {
    		  PrintWriter pw;
    			String linea;
    			ClaseSocio x;
    			pw = new PrintWriter(new FileWriter(archivo));
    			for (int i = 0; i < tamano(); i++) {
    				x = obtener(i);
    				linea = x.getCodigoSocio()+ ";" + x.getDni() + ";" + x.getNombres() + ";" + x.getApellidos() + ";"
    						+ x.getTelefono() ;
    				pw.println(linea);
    			}
    			pw.close();
    		}
    		  
    	      catch(Exception e){
    		  
    		  
    	  }
    	 
    	}
    		//********************Leer en texto ***************************
    		
    		public void cargarSocio() {
    			
    			
    			try {
    				BufferedReader br;

    				String linea, s[];
    				int codigoSo;
    	            String  dni , nombres , apellidos , telefono ;
    	            
    				ClaseSocio nuevo;
    				br = new BufferedReader(new FileReader(archivo));
    				while ((linea = br.readLine()) != null) {
    					s = linea.split(";");
    					codigoSo = Integer.parseInt(s[0].trim());
    					dni = (s[1].trim());
    					nombres = (s[2].trim());
    					apellidos = (s[3].trim());
    					telefono = (s[4].trim());
    				
    					

    					nuevo = new ClaseSocio(codigoSo, dni, nombres, apellidos, telefono);
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
