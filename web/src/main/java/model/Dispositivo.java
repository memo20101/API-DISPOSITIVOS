package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.
@Entity
@Table(name="dispositivo")
public class Dispositivo {
	
	//Primary key
	@Id
	@Column(name="ID")
	//auto_increment
	//@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long isbn;
	
	@Column(name="Tipedispositivo")
	private String tipe;
	
	@Column(name="Version")
	private String version;
	@Column(name="ID_pos")
	private String ID_pos;
	
	public Dispositivo () {
		
	}

	public Dispositivo (long isbn, String tipe, String version) {
		this.isbn = isbn;
		this.tipe = tipe;
		this.version = version;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String gettipe() {
		return tipe;
	}

	public void settipe(String tipe) {
		this.tipe = tipe;
	}

	public String getversion() {
		return version;
	}

	public void setversion(String version) {
		this.version = version;
	}
	public String getID_pos() {
		return ID_pos;
	}

	public void setID_pos(String ID_Pos) {
		this.ID_pos = ID_Pos;
	}
} 