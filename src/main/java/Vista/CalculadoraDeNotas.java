package Vista;

import Logica.Calculadora;
import javax.swing.JOptionPane;

public class CalculadoraDeNotas {

    public static void main(String[] args) {

        String nombre = JOptionPane.showInputDialog(
                "Ingrese su Nombre"
        );

        String id = JOptionPane.showInputDialog(
                "Ingrese su ID"
        );

        double notad = Double.parseDouble(
                JOptionPane.showInputDialog(
                        "Digite la nota de Desarrollo"
                )
        );

        double notam = Double.parseDouble(
                JOptionPane.showInputDialog(
                        "Digite la nota de Matemáticas"
                )
        );

        Calculadora miComparador = new Calculadora(
                id,
                nombre,
                notad,
                notam
        );

        double definitiva = miComparador.calcularDefinitiva();

        miComparador.mostrarNota();
    }
}