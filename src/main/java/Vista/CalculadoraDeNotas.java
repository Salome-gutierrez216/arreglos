package Vista;

import Logica.Calculadora;
import javax.swing.JOptionPane;

public class CalculadoraDeNotas {

    // Pide una nota y repite la pregunta hasta que esté entre 0.0 y 5.0
    private static double leerNota(String mensaje) {
        while (true) {
            try {
                double nota = Double.parseDouble(JOptionPane.showInputDialog(mensaje));
                if (nota >= 0.0 && nota <= 5.0) {
                    return nota;
                }
                JOptionPane.showMessageDialog(null, "La nota debe estar entre 0.0 y 5.0");
            } catch (NumberFormatException | NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido");
            }
        }
    }

    // Pide la cantidad de estudiantes y repite hasta que sea un entero mayor que 0
    private static int leerCantidad() {
        while (true) {
            try {
                int n = Integer.parseInt(
                        JOptionPane.showInputDialog("¿Cuántos estudiantes desea registrar?"));
                if (n > 0) {
                    return n;
                }
                JOptionPane.showMessageDialog(null, "Debe ser al menos 1 estudiante");
            } catch (NumberFormatException | NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número entero válido");
            }
        }
    }

    public static void main(String[] args) {

        int n = leerCantidad();

        String[] nombres = new String[n];
        String[] ids = new String[n];
        double[] notasDesarrollo = new double[n];
        double[] notasMatematica = new double[n];

        for (int i = 0; i < n; i++) {
            nombres[i] = JOptionPane.showInputDialog(
                    "Estudiante " + (i + 1) + " - Ingrese su Nombre");

            ids[i] = JOptionPane.showInputDialog(
                    "Estudiante " + (i + 1) + " - Ingrese su ID");

            notasDesarrollo[i] = leerNota(
                    "Estudiante " + (i + 1) + " - Digite la nota de Desarrollo (0 a 5)");

            notasMatematica[i] = leerNota(
                    "Estudiante " + (i + 1) + " - Digite la nota de Matemáticas (0 a 5)");
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
            String estado = definitivas[i] >= 3.0 ? "APROBÓ" : "REPROBÓ";
            listado.append(i + 1).append(". ")
                   .append(estudiantes[i].getResumen())
                   .append(" | ").append(estado).append("\n");
        }
        JOptionPane.showMessageDialog(null, listado.toString());

        double suma = 0;
        int posMayor = 0;
        int posMenor = 0;
        int aprobados = 0;

        for (int i = 0; i < n; i++) {
            suma += definitivas[i];
            if (definitivas[i] > definitivas[posMayor]) {
                posMayor = i;
            }
            if (definitivas[i] < definitivas[posMenor]) {
                posMenor = i;
            }
            if (definitivas[i] >= 3.0) {
                aprobados++;
            }
        }

        double promedio = suma / n;

        JOptionPane.showMessageDialog(null,
                "ESTADÍSTICAS DEL GRUPO\n\n"
                + "Promedio del grupo: " + String.format("%.2f", promedio) + "\n"
                + "Nota más alta: " + String.format("%.2f", definitivas[posMayor])
                + " (" + nombres[posMayor] + ")\n"
                + "Nota más baja: " + String.format("%.2f", definitivas[posMenor])
                + " (" + nombres[posMenor] + ")\n"
                + "Aprobados: " + aprobados + "\n"
                + "Reprobados: " + (n - aprobados));
    }
}