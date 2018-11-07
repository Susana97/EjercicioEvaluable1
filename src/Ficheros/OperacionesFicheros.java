package Ficheros;

import ejercicioevaluable1.Venta;
import java.io.File;
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

    
    public static void guardarVentasEnFichero(String fichero, ArrayList<Venta> ventasMem,Vector nombresMem) {
        //guardamos las ventas del array de ventas en el fichero.
        try {
            File file = new File(fichero);
            if (file.exists()) {
                Vector nombresProv = new Vector();
                ArrayList<Venta> ventasProv = new ArrayList<Venta>();
                entrada = new ObjectInputStream(new FileInputStream(fichero));
                nombresProv.addAll((Vector<String>) entrada.readObject());
                ventasProv.addAll((ArrayList<Venta>) entrada.readObject());

                for (int i = 0; i < ventasMem.size(); i++) {
                    nombresProv.add(nombresMem.get(i));
                    ventasProv.add(ventasMem.get(i));
                }

                salida = new ObjectOutputStream(new FileOutputStream(fichero));
                salida.writeObject(nombresProv);
                salida.writeObject(ventasProv);
            } else {
                salida = new ObjectOutputStream(new FileOutputStream(fichero, true));
                salida.writeObject(nombresMem);
                salida.writeObject(ventasMem);
            }
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException ex) {
                }
            }
            if (entrada != null) {
                try {
                    entrada.close();
                } catch (IOException ex) {
                }
            }
        }
    }
    
    public static void guardarContenidoFicheroEnArrays(String fichero){
        try {
            entrada = new ObjectInputStream(new FileInputStream(fichero));
            nombres = (Vector<String>)entrada.readObject();
            ventas = (ArrayList<Venta>) entrada.readObject();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                } catch (IOException ex) {
                }
            }
        }
        System.out.println("**************VENTAS********************");
        for(int i=0; i<ventas.size(); i++){
            System.out.println( nombres.get(i) + " -> " + ventas.get(i));
        }
        System.out.println("****************************************");
    }

    public static ArrayList<Venta> getVentas() {
        return ventas;
    }

    public static Vector getNombres() {
        return nombres;
    }
    
}
