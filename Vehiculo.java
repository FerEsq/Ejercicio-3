
/* Nombre: Vehiculo.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 04.09.2021
 			  Modificado el 05.09.2021 */

public class Vehiculo 
{

    //Propiedades
    private String placa;
    private String marca;
    private int modelo;

    private int horaEntrada;
    private int horaSalida;
   
    public Vehiculo(String p, String ma, int mo, int e, int s) //el usuario ingresa una nueva familia
    {
        placa = p;
        marca = ma;
        modelo = mo;

        horaEntrada = e;
        horaSalida = s;
    }

    public String getPlaca()
    {
        return placa;
    }

    public String getMarca()
    {
        return marca;
    }

    public int getModelo()
    {
        return modelo;
    }   

    public String getEntrada()
    {
        return horaEntrada;
    }

    public String getSalida()
    {
        return horaSalida;
    }


}
