package ar.com.logistica.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTES")
public class Cliente {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CLIENTE")
	private long idCliente;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "APELLIDO")
	private String apellido;
	@Column(name = "TIPO_DOC")
	private String tipoDocumento;
	@Column(name = "NRO_DOC")
	private int numeroDocumento;
	@Column(name = "ID_DIRECCION")
	private Direccion direccion;
	@Column(name = "ID_TELEFONO")
	private Telefono telefono;
	@Column(name = "MAIL")
	private String mail;

}
