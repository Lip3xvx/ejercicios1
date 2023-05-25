package procesos;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class EleccionCiudad {
    private HashMap<String, ArrayList<String>> mapCiudades;

    public EleccionCiudad() {
        mapCiudades = new HashMap<>();
    }
public void menu() {
	int opcion;
	
	do {
		String opciones = JOptionPane.showInputDialog(
                " Menú\n"
                + "1. Registrar país\n"
                + "2. Registrar ciudad\n"
                + "3. Consultar ciudades por país\n"
                + "4. Consultar ciudad\n"
                + "0. Salir\n"
                + "Ingrese una opción:"
            );
            
            opcion = Integer.parseInt(opciones);

            switch (opcion) {
                case 1:
                    registroPais();
                    break;
                case 2:
                    registroCiudad();
                    break;
                case 3:
                   ciudadesPorPais();
                    break;
                case 4:
                    buscarCiudad();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. intente nuevamente.");
                    break;
            }

        } while (opcion != 0);
    }
	


private void registroPais() {
    String pais = JOptionPane.showInputDialog("Ingrese el nombre del país:");

    if (mapCiudades.containsKey(pais)) {
        JOptionPane.showMessageDialog(null, "El país ya está registrado.");
    } else {
        mapCiudades.put(pais, new ArrayList<>());
        JOptionPane.showMessageDialog(null, "País registrado exitosamente.");
    }
}
    
    private void registroCiudad() {
        String pais = JOptionPane.showInputDialog("Ingrese el nombre del país:");

        if (!mapCiudades.containsKey(pais)) {
            JOptionPane.showMessageDialog(null, "El país no está registrado.");
            return;
        }
        String ciudad = JOptionPane.showInputDialog("Ingrese el nombre de la ciudad:");

        ArrayList<String> ciudades = mapCiudades.get(pais);
        ciudades.add(ciudad);
        JOptionPane.showMessageDialog(null, "Ciudad registrada exitosamente.");
    }
    
        
 private void ciudadesPorPais() {
    String pais = JOptionPane.showInputDialog("Ingrese el nombre del país:");

    if (!mapCiudades.containsKey(pais)) {
        JOptionPane.showMessageDialog(null, "El país no está registrado.");
        return;
    
    }
    ArrayList<String> ciudades = mapCiudades.get(pais);
    StringBuilder mensaje = new StringBuilder();
    mensaje.append("Ciudades de ").append(pais).append(":\n");
    for (String ciudad : ciudades) {
        mensaje.append("- ").append(ciudad).append("\n");
    }
 JOptionPane.showMessageDialog(null, mensaje.toString());

 }
 private void buscarCiudad() {
     String ciudad = JOptionPane.showInputDialog("Ingrese el nombre de la ciudad:");

     boolean ciudadEncontrada = false;

     for (String pais : mapCiudades.keySet()) {
         ArrayList<String> ciudades = mapCiudades.get(pais);
         if (ciudades.contains(ciudad)) {
             JOptionPane.showMessageDialog(null, ciudad + " pertenece al país " + pais);
             ciudadEncontrada = true;
             break;
         }
     }

     if (!ciudadEncontrada) {
         JOptionPane.showMessageDialog(null, "La ciudad no está registrada en ningún país.");
     }
 	} 
   } 


