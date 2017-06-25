package ar.com.logistica.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PAISES")
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PAIS")
	private long idPais;
	@Column(name = "NOMBRE")
	private String nombrePais;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pais")
	private List<Provincia> provincias;

	public long getIdPais() {
		return idPais;
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public List<Provincia> getProvincias() {
		return provincias;
	}

	public void setIdPais(long idPais) {
		this.idPais = idPais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	public void setProvincias(List<Provincia> provincias) {
		this.provincias = provincias;
	}

}
