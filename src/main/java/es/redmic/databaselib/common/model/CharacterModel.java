package es.redmic.databaselib.common.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class CharacterModel extends SuperModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = true)
	private Character id;

	public CharacterModel() {
		super();
	}

	public Character getId() {
		return id;
	}

	public void setId(Character id) {
		this.id = id;
	}

}
