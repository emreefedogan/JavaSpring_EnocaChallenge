package enoca.com.StudentInfo.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="students")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
 public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // ID OTOMATIK ARTMASI ICIN
	@Column(name="id")
  private int id;
	
	@Column(name="name")
  private  String name;
  
	@OneToMany
  List<Univercity> universities;
   
}
