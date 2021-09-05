
/* Nombre: Estacionamiento.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 04.09.2021
 			  Modificado el 05.09.2021 */

import java.util.Scanner;
import java.io.File;  
import java.io.IOException;
import java.security.PublicKey;
import java.io.FileNotFoundException;  
import java.util.ArrayList;          

public class Estacionamiento 
{
    private File archivo = new File("Parqueo.txt");
    private String[] datos;
    private String[] datosEspacio;
    private String[] datosVehiculo;
    private boolean Btechado;
    private boolean Baereo;
    private ArrayList <Espacio> parqueos = new ArrayList<Espacio>();

    public Estacionamiento() //el usuario ingresa un nuevo espacio
    {

    }

    public void leerArchivo()
    {
        try 
        {         
            Scanner lector = new Scanner(archivo);
            while (lector.hasNextLine()) 
            {
                datos = lector.nextLine().split("-");
                datosEspacio = datos[0].split(",");
                datosVehiculo = datos[1].split(",");

                if (datosVehiculo[0].equals("null"))
                {
                    if (datosEspacio[1].equals("false"))
                    {
                        Btechado = false;
                    }
                    else 
                    {
                        Btechado = true;
                    }

                    if (datosEspacio[2].equals("false"))
                    {
                        Baereo = false;
                    }
                    else 
                    {
                        Baereo = true;
                    }

                    Espacio p1 = new Espacio(datosEspacio[0], Btechado, Baereo, Integer.parseInt(datosEspacio[3]));
                    parqueos.add(p1);
                }
                else
                {
                    if (datosEspacio[1].equals("false"))
                    {
                        Btechado = false;
                    }
                    else 
                    {
                        Btechado = true;
                    }

                    if (datosEspacio[2].equals("false"))
                    {
                        Baereo = false;
                    }
                    else 
                    {
                        Baereo = true;
                    }

                    Espacio p1 = new Espacio(datosEspacio[0], Btechado, Baereo, Integer.parseInt(datosEspacio[3]));
                    Vehiculo c1 = new Vehiculo(datosVehiculo[2], datosVehiculo[3], Integer.parseInt(datosVehiculo[4]), Integer.parseInt(datosVehiculo[0]), Integer.parseInt(datosVehiculo[1]));
                    p1.setCarro(c1);
                    parqueos.add(p1);
                }


            }
            lector.close();

        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public ArrayList getParqueos()
    {
        leerArchivo();
        return parqueos;
    }

    
}
