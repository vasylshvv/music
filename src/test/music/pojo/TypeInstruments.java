package test.music.pojo;
import javax.persistence.Column;
/**
 * @author VasylKo
 * */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*create class type instruments*/

@Entity
@Table(name = "typeinstrument")
public class TypeInstruments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nametype")
	private String nameType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameType() {
		return nameType;
	}

	public void setNameType(String nameType) {
		this.nameType = nameType;
	}

	public TypeInstruments(Long id, String nameType) {
		this.id = id;
		this.nameType = nameType;
	}

	public TypeInstruments() {
	}
	
	
}
