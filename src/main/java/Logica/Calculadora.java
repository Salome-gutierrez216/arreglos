package Logica;
import javax.swing.JOptionPane;
/**
 *
 * @author emgallego
 */
public class Calculadora {
    private String id;
    private String nombre;
    private double notaDesarrollo;
    private double notaMatematica;
    private double definitiva;
    
    public Calculadora(String id, String nombre, double notad, double notam) {
        this.id = id;
        this.nombre = nombre;
        this.notaDesarrollo = notad;
        this.notaMatematica = notam;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getNotaDesarrollo() { return notaDesarrollo; }
    public void setNotaDesarrollo(double notaDesarrollo) { this.notaDesarrollo = notaDesarrollo; }

    public double getNotaMatematica() { return notaMatematica; }
    public void setNotaMatematica(double notaMatematica) { this.notaMatematica = notaMatematica; }

    public double getDefinitiva() { return definitiva; }
    
    public double calcularDefinitiva(){
        definitiva = notaMatematica * 0.4 + notaDesarrollo * 0.6;
        return definitiva;
    }
    
    public void mostrarNota(){
        JOptionPane.showMessageDialog(null, getResumen());
    }

    // Devuelve el texto de un estudiante (sirve para armar listas)
    public String getResumen(){
        return "Nombre: " + nombre + " | Código: " + id
                + " | Definitiva: " + String.format("%.2f", definitiva);
    }
}