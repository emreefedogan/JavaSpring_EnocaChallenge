
package enoca.com.StudentInfo.entities.concretes;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="universities")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Univercity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // ID OTOMATIK ARTMASI ICIN
	@Column(name="id")
  private int id;
	
	@Column(name="name")
  private  String name;
  
	@ManyToOne
	@JoinColumn(name="student_id")
  private Student student;
	   

}
