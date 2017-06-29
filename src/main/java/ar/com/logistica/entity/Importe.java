package ar.com.logistica.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "IMPORTES")
public class Importe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_IMPORTE")
	private long idImporte;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_LOCALIDAD")
	private Localidad localidad;
	@Column(name = "BASICO")
	private double basico;
	@Column(name = "ALOJAMIENTO")
	private double alojamiento;
	@Column(name = "COMIDAS")
	private double comidas;
	@Column(name = "COMBUSTIBLE")
	private double combustible;
	@Column(name = "PEAJES")
	private double peajes;
	@Column(name = "ADUANA")
	private double aduana;

	public long getIdImporte() {
		return idImporte;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public double getBasico() {
		return basico;
	}

	public double getAlojamiento() {
		return alojamiento;
	}

	public double getComidas() {
		return comidas;
	}

	public double getCombustible() {
		return combustible;
	}

	public double getPeajes() {
		return peajes;
	}

	public double getAduana() {
		return aduana;
	}

	public void setIdImporte(long idImporte) {
		this.idImporte = idImporte;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public void setBasico(double basico) {
		this.basico = basico;
	}

	public void setAlojamiento(double alojamiento) {
		this.alojamiento = alojamiento;
	}

	public void setComidas(double comidas) {
		this.comidas = comidas;
	}

	public void setCombustible(double combustible) {
		this.combustible = combustible;
	}

	public void setPeajes(double peajes) {
		this.peajes = peajes;
	}

	public void setAduana(double aduana) {
		this.aduana = aduana;
	}

}
