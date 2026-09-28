package Vista;

import Logica.Calculadora;
import javax.swing.JOptionPane;

public class CalculadoraDeNotas {

    public static void main(String[] args) {

        int n = Integer.parseInt(
                JOptionPane.showInputDialog("¿Cuántos estudiantes desea registrar?")
        );

        String[] nombres = new String[n];
        String[] ids = new String[n];
        double[] notasDesarrollo = new double[n];
        double[] notasMatematica = new double[n];

        for (int i = 0; i < n; i++) {
            nombres[i] = JOptionPane.showInputDialog(
                    "Estudiante " + (i + 1) + " - Ingrese su Nombre");

            ids[i] = JOptionPane.showInputDialog(
                    "Estudiante " + (i + 1) + " - Ingrese su ID");

            notasDesarrollo[i] = Double.parseDouble(
                    JOptionPane.showInputDialog(
                            "Estudiante " + (i + 1) + " - Digite la nota de Desarrollo"));

            notasMatematica[i] = Double.parseDouble(
                    JOptionPane.showInputDialog(
                            "Estudiante " + (i + 1) + " - Digite la nota de Matemáticas"));
        }

        Calculadora[] estudiantes = new Calculadora[n];
        double[] definitivas = new double[n];

        for (int i = 0; i < n; i++) {
            estudiantes[i] = new Calculadora(ids[i], nombres[i],
                    notasDesarrollo[i], notasMatematica[i]);
            definitivas[i] = estudiantes[i].calcularDefinitiva();
        }

        StringBuilder listado = new StringBuilder("LISTADO DE ESTUDIANTES\n\n");
        for (int i = 0; i < n; i++) {
            listado.append(i + 1).append(". ")
                   .append(estudiantes[i].getResumen()).append("\n");
        }
        JOptionPane.showMessageDialog(null, listado.toString());

        // Estadísticas recorriendo el arreglo de definitivas
        double suma = 0;
        int posMayor = 0;
        int posMenor = 0;

        for (int i = 0; i < n; i++) {
            suma += definitivas[i];
            if (definitivas[i] > definitivas[posMayor]) {
                posMayor = i;
            }
            if (definitivas[i] < definitivas[posMenor]) {
                posMenor = i;
            }
        }

        double promedio = suma / n;

        JOptionPane.showMessageDialog(null,
                "ESTADÍSTICAS DEL GRUPO\n\n"
                + "Promedio del grupo: " + String.format("%.2f", promedio) + "\n"
                + "Nota más alta: " + String.format("%.2f", definitivas[posMayor])
                + " (" + nombres[posMayor] + ")\n"
                + "Nota más baja: " + String.format("%.2f", definitivas[posMenor])
                + " (" + nombres[posMenor] + ")");
    }
}