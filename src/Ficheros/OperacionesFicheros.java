package Ficheros;

import ejercicioevaluable1.Venta;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Vector;

public class OperacionesFicheros {
    
    private static ObjectInputStream entrada=null;
    private static ObjectOutputStream salida = null;
    private static Vector nombres = new Vector();
    private static ArrayList <Venta> ventas = new ArrayList<Venta>();

    
    public static void guardarVentas(String fichero, ArrayList<Venta> ventas, 
            Vector nombres) {
        //guardamos las ventas del array de ventas en el fichero.
        try {
            salida = new ObjectOutputStream(new FileOutputStream(fichero));
            salida.writeObject(nombres);
            salida.writeObject(ventas);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    public static void leerFicheroVentas(String fichero){
        try {
            entrada = new ObjectInputStream(new FileInputStream(fichero));
            
            //while(true){
                nombres.addAll((Vector<String>)entrada.readObject());
                ventas.addAll((ArrayList<Venta>) entrada.readObject());
            //}
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        
        for(int i=0; i<ventas.size(); i++){
            System.out.println( nombres.get(i) + " -> " + ventas.get(i));
        }
    }

    public static ArrayList<Venta> getVentas() {
        return ventas;
    }

    public static Vector getNombres() {
        return nombres;
    }
    
}
