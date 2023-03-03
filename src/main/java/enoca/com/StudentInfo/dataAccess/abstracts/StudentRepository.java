package enoca.com.StudentInfo.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import enoca.com.StudentInfo.entities.concretes.Student;

//JPA SAYESINDE OPERASYONLARI YAPACAGIZ

public interface StudentRepository extends JpaRepository<Student,Integer> {


	
}
