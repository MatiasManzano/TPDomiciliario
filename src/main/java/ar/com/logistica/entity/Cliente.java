package ar.com.logistica.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTES")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_DIRECCION")
	private Direccion direccion;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_TELEFONO")
	private List<Telefono> telefonos;
	@Column(name = "MAIL")
	private String mail;

	public long getIdCliente() {
		return idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public int getNumeroDocumento() {
		return numeroDocumento;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	public String getMail() {
		return mail;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public void setNumeroDocumento(int numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
