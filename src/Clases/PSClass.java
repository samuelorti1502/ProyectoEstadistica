/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Samuel David Ortiz
 */
public class PSClass {

    private final int COLORES = 3;

    private int[] datos;
    private double suma;
    String cl[] = {"rojo", "amarillo", "verde"};
    String muestra;

    public PSClass() {
        datos = new int[COLORES];
        //IngresoDatos();
    }

    public double IngresoDatos() {

        for (int i = 0; i < COLORES; i++) {
            this.datos[i] = (Integer.parseInt(JOptionPane.showInputDialog((i + 1) + ". Ingrese la cantidad de bolas del color " + cl[i] + ": ")));
            suma += this.datos[i];
        }

        System.out.println("suma = " + suma);
        return suma;
    }

    public void lblColores(JLabel color1, JLabel color2, JLabel color3, JLabel total) {
        color1.setText(String.valueOf(this.datos[0]));
        color2.setText(String.valueOf(this.datos[1]));
        color3.setText(String.valueOf(this.datos[2]));
        total.setText(String.valueOf(this.suma));
    }

    public String txtMuestra() {
        String prefix = "";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < COLORES; i++) {
            //System.out.println("Color = " + cl[i]);
            for (int j = 1; j - 1 < datos[i]; j++) {
                //System.out.println("Color = " + cl[i] + j);
                sb.append(prefix);
                prefix = ",";
                sb.append(cl[i].charAt(0)).append(j);
            }

        }

        return sb.toString();
    }
    
    public String formato(double dato1, double dato2){
        DecimalFormat decFormat = new DecimalFormat("#%");
        
        return decFormat.format(dato1/dato2);
    }

    public String eventos(int evento) {
        String eventos = null;
        double ev;

        switch (evento) {
            case 0:
                eventos = formato(this.datos[0], suma);
                break;
            case 1:
                eventos = formato(this.datos[1], suma);
                break;
            case 2:
                eventos = formato(this.datos[2], suma);
                break;
            case 3:
                ev = this.datos[1] + this.datos[2];
                eventos = formato(ev , suma);
                break;
            case 4:
                ev = this.datos[0] + this.datos[2];
                eventos = formato(ev , suma);
                break;
            case 5:
                ev = this.datos[0] + this.datos[1];
                eventos = formato(ev , suma);
                break;
    
        }

        System.out.println("evento = " + eventos);
        return eventos;
    }

}
