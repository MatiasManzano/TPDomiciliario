package ar.com.logistica.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LOCALIDADES")
public class Localidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_LOCALIDAD")
	private long idLocalidad;
	@Column(name = "NOMBRE")
	private String nombreLocalidad;
	@ManyToOne
	@JoinColumn(name = "ID_PROVINCIA")
	private Provincia provincia;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "localidad")
	private List<Direccion> direcciones;

	public long getIdLocalidad() {
		return idLocalidad;
	}

	public String getNombreLocalidad() {
		return nombreLocalidad;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public List<Direccion> getDirecciones() {
		return direcciones;
	}

	private void setIdLocalidad(long idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public void setNombreLocalidad(String nombreLocalidad) {
		this.nombreLocalidad = nombreLocalidad;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

}
