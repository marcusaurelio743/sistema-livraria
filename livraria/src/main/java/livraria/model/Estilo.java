package livraria.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estilo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100)
	private String estilo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	@Override
	public int hashCode() {
		return Objects.hash(estilo, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estilo other = (Estilo) obj;
		return Objects.equals(estilo, other.estilo) && Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Estilo [id=" + id + ", estilo=" + estilo + "]";
	}
	public Estilo() {
		
		this.id = (long) 0;
		this.estilo = "";
	}
	
	
	
	

}
