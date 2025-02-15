package com.consumer.ConsumerApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.consumer.ConsumerApi.DTO.Employee;

@RestController
@RequestMapping("/ConsumerCall")
public class ConsumerController {

	@Autowired
	private DiscoveryClient eurekaRegProdClients;
	
//	http://localhost:8092/ConsumerCall
	@GetMapping
	public List<Employee> consumeAllDataOfRestTemplateProducer(){
		//geting producer url from eureka registry
		//List<ServiceInstance> prodInstancesList = eurekaRegProdClients.getInstances("ProducerApi");
		List<ServiceInstance> prodInstancesList = eurekaRegProdClients.getInstances("APIGateway");
		ServiceInstance oneInstanceObj = prodInstancesList.get(0);
		String url = oneInstanceObj.getUri().toString();
		System.out.println(url);
		RestTemplate dispatcherObj = new RestTemplate();
//		List<Employee> dataFromProducer= dispatcherObj.getForObject("http://localhost:8091/producerCall/endpointToHitOrShownInUrl",List.class);
		List<Employee> dataFromProducer= dispatcherObj.getForObject(url+"/producerCall/",List.class);
		return dataFromProducer;
	}
	
//	http://localhost:8092/consumerCall
	@PostMapping
	public String createConsumerProfile(@RequestBody Employee entityObj) {
		
		List<ServiceInstance> prodInstancesList = eurekaRegProdClients.getInstances("APIGateway");
		ServiceInstance oneInstanceObj = prodInstancesList.get(0);
		String url = oneInstanceObj.getUri().toString();
		RestTemplate postDispatcherObj = new RestTemplate();
		String result = postDispatcherObj.postForObject(url+"/producerCall/enrollNewEmployee/", entityObj, String.class);
		return result;
	}
	
//	http://localhost:8092/ConsumerCall
	@PutMapping
	public String editByConsumer(@RequestBody Employee entityObj) {
		List<ServiceInstance> prodInstancesList = eurekaRegProdClients.getInstances("APIGateway");
		ServiceInstance oneInstanceObj = prodInstancesList.get(0);
		String url = oneInstanceObj.getUri().toString();
		RestTemplate postDispatcherObj = new RestTemplate();
		postDispatcherObj.put(url+"/producerCall/updateRec/", entityObj);
		return "Update Successfully";
	}
	
//	http://localhost:8092/ConsumerCall/1235@yahoo.com
	@DeleteMapping("/{email}")
	//consumer is pathVariable & prod take requestParam
	public String deleteByconsumer(@PathVariable("email") String email) {
		List<ServiceInstance> prodInstancesList = eurekaRegProdClients.getInstances("APIGateway");
		ServiceInstance oneInstanceObj = prodInstancesList.get(0);
		String url = oneInstanceObj.getUri().toString();
		RestTemplate postDispatcherObj = new RestTemplate();
		postDispatcherObj.delete(url+"/producerCall/deleteRec/?email="+email);
		return "deleted successfully";
	}
}
