
/* Nombre: Espacio.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 04.09.2021
 			  Modificado el 05.09.2021 */

public class Espacio 
{
    //Propiedades
    private String tamano;
    private boolean techado;
    private boolean aereo;
    private int contador;

    private Vehiculo carro; 
   
    public Espacio(String ta, boolean te, boolean a, int c) //el usuario ingresa un nuevo espacio
    {
        tamano = ta;
        techado = te;
        aereo = a;
        contador = c;
        carro = null;        
    }

    /*public Espacio() //constructor sin ingreso
    {
        tamano = "si";
        techado = false;
        aereo = false;
        contador = 1;
    }*/

    public String getTamano()
    {
        return tamano;
    }

    public boolean getTechado()
    {
        return techado;
    }

    public boolean getAereo()
    {
        return aereo;
    }

    public int getContador()
    {
        return contador;
    }

    public void setContador()
    {
        contador++;
    }

    public void setCarro(Vehiculo c)
    {
        carro = c;
    }

    public void setNull()
    {
        carro = null;
    }

    public Vehiculo getCarro()
    {
        return carro;
    }

}
