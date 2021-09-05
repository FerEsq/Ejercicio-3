/* Nombre: Vista.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 04.09.2021
 			  Modificado el 05.09.2021 */

//Import
import java.util.Scanner;

public class Vista 
{
    Scanner scan = new Scanner(System.in);
    /*Estacionamiento est = new Estacionamiento();
    ArrayList <Espacio> par = est.getParqueos();*/

    public Vista() //constructor
    {  

    }

    //Mensajes de bienvenida
    public void mostrarInicio();
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("   ✦ Bienvenid@ a la base de datos del Estacionamiento ✦ \n");
		System.out.println(" - Por el momento, solo contamos con 5 espacios de parqueo";
        System.out.println(" - Estamos trabajando para expandirnos, gracias por su comprensión":
        System.out.println(" - Si es necesario, porfavor darle doble enter al ingresar un dato");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }
    
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

    //Ingresar Vehículo
    public int pedirHoras()
    {
        System.out.println("\nIngrese las horas que ha estado el vehículo en el parqueo:");
        return scan.nextInt();
    }
    public String pedirPlaca()
    {
        System.out.println("\nIngrese la placa del vehículo:");
        scan.nextLine();
        return scan.nextLine();
    }
    public String pedirMarca()
    {
        System.out.println("\nIngrese la marca del vehículo:");
        scan.nextLine();
        return scan.nextLine();
    }
    public int pedirModelo()
    {
        System.out.println("\nIngrese el modelo del vehículo:");
        return scan.nextInt();
    }

    public void mostrarStats(Double p, int m, int r, String c)
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(" * El promedio de tiempo de uso del parqueo es de: " + p + " horas");
        System.out.println(" * El parqueo que más se utiliza es el número: " + m + " horas");
        System.out.println(" * Cuando el parqueo está lleno, se rechazan: " + r + " vehículos");
        System.out.println(" * Los parqueos más utilizado son de tamaño: " + p);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void despedida()
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Muchas gracias por utilizar nuestro sistema!!!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
}
