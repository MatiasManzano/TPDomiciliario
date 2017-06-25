package ar.com.logistica.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIAS_PAQUETES")
public class CategoriaPaquete {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CATEGORIA_PAQUETE")
	private long idCategoriaPaquete;
	@Column(name = "DESCRIPCION")
	private String descripcion;

}
