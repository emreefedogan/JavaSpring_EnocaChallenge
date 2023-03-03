package enoca.com.StudentInfo.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import enoca.com.StudentInfo.business.abstracts.StudentService;
import enoca.com.StudentInfo.business.requests.CreateStudentsRequest;
import enoca.com.StudentInfo.business.requests.UpdateStudentRequest;
import enoca.com.StudentInfo.business.responses.GetAllStudentsResponse;
import enoca.com.StudentInfo.business.responses.GetByIdStudentResponse;
import enoca.com.StudentInfo.core.utilities.mappers.ModelMapperService;
import enoca.com.StudentInfo.dataAccess.abstracts.StudentRepository;
import enoca.com.StudentInfo.entities.concretes.Student;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentManager implements StudentService {
	private StudentRepository studentRepository;
	private ModelMapperService modelMapperService;

//LISTELEME
	@Override
	public List<GetAllStudentsResponse> getAll() {
		// List ooldugu icin getall liste olusturmaliyiz
		// is kurallari buraya yazilir
		List<Student> students = studentRepository.findAll();

		// List<GetAllStudentsResponse> studentsResponse = new
		// ArrayList<GetAllStudentsResponse>();
//		
//		for( Student student : students)
//		{
//			GetAllStudentsResponse responseItem = new GetAllStudentsResponse();
//			responseItem.setId(student.getId());
//			responseItem.setName(student.getName());
		// buradaki degisken sayimiz fazla olsaydi mantiksiz bir kod olacakti
		// modelmapperdan yararlandım.
//			studentsResponse.add(responseItem);
//		}

		List<GetAllStudentsResponse> studentsResponse = students.stream()
				.map(student -> this.modelMapperService.forResponse().map(student, GetAllStudentsResponse.class))
				.collect(Collectors.toList());

		return studentsResponse;
	}

//KAYDETME
	@Override
	public void add(CreateStudentsRequest createStudentRequest) {
		// TODO Auto-generated method stub
		// Student student = new Student();
		// student.setName(createStudentRequest.getName());

		Student student = this.modelMapperService.forRequest().map(createStudentRequest, Student.class);

		this.studentRepository.save(student);
	}

	@Override
	public GetByIdStudentResponse getById(int id) {
		Student student = this.studentRepository.findById(id).orElseThrow();

		GetByIdStudentResponse response = this.modelMapperService.forResponse().map(student,
				GetByIdStudentResponse.class);
		return response;
	}

	@Override
	public void update(@RequestBody UpdateStudentRequest updateStudentRequest) {
		//UPDATE ISLEMINDE ID YE GORE INTERFACE VERDIGIMDEN IDYE GORE KAYDEDER. UPDATE YAPAR
	
	 Student student = this.modelMapperService.forResponse().map(updateStudentRequest,Student.class);
	 this.studentRepository.save(student);
	}

	@Override
	public void delete(int id) {
		 
		this.studentRepository.deleteById(id);

	}

}
