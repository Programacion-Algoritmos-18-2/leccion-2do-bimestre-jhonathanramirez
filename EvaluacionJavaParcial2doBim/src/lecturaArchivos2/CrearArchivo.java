/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaArchivos2;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 *
 * @author Usuario
 */
public class CrearArchivo {
     private Formatter salida; // objeto usado para enviar texto al archivo

    public void abrirArchivo() {
        try {
            // salida = new Formatter("registrosNN.txt");
            salida = new Formatter(new FileWriter("data3.txt", true));

        } catch (SecurityException securityException) {
            System.err.println("No se tiene acceso de escritura a este archivo");
            System.exit(1);
        } catch (FileNotFoundException filesNotFoundException) {
            System.err.println("Error al crear archivo");
            System.exit(1);

        } catch (IOException e) {
            System.err.println("Error al crear archivo");
            System.exit(1);
        }
    }
    

    public void agregarRegistros(ArrayList<Profesor> lista) {
        
        for (int i = 1; i < lista.size(); i++) {
           
            try {
                
                salida.format("Cedula :%s "+" Nombre: %s " + " Zona: %s " + " Provincia: %s "+" Canton: %s "+" Personalidad: %s "+" Razonamiento: %s "+" Discamen Indoniedad: %s\n",
                        lista.get(i).getCedula(),
                        lista.get(i).getNombres(),
                        lista.get(i).getZona(),
                        lista.get(i).getProvincia(),
                        lista.get(i).getCanton(),
                        lista.get(i).getPersonalidad(),
                        lista.get(i).getRazonamiento(),
                        lista.get(i).getDictamenIdoniedad());

            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Entrada inválida.Intente de nuevo");
            }
        }

    }

    public void cerrarArchivo() {
        if (salida != null) {
            salida.close();
        }
}
}
