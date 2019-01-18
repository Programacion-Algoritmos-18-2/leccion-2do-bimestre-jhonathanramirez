package lecturaArchivos2;

// Fig. 14.12: PruebaLeerArchivoTexto.java
import java.util.ArrayList;
import java.util.Scanner;

public class PruebaLeerArchivoTexto {

    public static void main(String args[]) {
        //Dos objetos tipo leer archivo texto
        LeerArchivoTexto aplicacion = new LeerArchivoTexto();
        LeerArchivoTexto2 aplicacion2 = new LeerArchivoTexto2();
        //Objeto tipo Crear archivo
        CrearArchivo a = new CrearArchivo();
        OperacionData operacion = new OperacionData();
        //Abrimos los archivos
        aplicacion.abrirArchivo();
        aplicacion2.abrirArchivo();
        a.abrirArchivo();
        //Dos objetos Arraylist de tipo profesor
        ArrayList<Profesor> lista = aplicacion.leerRegistros();
        ArrayList<Profesor> lista_2 = aplicacion2.leerRegistros2();
        //For para unir los datos que contienen los archivos 
        for (int i = 0; i < lista_2.size(); i++) {
            lista.add(lista_2.get(i));
        }
        operacion.agregarInformacion(lista);
        a.agregarRegistros(lista);
        // operacion.lecturaData();
        Scanner e = new Scanner(System.in);
        int opc;
        do {
            //-----------Menu----------- 
            System.out.println("Ingrese la opcion que desea:");
            System.out.println("1) Ordenar por Canton");
            System.out.println("2) Genera archivo ordenados por nombres y apellido");
            System.out.println("3) Participantes de acuerdo a su Personalidad");
            System.out.println("4) Participantes de acuerdo a su DICTAMENDEIDONEIDAD");
            opc = e.nextInt();

            switch (opc) {
                case 1:
                    //Ordena por canton
                    System.out.println("Ordenado por canton ");
                    operacion.ordenarPorCanton();
                    break;
                case 2:
                    //Crea un archivo que contiene un listado ordenado por nombres
                    ArrayList<Profesor> lista2 = operacion.ordenarPorNombres();
                    System.out.println(lista2);
                    break;
                case 3:
                    //Ase un conteo de participantes de acuerdo a su personalidad
                    System.out.println("Participantes de acuerdo a su Personalidad");
                    System.out.println(operacion.caracteristicaP(lista));
                    break;
                case 4:
                    //Ase un conteo de participantes de acuerdo a su dictamendeidoneidad
                    System.out.println("Participantes de acuerdo a su DICTAMENDEIDONEIDAD");
                    System.out.println(operacion.obtener_paticipantes(lista));
                    break;
                default:
                    System.out.println("La opcion no es valida");

            }}
            while (opc != 0);

            //Cerramos los archivos 
            aplicacion.cerrarArchivo();
            aplicacion2.cerrarArchivo();
            a.cerrarArchivo();
        } // fin de main

    } // fin de la clase PruebaLeerArchivoTexto

