package meths;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;


public class ProcesoIMC {

    public void datosPaciente() {
        List<Map<String, Object>> personas = new ArrayList<>();
        
        int cantidad = obtenerCantidadPersonas();
        
        for (int i = 0; i < cantidad; i++) {
            Map<String, Object> usuario = new HashMap<>();
            
            usuario.put("nombre", JOptionPane.showInputDialog("Ingrese el nombre del paciente "+":"));
            usuario.put("telefono", JOptionPane.showInputDialog("Ingrese el número de teléfono" + ":"));
            usuario.put("peso", Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso del paciente " + " en kilogramos:")));
            usuario.put("altura", Double.parseDouble(JOptionPane.showInputDialog("Ingrese la altura del paciente " + ":")));
            
            personas.add(usuario);
        }
        
        String mensaje = "Información de las personas:\n";
        
        for (int i = 0; i < personas.size(); i++) {
            Map<String, Object> persona = personas.get(i);
            
            double imc = calcularIMC((double) persona.get("peso"), (double) persona.get("altura"));
            String conclusion = conclusionIMC(imc);
            
            mensaje += "\nPersona " + (i + 1) + ":\n" +
                       "Nombre: " + persona.get("nombre") + "\n" +
                       "Teléfono: " + persona.get("telefono") + "\n" +
                       "IMC: " + imc + "\n" +
                       "Conclusión: " + conclusion + "\n";
        }
        
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    public int obtenerCantidadPersonas() {
        return Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de personas:"));
    }
    
    public double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }
    
    public String conclusionIMC(double imc) {
        if (imc < 18) {
            return "Anorexia";
        } else if (imc < 20) {
            return "Delgadez";
        } else if (imc < 27) {
            return "Normalidad";
        } else if (imc < 30) {
            return "Obesidad (grado 1)";
        } else if (imc < 35) {
            return "Obesidad (grado 2)";
        } else if (imc < 40) {
            return "Obesidad (grado 3)";
        } else {
            return "Obesidad mórbida";
        }
    }
}



