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
@Table(name = "PAQUETES")
public class Paquete {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PAQUETE")
	private long idPaquete;
	@Column(name = "DESCRIPCION")
	private String descripcion;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_CATEGORIA_PAQUETE")
	private CategoriaPaquete categoriaPaquete;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_TIPO_PAQUETE")
	private TipoPaquete tipoPaquete;
	@Column(name = "NRO_CERTIFICACION")
	private Integer nroCertificacion;

	public long getIdPaquete() {
		return idPaquete;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public CategoriaPaquete getCategoriaPaquete() {
		return categoriaPaquete;
	}

	public TipoPaquete getTipoPaquete() {
		return tipoPaquete;
	}

	public Integer getNroCertificacion() {
		return nroCertificacion;
	}

	public void setIdPaquete(long idPaquete) {
		this.idPaquete = idPaquete;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setCategoriaPaquete(CategoriaPaquete categoriaPaquete) {
		this.categoriaPaquete = categoriaPaquete;
	}

	public void setTipoPaquete(TipoPaquete tipoPaquete) {
		this.tipoPaquete = tipoPaquete;
	}

	public void setNroCertificacion(Integer nroCertificacion) {
		this.nroCertificacion = nroCertificacion;
	}

}
