package ar.com.logistica.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ENVIOS")
public class Envio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NRO_ENVIO")
	private long numeroEnvio;
	@Column(name = "CALLE")
	private String calle;
	@Column(name = "NUMERO")
	private int numero;
	@Column(name = "PISO")
	private Integer piso;
	@Column(name = "DEPARTAMENTO")
	private String departamento;
	@Column(name = "CP")
	private String codigoPostal;
	@OneToOne
	@JoinColumn(name = "ID_LOCALIDAD")
	private Localidad localidad;
	@Column(name = "PAQUETE")
	private String paquete;
	@OneToOne
	@JoinColumn(name = "ID_TIPO_PAQUETE")
	private TipoPaquete tipoPaquete;
	@OneToOne
	@JoinColumn(name = "ID_CATEGORIA_PAQUETE")
	private CategoriaPaquete categoriaPaquete;
	@Column(name = "PESO")
	private double peso;
	@Column(name = "CANTIDAD")
	private int cantidad;
	@OneToOne
	@JoinColumn(name = "TRANSPORTE")
	private Transporte transporte;
	@Column(name = "REMITENTE")
	private String remitente;
	@Column(name = "DESTINATARIO")
	private String destinatario;
	@Column(name = "IMPORTE")
	private double importe;
	@Column(name = "NRO_CERTIFICACION")
	private Integer nroCertificacion;

	public long getNumeroEnvio() {
		return numeroEnvio;
	}

	public String getCalle() {
		return calle;
	}

	public int getNumero() {
		return numero;
	}

	public Integer getPiso() {
		return piso;
	}

	public String getDepartamento() {
		return departamento;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public String getPaquete() {
		return paquete;
	}

	public TipoPaquete getTipoPaquete() {
		return tipoPaquete;
	}

	public CategoriaPaquete getCategoriaPaquete() {
		return categoriaPaquete;
	}

	public double getPeso() {
		return peso;
	}

	public int getCantidad() {
		return cantidad;
	}

	public Transporte getTransporte() {
		return transporte;
	}

	public String getRemitente() {
		return remitente;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public double getImporte() {
		return importe;
	}

	public Integer getNroCertificacion() {
		return nroCertificacion;
	}

	public void setNumeroEnvio(long numeroEnvio) {
		this.numeroEnvio = numeroEnvio;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public void setPaquete(String paquete) {
		this.paquete = paquete;
	}

	public void setTipoPaquete(TipoPaquete tipoPaquete) {
		this.tipoPaquete = tipoPaquete;
	}

	public void setCategoriaPaquete(CategoriaPaquete categoriaPaquete) {
		this.categoriaPaquete = categoriaPaquete;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public void setNroCertificacion(Integer nroCertificacion) {
		this.nroCertificacion = nroCertificacion;
	}

}
