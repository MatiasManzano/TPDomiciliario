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
@Table(name = "PROVINCIAS")
public class Provincia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PROVINCIA")
	private long idProvincia;
	@Column(name = "NOMBRE")
	private String nombreProvincia;
	@ManyToOne
	@JoinColumn(name = "ID_PAIS")
	private Pais pais;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "provincia")
	private List<Localidad> localidades;

	public long getIdProvincia() {
		return idProvincia;
	}

	public String getNombreProvincia() {
		return nombreProvincia;
	}

	public Pais getPais() {
		return pais;
	}

	public List<Localidad> getLocalidades() {
		return localidades;
	}

	public void setIdProvincia(long idProvincia) {
		this.idProvincia = idProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public void setLocalidades(List<Localidad> localidades) {
		this.localidades = localidades;
	}

}
