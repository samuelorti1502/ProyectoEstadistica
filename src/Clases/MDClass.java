//Clase para las medidas de dispersion
package Clases;

import java.util.Arrays;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Samuel David Ortiz
 */
public class MDClass {

    private int[] datos;
    private int nDatos;
    private double suma;

    public MDClass(int nDatos) {
        this.nDatos = nDatos;
        datos = new int[nDatos];
        ingresoDatos();

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
        /*HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();

        for(int i=0; i<this.datos.length; i++){
            if(h.containsKey(this.datos[i])){
                h.put(this.datos[i], h.get(this.datos[i]) + 1);
            } else {
                h.put(this.datos[i], 1);
            }

        }
        System.out.println(h);*/

        int[] fr = new int[this.datos.length];
        int visited = -1;
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
        
        System.out.println("---------------------------------------");  
        System.out.println(" Element | Frequency | x*f | Promedio");  
        System.out.println("---------------------------------------");  
        for(int i = 0; i < fr.length; i++){  
            if(fr[i] != visited) {
                double xf = this.datos[i] * fr[i];
                System.out.println("    " + this.datos[i] + "    |    " + fr[i] + "      |    " + xf + "      |    ");
            }  
        }  
        System.out.println("----------------------------------------");  
    }

}
