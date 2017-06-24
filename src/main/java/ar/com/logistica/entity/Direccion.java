package ar.com.logistica.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DIRECCIONES")
public class Direccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_DIRECCION")
	private long idDireccion;
	@Column(name = "CALLE")
	private String calle;
	@Column(name = "NUMERO")
	private int numero;
	@Column(name = "PISO")
	private int piso;
	@Column(name = "DEPTO")
	private String departamento;
	@Column(name = "CP")
	private String codigoPostal;
	@ManyToOne
	@JoinColumn(name = "ID_LOCALIDAD")
	private Localidad localidad;

	public long getIdDireccion() {
		return idDireccion;
	}

	public String getCalle() {
		return calle;
	}

	public int getNumero() {
		return numero;
	}

	public int getPiso() {
		return piso;
	}

	public String getDepartamento() {
		return departamento;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	private void setIdDireccion(long idDireccion) {
		this.idDireccion = idDireccion;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

}
