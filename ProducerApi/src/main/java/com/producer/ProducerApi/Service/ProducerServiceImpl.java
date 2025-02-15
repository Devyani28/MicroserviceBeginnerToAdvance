package com.producer.ProducerApi.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.producer.ProducerApi.Dao.ProducerDao;
import com.producer.ProducerApi.Entity.Employee;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class ProducerServiceImpl implements ProducerService{

	@Autowired
	public ProducerDao prodDao;
	
	private static final String CIRCUIT_BREAKER_NAME = "myCircuitBreaker";
	private static final String RETRY_NAME = "myRetry";
	
	@Override
	@Retry(name = RETRY_NAME, fallbackMethod = "fallbackPayment")
	public void enrollNewEmployee(Employee obj) {
		prodDao.save(obj);
		}
	public String fallbackPayment(Exception e) {
        return "Payment failed after retries. Please try again later!";
    }

	@Override
	@CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackResponse")
	public List<Employee> getAllEmployeeRecs() {
		List<Employee> empls = prodDao.findAll();
		return empls;
	}
	public String fallbackResponse(Exception e) {
        return "Payment Service is down. Please try later!";
    }
	
	@Override
	@Bulkhead(name = "myBulkhead", fallbackMethod = "bulkheadFallback")
	public Optional<Employee> getSpecificEmployeeRec(String email) {
		Optional<Employee> emp = prodDao.findById(email);
		return emp;
	}
	public String bulkheadFallback(Exception e) {
        return "Too many users requesting! Try later.";
    }

	@Override
	public void updateSpecificEmployeeRec(Employee entityObj) {
		prodDao.saveAndFlush(entityObj);
	}

	@Override
	@RateLimiter(name = "myRateLimiter", fallbackMethod = "rateLimitFallback")
	public void deleteEmployeeRec(String email) {
		prodDao.deleteById(email);
	}
	public String rateLimitFallback(Exception e) {
        return "Too many requests! Please try again later.";
    }
	
//	@Override
//	@TimeLimiter(name = "myTimeLimiter", fallbackMethod = "timeLimitFallback")
//	public Employee checkLoginService(String email, String password) {
//		// TODO Auto-generated method stub
//		return bDao.loginDAO(email, password);
//	}
//	public CompletableFuture<String> timeLimitFallback(Exception e) {
//        return CompletableFuture.supplyAsync(() -> "Request timed out! Try again later.");
//    }

}
