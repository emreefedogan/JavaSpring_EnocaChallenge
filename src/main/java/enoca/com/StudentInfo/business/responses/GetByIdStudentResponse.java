package enoca.com.StudentInfo.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetByIdStudentResponse {

	private int id;
	private String name;
	
}
