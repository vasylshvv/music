package test.music.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "musinstuments")
public class MusicalInstruments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nameinstrument")
	private String nameInstruments;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "year")	
	private String releaseYear;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="typeinstrid")
	private TypeInstruments typeInstr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameInstruments() {
		return nameInstruments;
	}

	public void setNameInstruments(String nameInstruments) {
		this.nameInstruments = nameInstruments;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	public TypeInstruments getTypeInstr() {
		return typeInstr;
	}

	public void setTypeInstr(TypeInstruments typeInstr) {
		this.typeInstr = typeInstr;
	}

	public MusicalInstruments(Long id, String nameInstruments, Integer price, String releaseYear,
			TypeInstruments typeInstr) {
		this.id = id;
		this.nameInstruments = nameInstruments;
		this.price = price;
		this.releaseYear = releaseYear;
		this.typeInstr = typeInstr;
	}

	public MusicalInstruments() {
		// TODO Auto-generated constructor stub
	}

	public MusicalInstruments(Long id) {
		super();
		this.id = id;
	}
	
	
}
