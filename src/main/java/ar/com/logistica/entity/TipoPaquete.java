package ar.com.logistica.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPOS_PAQUETES")
public class TipoPaquete {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TIPO_PAQUETE")
	private long idTipoPaquete;
	@Column(name = "DESCRIPCION")
	private String descripcion;

	public long getIdTipoPaquete() {
		return idTipoPaquete;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setIdTipoPaquete(long idTipoPaquete) {
		this.idTipoPaquete = idTipoPaquete;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
