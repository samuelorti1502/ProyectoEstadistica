//Clase para las medidas de dispersion
package Clases;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Samuel David Ortiz
 */
public class MDClass {

    private int[] datos;
    private int[] fr;
    private int nDatos;
    private int visited;
    private double suma, suma2, suma3, varianza;

    public MDClass() {

    }

    public MDClass(int nDatos) {
        this.nDatos = nDatos;
        datos = new int[nDatos];
        ingresoDatos();
        //imprimir();

    }

    public double ingresoDatos() {
        for (int i = 0; i < this.nDatos; i++) {
            this.datos[i] = (Integer.parseInt(JOptionPane.showInputDialog((i + 1) + ". Ingrese el numero deseado: ")));
            suma += this.datos[i];
        }

        frecuencia();
        return suma;
    }

    public void frecuencia() {
        Arrays.sort(datos);

        fr = new int[this.datos.length];
        visited = -1;
        for (int i = 0; i < this.datos.length; i++) {
            int count = 1;
            for (int j = i + 1; j < this.datos.length; j++) {
                if (this.datos[i] == this.datos[j]) {
                    count++;
                    //To avoid counting same element again  
                    fr[j] = visited;
                }
            }
            if (fr[i] != visited) {
                fr[i] = count;
            }
        }
    }

    public double promedio() {
        return suma / this.nDatos;
    }

    public double redondeo(double numero){
        return Math.round(numero*1000000.0)/1000000.0;
    }
    
    public double x3(int i) {
        double x = Math.pow((this.datos[i] - promedio()),2);
        return redondeo(x);
    }
    
    public double x4(int i){
        return x3(i)-fr[i];
    }
    
    public double varianza(){
        return redondeo(suma2 / this.nDatos);
    }

    public void imprimir(JTextArea texto) {
        texto.append("*******************************************************\n");
        texto.append(" Elementos (x) | Frecuencia (f) | x*f | Promedio   |   Promedio3   \n");
        texto.append("******************************************************\n");
        for (int i = 0; i < fr.length; i++) {
            if (fr[i] != visited) {
                double xf = this.datos[i] * fr[i];
                texto.append("    " + this.datos[i] + "    |    " + fr[i] + "      |    " + xf + "      |    " + x3(i) + "     |     " + x4(i) + "     |\n");
                suma2 += x4(i);
            }
        }
        System.out.println("----------------------------------------");
        System.out.println("Varianza = " + varianza());
        System.out.println("Desviacion Estandar = " + redondeo(Math.sqrt(varianza())));
        System.out.println("Coeficiente = " + redondeo(Math.sqrt(varianza()) / promedio()));
    }

    public void imprimirt(JTable tabla) {

        Object[] data = new Object[fr.length];

        String[] columnNames = {"First Name",
            "Last Name",
            "Sport",
            "# of Years",
            "Vegetarian"};

        DefaultTableModel model = (DefaultTableModel) tabla.getModel();

        /*Vector row = new Vector();
        row.add("Enter data to column 1");
        row.add("Enter data to column 2");
        row.add("Enter data to column 3");
        model.addRow(row);*/
        //DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Elementos (x)");
        /*model.addColumn("Frecuencia (f)");
        model.addColumn("x*f");
        model.addColumn("x-promedio");*/

        for (int i = 0; i < fr.length; i++) {
            if (fr[i] != visited) {
                double xf = this.datos[i] * fr[i];
                data[i] = this.datos[i];
            }
        }
        model.addRow(data);

    }

}
