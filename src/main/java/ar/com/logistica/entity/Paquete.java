package ar.com.logistica.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAQUETES")
public class Paquete {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PAQUETE")
	private long idPaquete;
	@Column(name = "DESCRIPCION")
	private String descripcion;
	@Column(name = "ID_CATEGORIA_PAQUETE")
	private CategoriaPaquete categoriaPaquete;
	@Column(name = "ID_TIPO_PAQUETE")
	private TipoPaquete tipoPaquete;
	@Column(name = "NRO_CERTIFICACION")
	private int nroCertificacion;
}
