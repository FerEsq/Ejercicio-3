
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
   
    //Constructor
    public Espacio(String ta, boolean te, boolean a, int c) //el usuario ingresa un nuevo espacio
    {
        tamano = ta;
        techado = te;
        aereo = a;
        contador = c;
        carro = null;        
    }

    public String getTamano() //obtener tamaño
    {
        return tamano;
    }

    public boolean getTechado() //obtener si es techado o no
    {
        return techado;
    }

    public boolean getAereo() //obtener si es aereo o no
    {
        return aereo;
    }

    public int getContador() //obtener el contador de cuantas veces se ha usado
    {
        return contador;
    }

    public void setContador() //se le suma uno al contador
    {
        contador++;
    }

    public void setCarro(Vehiculo c) //se crea un carro (ingresa al parqueo)
    {
        carro = c;
    }

    public void setNull() //se elimina un carro (sale del parqueo)
    {
        carro = null;
    }

    public Vehiculo getCarro() //obtener carro 
    {
        return carro;
    }

}
