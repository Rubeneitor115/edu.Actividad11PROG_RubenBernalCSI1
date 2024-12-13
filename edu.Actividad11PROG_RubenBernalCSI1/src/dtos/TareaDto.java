/**
 * Ruben Bernal Ramos, CSI1
 */

package dtos;

public class TareaDto {
    
	//Atributos
	private String nombre;
    private int tiempoEstimado;
    private int tiempoTrabajado;
    private String estado;

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public int getTiempoTotalTrabajado() {
        return tiempoTrabajado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void anyadirTiempo(int horas) {
        this.tiempoTrabajado += horas;
    }

    public void reiniciarTiempo() {
        this.tiempoTrabajado = 0;
    }

    //Constructores
    public TareaDto(String nombre, int tiempoEstimado) {
        this.nombre = nombre;
        this.tiempoEstimado = tiempoEstimado;
        this.tiempoTrabajado = 0;
        this.estado = "pendiente";
    }
    public TareaDto() {
    	
    }
}

