package enoca.com.StudentInfo.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import enoca.com.StudentInfo.business.abstracts.StudentService;
import enoca.com.StudentInfo.business.requests.CreateStudentsRequest;
import enoca.com.StudentInfo.business.requests.UpdateStudentRequest;
import enoca.com.StudentInfo.business.responses.GetAllStudentsResponse;
import enoca.com.StudentInfo.business.responses.GetByIdStudentResponse;



//RESTFUL CONTROLLER OLDUGUNU BELIRTMELIYIM
@RestController
@RequestMapping("/api/students")
public class StudentsController {
 //DATA ACCESSDE BUSINESS KULLANDIK BURADA STUDENTSERVICE KULLANACAGIZ.
	private StudentService studentService;

	@Autowired
	public StudentsController(StudentService studentService) {
        this.studentService = studentService;
	}
	
	
	// api/students/getAll ile calisir
    @GetMapping("/getall")
	public List<GetAllStudentsResponse> getAll(){
		return studentService.getAll();
		
	}
    
	// api/students/getAll ile calisir
    @GetMapping("/{id}")
	public GetByIdStudentResponse getById(@PathVariable int id){
		return studentService.getById(id);
		
	}
    
    //api/students/add
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED) // KOD 201 DONDURSUN DIYE YAZDIM.
	public void add(CreateStudentsRequest createStudentRequest) {
		this.studentService.add(createStudentRequest);
	}
	
	
	@PutMapping
	public void update(UpdateStudentRequest updateStudentRequest) {
	
		this.studentService.update(updateStudentRequest);
		
		
	}
	

    @DeleteMapping("/{id}")
	public void delete(@PathVariable int id)
	{
    	this.studentService.delete(id);
    	
	}
		
	}
