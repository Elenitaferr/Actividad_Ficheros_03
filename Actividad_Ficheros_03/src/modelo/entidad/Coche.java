package modelo.entidad;

import java.io.Serializable;
import java.util.Objects;

public class Coche implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6641523777634248872L;
	
	private int id;
	private String marca;
	private String modelo;
	private TipoMotor tipoMotor;
	public String getMarca() {
		return marca;
	}
	
	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public TipoMotor getTipoMotor() {
		return tipoMotor;
	}
	public void setTipoMotor(TipoMotor tipoMotor) {
		this.tipoMotor = tipoMotor;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Coche [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", tipoMotor=" + tipoMotor + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	

}
