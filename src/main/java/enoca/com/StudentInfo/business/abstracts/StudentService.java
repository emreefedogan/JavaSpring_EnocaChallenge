package enoca.com.StudentInfo.business.abstracts;

import java.util.List;

import enoca.com.StudentInfo.business.requests.CreateStudentsRequest;
import enoca.com.StudentInfo.business.requests.UpdateStudentRequest;
import enoca.com.StudentInfo.business.responses.GetAllStudentsResponse;
import enoca.com.StudentInfo.business.responses.GetByIdStudentResponse;

public interface StudentService {
   List<GetAllStudentsResponse> getAll();
   GetByIdStudentResponse getById(int id);
   void add(CreateStudentsRequest createStudentRequest);
   void update(UpdateStudentRequest updateStudentRequest);
   void delete(int id);
   
}
