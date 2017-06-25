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
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TELEFONO")
	private long idTelefono;
	@Column(name = "TIPO_TELEFONO")
	private String tipoTelefono;
	@Column(name = "NRO_TELEFONO")
	private long numeroTelefono;

}
