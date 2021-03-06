package ar.com.logistica.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TELEFONOS")
public class Telefono {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TELEFONO")
	private long idTelefono;
	@Column(name = "TIPO_TELEFONO")
	private String tipoTelefono;
	@Column(name = "NRO_TELEFONO")
	private long numeroTelefono;

	public long getIdTelefono() {
		return idTelefono;
	}

	public String getTipoTelefono() {
		return tipoTelefono;
	}

	public long getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setIdTelefono(long idTelefono) {
		this.idTelefono = idTelefono;
	}

	public void setTipoTelefono(String tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}

	public void setNumeroTelefono(long numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

}
