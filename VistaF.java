/* Nombre: VistaF.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 04.09.2021
 			  Modificado el 05.09.2021 */

//Import
import java.util.Scanner;

public class VistaF 
{
    //Propiedades
    Scanner scan = new Scanner(System.in);

    public VistaF() //constructor
    {  

    }

    //Mensaje de bienvenida
    public void mostrarInicio()
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("      ✦ Bienvenid@ a la base de datos del Estacionamiento ✦ \n");
		System.out.println(" - Por el momento, solo contamos con 5 espacios de parqueo");
        System.out.println(" - Estamos trabajando para expandirnos, gracias por su comprensión");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }
    
    
    /** 
     * @return int
     */
    //Menu
    public int mostrarMenu()
    {
        int op = 0;
        System.out.println("¿Que opción desea ejecutar? (ingrese solo el número)");	
		System.out.println("1. Ingresar vehículo");
		System.out.println("2. Retirar vehículo");
		System.out.println("3. Ver estadísticas");
		System.out.println("4. Salir");

        op = scan.nextInt();
        return op;
    }

    
    /** 
     * @return int
     */
    // ------------------------------ Solicitar datos ------------------------------
    public int pedirHoras() 
    {
        System.out.println("\nIngrese las horas que ha estado el vehículo en el parqueo:");
        return scan.nextInt();
    }
    
    /** 
     * @return String
     */
    public String pedirPlaca()
    {
        System.out.println("\nIngrese la placa del vehículo:");
        scan.nextLine();
        return scan.nextLine();
    }
    
    /** 
     * @return String
     */
    public String pedirMarca()
    {
        System.out.println("\nIngrese la marca del vehículo:");
        return scan.nextLine();
    }
    
    /** 
     * @return int
     */
    public int pedirModelo()
    {
        System.out.println("\nIngrese el modelo del vehículo:");
        return scan.nextInt();
    }

    
    /** 
     * @param p
     * @param m
     * @param r
     * @param c
     */
    //Mostrar las estadísticas
    public void mostrarStats(Double p, int m, int r, String c)
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(" * El promedio de tiempo de uso del parqueo es de: " + p + " horas");
        System.out.println(" * El parqueo que más se utiliza es el número: " + m);
        System.out.println(" * Cuando el parqueo está lleno, se rechazan: " + r + " vehículos");
        System.out.println(" * Los parqueos más utilizados son de tamaño: " + c);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    //Mensaje de despedida
    public void mostrarDespedida()
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Muchas gracias por utilizar nuestro sistema!!!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
}

