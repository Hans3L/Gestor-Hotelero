package libreria;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JComboBox;
public class Fecha {

	public static void colocarMeses(JComboBox <Object> cbo) {
		cbo.addItem("Enero");
		cbo.addItem("Febrero");
		cbo.addItem("Marzo");
		cbo.addItem("Abril");
		cbo.addItem("Mayo");
		cbo.addItem("Junio");
		cbo.addItem("Julio");
		cbo.addItem("Agosto");
		cbo.addItem("Setiembre");
		cbo.addItem("Octubre");
		cbo.addItem("Noviembre");
		cbo.addItem("Diciembre");
	}
	
	public static void diaActual(JComboBox <Object> cbo) {
		Calendar calendario = new GregorianCalendar();
		cbo.setSelectedIndex(calendario.get(Calendar.DAY_OF_MONTH)-1);
		
	}
	
	public static  void mesActual(JComboBox cbo) {
		Calendar calendario = new GregorianCalendar();
		cbo.setSelectedIndex(calendario.get(Calendar.MONTH));
		/*Error de mes
		 * cbo.setSelectedIndex(calendario.get.MONTH));/*
		 */
		
	}
	
	public static int anioActual(JComboBox <Object> cbo ) {
		Calendar calendario = new GregorianCalendar();
		return calendario.get(Calendar.YEAR);
	}
	/*
	public static void anioActual(JComboBox cbo) {
		
		Calendar calendario = new GregorianCalendar();
		cbo.setSelectedIndex(calendario.get(Calendar.YEAR));
	}
	*/
	//**********************Fijar dia 1 al 31 ************************************************************
	public static void colocarItems(JComboBox<String> cbo, int inicio, int fin) {
		if (inicio < fin)
			while (inicio <= fin) {
				cbo.addItem("" + inicio);
				inicio++;
			}
		else
			while (inicio >= fin) {
				cbo.addItem("" + inicio);
				inicio--;
			}
	}
	
	//*****************************************************************
	//Hora del sistema
	public static int obtenerHoraActual() {
		String minuto = "";
		String segundo = "";

		Calendar calendario = new GregorianCalendar();

		int h = calendario.get(Calendar.HOUR_OF_DAY);

		int m = calendario.get(Calendar.MINUTE);
		if (m < 10)
			minuto = "0" + m;
		else
			minuto = "" + m;

		int s = calendario.get(Calendar.SECOND);
		if (s < 10)
			segundo = "0" + s;
		else
			segundo = "" + s;

		return Integer.parseInt(h + minuto + segundo);
	}
	
	//************************Obtener fecha completa para mandar a la tabla
	public static int getFecha(JComboBox<String> dia, JComboBox<String> mes, JComboBox<String> año) {
		int dd = dia.getSelectedIndex() + 1, mm = mes.getSelectedIndex() + 1,
				aa = Integer.parseInt(año.getSelectedItem().toString());
		return (aa * 100 + mm) * 100 + dd;
	}
	
	//formateando la fecha
	
	public static String dd_mm_aaaa(int fecha) {
		String s = "" + fecha;
		return "" + s.charAt(6) + s.charAt(7) + '/' + s.charAt(4) + s.charAt(5) + '/' + s.charAt(0) + s.charAt(1)
				+ s.charAt(2) + s.charAt(3);
	}
	//formato de hora
	
	public static String hh_mm_ss(int hora) {
		String s = "" + hora;
		if (s.length() == 4) {
			return "00" + ':' + s.charAt(0) + s.charAt(1) + ':' + s.charAt(2) + s.charAt(3);
		}
		else if (s.length() == 5) {
			return "0" + s.charAt(0) + ':' + s.charAt(1) + s.charAt(2) + ':' + s.charAt(3) + s.charAt(4);
		}
		else {
			return "" + s.charAt(0) + s.charAt(1) + ':' + s.charAt(2) + s.charAt(3) + ':' + s.charAt(4) + s.charAt(5);
		}
	}
	
	
	
	//Relaizar con el metodo toString para hora y Fecha
	
	
	
	
	
	
}
