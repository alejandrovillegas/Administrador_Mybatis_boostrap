package com.estudiante.dao;
import java.util.List;

import model.*;

public interface DaoEstudiantes {

	void addEmployee(Estudiantes employee);
    
    void updateEmployee(Estudiantes employee);
    
    void deleteEmployee(Estudiantes employee);
    
    List<Estudiantes> getAllEmployees();
    
    Estudiantes getEmployeeById(int id);

	 List<Estudiantes> getAllestudiantes(int id);
	 
	List<Estudiantes> getAllestudiantesById(int id);

}
