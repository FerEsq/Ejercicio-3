
/* Nombre: Driver.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 04.09.2021
 			  Modificado el 05.09.2021 */

//Import
import java.util.Scanner;
import java.io.File;  
import java.io.IOException;
import java.security.PublicKey;
import java.io.FileNotFoundException;  
import java.util.ArrayList;  

//Clase Driver (SimuladorPerrera)
class Driver
{	
	/** 
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Espacio parqueo = new Espacio();
		VistaF vista = new VistaF();
		Scanner scan = new Scanner(System.in);
		Estacionamiento est = new Estacionamiento();
		ArrayList <Espacio> ps = est.getParqueos();

		int opcion = 0;

		//Mensajes de bienvenida		
				
		while (opcion != 4)
		{
			//Menú		
			opcion = vista.mostrarMenu();

			if (opcion == 1) //ingresar vehículo
			{
				int h = vista.pedirHoras();
				String p = vista.pedirPlaca();
				String ma = vista.pedirMarca();
				int mo = vista.pedirModelo();
				Vehiculo v = new Vehiculo(p, ma, mo, h);
				est.ingresarVehiculo(v);
				
			}

			if (opcion == 2) //retirar vehículo
			{
				String p1 = vista.pedirPlaca();
				est.retirarVehiculo(p1);
				
			}

			if (opcion == 3)
			{
				vista.mostrarStats(est.getPromedio(), est.getUtilizado(), est.getLleno(), est.getCaracteristica());
			}

			if (opcion == 4)
			{
				est.escribirArchivo();
				vista.despedida();
			}

			//Otra ocpión
			if (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4)
			{
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Esa opción no existe, intente de nuevo");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			}
		}
	}
}