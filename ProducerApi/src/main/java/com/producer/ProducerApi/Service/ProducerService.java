package com.producer.ProducerApi.Service;

import java.util.List;
import java.util.Optional;

import com.producer.ProducerApi.Entity.Employee;

public interface ProducerService {

	public void enrollNewEmployee(Employee obj);
	public List<Employee> getAllEmployeeRecs();
	public Optional<Employee> getSpecificEmployeeRec(String email);
	public void updateSpecificEmployeeRec(Employee entityObj);
	public void deleteEmployeeRec(String email);
	
}
