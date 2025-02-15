package com.producer.ProducerApi.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.producer.ProducerApi.Entity.Employee;
import com.producer.ProducerApi.Service.ProducerService;

@RestController
@RequestMapping("/producerCall")
public class ProducerController {

	@Autowired
	public ProducerService prodService;
	
//	http://localhost:8091/producerCall/
	@GetMapping("/")
	public List<Employee> displayAll() {
		return prodService.getAllEmployeeRecs();
	}
	
//	http://localhost:8091/producerCall/enrollNewEmployee/
	@PostMapping("/enrollNewEmployee/")
	public String enrollNewEmployee(@RequestBody Employee entityObj) {
		prodService.enrollNewEmployee(entityObj);
		return "Record added succesfully";
	}
	
//	http://localhost:8091/producerCall/updateRec/
	@PutMapping("/updateRec/")
	public String updateSpecificEmployeeRec(@RequestBody Employee entityObj) {
		prodService.updateSpecificEmployeeRec(entityObj);
		return "Record updated succesfully";
	}
	
//	http://localhost:8091/producerCall/deleteRec/?email=abcde@yahoo.com
	@DeleteMapping("/deleteRec/")
	public String deleteEmployeeRec(@RequestParam("email") String email) {
		prodService.deleteEmployeeRec(email);
		return "Record deleted succesfully";
	}
	
//	http://localhost:8091/producerCall/getEmpByEmail/12345@yahoo.com
	@GetMapping("/getEmpByEmail/{email}")
	public Optional<Employee> getSpecificEmployeeRec(@PathVariable("email") String email) {
		return prodService.getSpecificEmployeeRec(email);
	}
}
