
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

    private int horas;
   
    //Constructor
    public Vehiculo(String p, String ma, int mo, int h) //el usuario ingresa una nueva familia
    {
        placa = p;
        marca = ma;
        modelo = mo;

        horas = h;
    }

    
    /** 
     * @return String
     */
    public String getPlaca() //obtener placa
    {
        return placa;
    }

    
    /** 
     * @return String
     */
    public String getMarca() //obtener marca
    {
        return marca;
    }

    
    /** 
     * @return int
     */
    public int getModelo() //obtener modelo
    {
        return modelo;
    }   

    
    /** 
     * @return int
     */
    public int getHoras() //obtener horas que estuvo el carro en el parqueo
    {
        return horas;
    }

}
