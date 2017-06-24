package ar.com.logistica.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSPORTES")
public class Transporte {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TRANSPORTE")
	private long idTransporte;
	@Column(name = "TIPO")
	private String tipo;
	@Column(name = "MARCA")
	private String marca;
	@Column(name = "MODELO")
	private String modelo;
	@Column(name = "COLOR")
	private String color;
	@Column(name = "PATENTE")
	private String patente;
	@Column(name = "AÑO")
	private String anio;

	public long getIdTransporte() {
		return idTransporte;
	}

	public String getTipo() {
		return tipo;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getColor() {
		return color;
	}

	public String getPatente() {
		return patente;
	}

	public String getAnio() {
		return anio;
	}

	private void setIdTransporte(long idTransporte) {
		this.idTransporte = idTransporte;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

}
