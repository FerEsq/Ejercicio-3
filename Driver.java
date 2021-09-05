
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
		Vista vista = new Vista();
		Scanner scan = new Scanner(System.in);
		Estacionamiento est = new Estacionamiento();
		ArrayList <Espacio> ps = est.getParqueos();

		int opcion = 0;

		//Mensajes de bienvenida		
				
		while (opcion != 4)
		{
			//Menú		
			opcion = vista.mostrarMenu();

			if (opcion == 1)
			{
				
			}

			if (opcion == 2)
			{
				
			}

			if (opcion == 3)
			{
				
			}

			//Otra ocpión
			else
			{
				System.out.println("Esa opción no existe, intente de nuevo\n");
			}
		}
	}
}