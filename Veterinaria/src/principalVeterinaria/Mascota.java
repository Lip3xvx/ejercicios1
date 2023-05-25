package principalVeterinaria;

import java.util.HashMap;

import javax.swing.JOptionPane;

import datosVeterinaria.Mascota;

public class Mascota {

    public static void main(String[] args) {
        HashMap<String, Mascota> mapaMascotas = new HashMap<>();

        int cantidadMascotas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de mascotas a ingresar:"));

        for (int i = 0; i < cantidadMascotas; i++) {
            JOptionPane.showMessageDialog(null, "nueva mascota " + (i + 1));

            String identificacion = JOptionPane.showInputDialog("Ingrese la identificación:");
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la mascota:");
            String especie = JOptionPane.showInputDialog("Ingrese la especie de la mascota:");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de la mascota:"));

            Mascota mascota = new Mascota();
            mapaMascotas.put(identificacion, mascota);
        }

        StringBuilder mascotasInfo = new StringBuilder("--- Lista de Mascotas ---\n");
        for (Mascota mascota : mapaMascotas.values()) {
            mascotasInfo.append("Identificación: ").append(mascota.getIdentificacion()).append("\n");
            mascotasInfo.append("Nombre: ").append(mascota.getNombre()).append("\n");
            mascotasInfo.append("Especie: ").append(mascota.getEspecie()).append("\n");
            mascotasInfo.append("Edad: ").append(mascota.getEdad()).append("\n");
            mascotasInfo.append("---------------------------\n");
        }
        JOptionPane.showMessageDialog(null, mascotasInfo.toString());

        String identificacionConsulta = JOptionPane.showInputDialog("Ingrese la identificación de la mascota a consultar:");
        Mascota mascotaConsultada = mapaMascotas.get(identificacionConsulta);
        if (mascotaConsultada != null) {
            StringBuilder consultaInfo = new StringBuilder("Información de la mascota consultada:\n");
            consultaInfo.append("Identificación: ").append(mascotaConsultada.getIdentificacion()).append("\n");
            consultaInfo.append("Nombre: ").append(mascotaConsultada.getNombre()).append("\n");
            consultaInfo.append("Especie: ").append(mascotaConsultada.getEspecie()).append("\n");
            consultaInfo.append("Edad: ").append(mascotaConsultada.getEdad()).append("\n");
            JOptionPane.showMessageDialog(null, consultaInfo.toString());

            mascotaConsultada.hacerSonido();
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró una mascota con la identificación " + identificacionConsulta);
        }

        String identificacionModificacion = JOptionPane.showInputDialog("Ingrese la identificación de la mascota a modificar:");
        Mascota mascotaModificar = mapaMascotas.get(identificacionModificacion);
        if (mascotaModificar != null) {
            JOptionPane.showMessageDialog(null, "Mascota encontrada. Ingrese los nuevos datos:");

            String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:");
            mascotaModificar.setNombre(nuevoNombre);

            String nuevaEspecie = JOptionPane.showInputDialog("Nueva especie:");
            mascotaModificar.setEspecie(nuevaEspecie);

            int nuevaEdad = Integer.parseInt(JOptionPane.showInputDialog("Nueva edad:"));
            mascotaModificar.setEdad(nuevaEdad);

            StringBuilder modificacionInfo = new StringBuilder("Mascota modificada correctamente.\n");
            modificacionInfo.append("Nueva información:\n");
            modificacionInfo.append("Identificación: ").append(mascotaModificar.getIdentificacion()).append("\n");
            modificacionInfo.append("Nombre: ").append(mascotaModificar.getNombre()).append("\n");
            modificacionInfo.append("Especie: ").append(mascotaModificar.getEspecie()).append("\n");
            modificacionInfo.append("Edad: ").append(mascotaModificar.getEdad()).append("\n");
            JOptionPane.showMessageDialog(null, modificacionInfo.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró una mascota con la identificación " + identificacionModificacion);
        }
    }

	private void setEdad(int nuevaEdad) {
		// TODO Auto-generated method stub
		
	}

	private void setEspecie(String nuevaEspecie) {
		// TODO Auto-generated method stub
		
	}

	private void setNombre(String nuevoNombre) {
		// TODO Auto-generated method stub
		
	}

	private void hacerSonido() {
		// TODO Auto-generated method stub
		
	}

	private Object getEdad() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object getEspecie() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object getIdentificacion() {
		// TODO Auto-generated method stub
		return null;
	}
}
