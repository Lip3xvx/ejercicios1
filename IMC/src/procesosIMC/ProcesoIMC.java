package procesosIMC;

import javax.swing.JOptionPane;

public class ProcesoIMC {
    public void main() {
        int cantidadPersonas = cantidadPersonas();
        
        String[] nombres = new String[cantidadPersonas];
        String[] telefonos = new String[cantidadPersonas];
        double[] pesos = new double[cantidadPersonas];
        double[] alturas = new double[cantidadPersonas];
        double[] imcs = new double[cantidadPersonas];
        
        informacionUsuario(nombres, telefonos, pesos, alturas);
        calcularIMC(imcs, pesos, alturas);
        resultadoUsuario(nombres, telefonos, imcs);
    }
    
    public static int cantidadPersonas() {
        return Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de personas:"));
    }
    
    public static void informacionUsuario(String[] nombres, String[] telefonos, double[] pesos, double[] alturas) {
        for (int i = 0; i < nombres.length; i++) {
            nombres[i] = JOptionPane.showInputDialog("Ingrese el nombre del paciente " + (i + 1) + ":");
            telefonos[i] = JOptionPane.showInputDialog("Ingrese el número de teléfono" + ":");
            pesos[i] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso del paciente " + " en kilogramos:"));
            alturas[i] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la altura del paciente " + " en metros:"));
        }
    }
    
    public static void calcularIMC(double[] imcs, double[] pesos, double[] alturas) {
        for (int i = 0; i < imcs.length; i++) {
            imcs[i] = pesos[i] / (alturas[i] * alturas[i]);
        }
    }
    
    public static void resultadoUsuario(String[] nombres, String[] telefonos, double[] imcs) {
        String mensaje = "Información del paciente:\n";
        
        for (int i = 0; i < nombres.length; i++) {
            String conclusion = conclusionIMC(imcs[i]);
            
            mensaje += "\nPersona " + (i + 1) + ":\n" +
                       "Nombre: " + nombres[i] + "\n" +
                       "Teléfono: " + telefonos[i] + "\n" +
                       "IMC: " + imcs[i] + "\n" +
                       "Conclusión: " + conclusion + "\n";
        }
        
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    public static String conclusionIMC(double imc) {
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
