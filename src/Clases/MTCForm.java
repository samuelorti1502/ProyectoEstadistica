package Clases;

import java.util.Arrays;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Samuel David Ortiz
 */
public class MTCForm {
    
    private int[] Datos;
    private int nDatos;
    private double suma;
    
    public MTCForm(int nDatos){
        this.nDatos = nDatos;
        Datos = new int[nDatos];
        IngresoDatos();
        System.out.println("media = " + media());
        System.out.println("mediana = " + mediana());
        System.out.println("moda = " + moda());
    }
    
    public double IngresoDatos(){
        for (int i = 0; i < this.nDatos; i++) {
            this.Datos[i] = (Integer.parseInt(JOptionPane.showInputDialog((i+1) + ". Ingrese el numero deseado: ")));
            
            suma += this.Datos[i];
        }
        return suma;
    }
    
    public double media(){
        return suma / this.nDatos;
    }
    
    public double mediana(){
        double mediana;
        Arrays.sort(this.Datos);
        
        if(this.nDatos % 2 == 0){
            mediana = ((double)this.Datos[this.Datos.length/2] + (double)this.Datos[this.Datos.length/2-1])/2;
        }else{
            mediana = (double) this.Datos[this.Datos.length/2];
        }
        return mediana;
    }
    
    public double moda(){
         HashMap<Integer, Integer> mapa = new HashMap<>();
        for (int x = 0; x < this.nDatos; x++) {
            int numero = this.Datos[x];
            if (mapa.containsKey(numero)) {
                mapa.put(numero, mapa.get(numero) + 1);
            } else {
                mapa.put(numero, 1);
            }
        }
        int moda = 0, mayor = 0;
        for (HashMap.Entry<Integer, Integer> entry : mapa.entrySet()) {
            if (entry.getValue() > mayor) {
                mayor = entry.getValue();
                moda = entry.getKey();
            }
        }
        //System.out.printf("La moda es %d porque se repite %d veces", moda, mayor);
        return moda;
    }

}
