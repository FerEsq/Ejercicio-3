
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
import java.io.FileWriter;     

public class Estacionamiento 
{
    //Propiedades
    private File archivo = new File("Parqueo.txt");
    private String[] datos;
    private String[] datosEspacio;
    private String[] datosVehiculo;
    private boolean Btechado;
    private boolean Baereo;
    private int lleno = 0;
    private ArrayList <Espacio> parqueos = new ArrayList<Espacio>();

    //Constructor (vacío)
    public Estacionamiento() 
    {

    }

    private void leerArchivo() //leer el archivo
    {
        //validación
        try 
        {         
            Scanner lector = new Scanner(archivo); //leer archivo
            while (lector.hasNextLine()) //analizar archivo linea poe linea
            {
                datos = lector.nextLine().split("-");
                datosEspacio = datos[0].split(",");
                datosVehiculo = datos[1].split(",");

                //convertir datos del archivo a objetos de clase Espacio y Vehículo
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

                    //ingresar espacios al arraylist 
                    Espacio p1 = new Espacio(datosEspacio[0], Btechado, Baereo, Integer.parseInt(datosEspacio[3]));
                    Vehiculo c1 = new Vehiculo(datosVehiculo[1], datosVehiculo[2], Integer.parseInt(datosVehiculo[3]), Integer.parseInt(datosVehiculo[0]));
                    p1.setCarro(c1);
                    parqueos.add(p1);
                }


            }
            lector.close(); //cerrar archivo

        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    
    /** 
     * @param v
     */
    public void ingresarVehiculo(Vehiculo v) //ingresar vehículo al parqueo
    {
        int i = 0;
        boolean bandera = false;
        while (bandera == false) //recorrer arraylist
        {
            if (parqueos.get(i).getCarro() == null) //si el parqueo esta vació
            {
                parqueos.get(i).setCarro(v); //entra el carro
                parqueos.get(i).setContador();
                bandera = true;
                System.out.println("\n~~~~~~~~~~~~~");
                System.out.println("Bienvenido :)");
                System.out.println("~~~~~~~~~~~~~");
            }
            else
            {
                if (i == 4) //no hay parqueos disponibles
                {
                    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("El parqueo esta lleno");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~");
                    lleno += 1;
                    bandera = true;
                }
                else
                {
                    i++; 
                }
            }
        }
    }

    
    /** 
     * @param p
     */
    public void retirarVehiculo(String p) //retirar el vehículo del parqueo
    {
        int i = 0;
        boolean bandera = false;
        while (bandera == false) //recorrer arraylist
        {
            if (parqueos.get(i).getCarro() != null) //si hay un vehículo dentro del espacio
            {
                if (parqueos.get(i).getCarro().getPlaca().equals(p)) //las placas coinciden
                {
                    parqueos.get(i).setNull(); //sale el carro
                    bandera = true;
                    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("Tenga un buen viaje :)");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
                }
                else //las placas NO coinciden
                {
                    if (i == 4)
                    {
                        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("El vehículo no existe");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
                        bandera = true;
                    }
                    else
                    {
                        i++;
                    }
                }
            }
            else //el espacio esta vacio
            {
                i++;
            }
        }
    }

    
    /** 
     * @return Double
     */
    public Double getPromedio() //calcular estadistica del promedio
    {
        Double suma = 0.0;
        for (int i = 0; i <= 4; i++) //recorrer arraylist
        {
            if (parqueos.get(i).getCarro() != null) //si hay un carro en el espacio
            {
                suma += parqueos.get(i).getCarro().getHoras(); //sumar las horas totales
            }
        }
        Double prom = suma / 5; //calcular promedio
        return prom;
    }

    
    /** 
     * @return int
     */
    public int getLleno() //obtener estadpistica cuantos carros se rechazam
    {
        leerArchivo();
        return lleno;
    }

    
    /** 
     * @return ArrayList
     */
    public ArrayList getParqueos() //obtener arraylist con parqueos
    {
        leerArchivo();
        return parqueos;
    }

    
    /** 
     * @return int
     */
    public int getUtilizado() //obtener parqueo más utilizado
    {
        return parqueos.size() - 4;
    }

    
    /** 
     * @return String
     */
    public String getCaracteristica() //obtener tamaño del parqueo más usado
    {
        return parqueos.get(0).getTamano();
    }

    public void escribirArchivo() //escribir en el archivo
    {
        String[] lineas = new String[5];
        //validación
        try 
        {
            FileWriter escritor = new FileWriter("Parqueo.txt");

            for (int i = 0; i <= 4; i++) //recorrer arraylist
            {
                if (parqueos.get(i).getCarro() == null) //si el espacio esta vacio (no hay carro)
                {
                    lineas[i] = parqueos.get(i).getTamano() + "," + Boolean.toString( parqueos.get(i).getTechado() ) + "," + Boolean.toString( parqueos.get(i).getAereo() ) + "," + Integer.toString( parqueos.get(i).getContador() ) + "-" + "null";
                }
                else //si hay carro
                {
                    lineas[i] = parqueos.get(i).getTamano() + "," + Boolean.toString( parqueos.get(i).getTechado() ) + "," + Boolean.toString( parqueos.get(i).getAereo() ) + "," + Integer.toString( parqueos.get(i).getContador() ) + "-" + Integer.toString( parqueos.get(i).getCarro().getHoras() ) + "," + parqueos.get(i).getCarro().getPlaca() + "," + parqueos.get(i).getCarro().getMarca() + "," + Integer.toString( parqueos.get(i).getCarro().getModelo() ); 
                }
            }        
            //escribir linea por linea (info del espacio)
            escritor.write(lineas[0]);
            escritor.write("\n");
            escritor.write(lineas[1]);
            escritor.write("\n");
            escritor.write(lineas[2]);
            escritor.write("\n");
            escritor.write(lineas[3]);
            escritor.write("\n");
            escritor.write(lineas[4]);
            escritor.write("\n");
            escritor.close();
        } 
        catch (IOException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    
}
