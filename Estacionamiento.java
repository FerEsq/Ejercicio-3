
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
    private File archivo = new File("Parqueo.txt");
    private String[] datos;
    private String[] datosEspacio;
    private String[] datosVehiculo;
    private boolean Btechado;
    private boolean Baereo;
    private int lleno = 0;
    private ArrayList <Espacio> parqueos = new ArrayList<Espacio>();

    public Estacionamiento() 
    {

    }

    private void leerArchivo()
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
                    Vehiculo c1 = new Vehiculo(datosVehiculo[1], datosVehiculo[2], Integer.parseInt(datosVehiculo[3]), Integer.parseInt(datosVehiculo[0]));
                    p1.setCarro(c1);
                    parqueos.add(p1);
                }


            }
            lector.close();

        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public void ingresarVehiculo(Vehiculo v)
    {
        int i = 0;
        boolean bandera = false;
        while (bandera == false)
        {
            if (parqueos.get(i).getCarro() == null)
            {
                parqueos.get(i).setCarro(v);
                parqueos.get(i).setContador();
                bandera = true;
                System.out.println("\n~~~~~~~~~~~~~");
                System.out.println("Bienvenido :)");
                System.out.println("~~~~~~~~~~~~~");
            }
            else
            {
                if (i == 4)
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

    public void retirarVehiculo(String p)
    {
        int i = 0;
        boolean bandera = false;
        while (bandera == false)
        {
            if (parqueos.get(i).getCarro() != null)
            {
                if (parqueos.get(i).getCarro().getPlaca().equals(p))
                {
                    parqueos.get(i).setNull();
                    bandera = true;
                    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("Tenga un buen viaje :)");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
                }
                else
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
            else
            {
                i++;
            }
        }
    }

    public Double getPromedio()
    {
        Double suma = 0.0;
        for (int i = 0; i <= 4; i++)
        {
            if (parqueos.get(i).getCarro() != null)
            {
                suma += parqueos.get(i).getCarro().getHoras();
            }
        }
        Double prom = suma / 5;
        return prom;
    }

    public int getLleno()
    {
        leerArchivo();
        return lleno;
    }

    public ArrayList getParqueos()
    {
        leerArchivo();
        return parqueos;
    }

    public int getUtilizado()
    {
        return 1;
    }

    public String getCaracteristica()
    {
        return "estandar";
    }

    public void escribirArchivo()
    {
        String[] lineas = new String[5];
        try 
        {
            FileWriter escritor = new FileWriter("Parqueo.txt");

            for (int i = 0; i <= 4; i++)
            {
                if (parqueos.get(i).getCarro() == null)
                {
                    lineas[i] = parqueos.get(i).getTamano() + "," + Boolean.toString( parqueos.get(i).getTechado() ) + "," + Boolean.toString( parqueos.get(i).getAereo() ) + "," + Integer.toString( parqueos.get(i).getContador() ) + "-" + "null";
                }
                else
                {
                    lineas[i] = parqueos.get(i).getTamano() + "," + Boolean.toString( parqueos.get(i).getTechado() ) + "," + Boolean.toString( parqueos.get(i).getAereo() ) + "," + Integer.toString( parqueos.get(i).getContador() ) + "-" + Integer.toString( parqueos.get(i).getCarro().getHoras() ) + "," + parqueos.get(i).getCarro().getPlaca() + "," + parqueos.get(i).getCarro().getMarca() + "," + Integer.toString( parqueos.get(i).getCarro().getModelo() ); 
                }
            }        
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
