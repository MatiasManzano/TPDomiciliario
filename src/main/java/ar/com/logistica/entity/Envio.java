package ar.com.logistica.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ENVIOS")
public class Envio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NRO_ENVIO")
	private long numeroEnvio;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DIRECCION_ORIGEN")
	private Direccion direccionOrigen;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DIRECCION_DESTINO")
	private Direccion direccionDestino;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PAQUETE")
	private Paquete paquete;
	@Column(name = "PESO")
	private String peso;
	@Column(name = "CANTIDAD")
	private int cantidad;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "TRANSPORTE")
	private Transporte transporte;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "REMITENTE")
	private Cliente remitente;
	@Column(name = "DESTINATARIO")
	private String destinatario;
	@Column(name = "FECHA_ENVIO")
	private String fechaEnvio;
	@Column(name = "FECHA_ENTREGA")
	private String fechaEntrega;
	@Column(name = "IMPORTE")
	private String importe;

	public long getNumeroEnvio() {
		return numeroEnvio;
	}

	public Direccion getDireccionOrigen() {
		return direccionOrigen;
	}

	public Direccion getDireccionDestino() {
		return direccionDestino;
	}

	public Paquete getPaquete() {
		return paquete;
	}

	public String getPeso() {
		return peso;
	}

	public int getCantidad() {
		return cantidad;
	}

	public Transporte getTransporte() {
		return transporte;
	}

	public Cliente getRemitente() {
		return remitente;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public String getFechaEnvio() {
		return fechaEnvio;
	}

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public String getImporte() {
		return importe;
	}

	public void setNumeroEnvio(long numeroEnvio) {
		this.numeroEnvio = numeroEnvio;
	}

	public void setDireccionOrigen(Direccion direccionOrigen) {
		this.direccionOrigen = direccionOrigen;
	}

	public void setDireccionDestino(Direccion direccionDestino) {
		this.direccionDestino = direccionDestino;
	}

	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

	public void setRemitente(Cliente remitente) {
		this.remitente = remitente;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public void setFechaEnvio(String fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public void setImporte(String importe) {
		this.importe = importe;
	}

}
