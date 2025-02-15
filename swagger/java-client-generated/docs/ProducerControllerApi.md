# ProducerControllerApi

All URIs are relative to *http://localhost:8091*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteEmployeeRec**](ProducerControllerApi.md#deleteEmployeeRec) | **DELETE** /producerCall/deleteRec/ | 
[**displayAll**](ProducerControllerApi.md#displayAll) | **GET** /producerCall/ | 
[**enrollNewEmployee**](ProducerControllerApi.md#enrollNewEmployee) | **POST** /producerCall/enrollNewEmployee/ | 
[**getSpecificEmployeeRec**](ProducerControllerApi.md#getSpecificEmployeeRec) | **GET** /producerCall/getEmpByEmail/{email} | 
[**updateSpecificEmployeeRec**](ProducerControllerApi.md#updateSpecificEmployeeRec) | **PUT** /producerCall/updateRec/ | 

<a name="deleteEmployeeRec"></a>
# **deleteEmployeeRec**
> String deleteEmployeeRec(email)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProducerControllerApi;


ProducerControllerApi apiInstance = new ProducerControllerApi();
String email = "email_example"; // String | 
try {
    String result = apiInstance.deleteEmployeeRec(email);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProducerControllerApi#deleteEmployeeRec");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **String**|  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="displayAll"></a>
# **displayAll**
> List&lt;Employee&gt; displayAll()



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProducerControllerApi;


ProducerControllerApi apiInstance = new ProducerControllerApi();
try {
    List<Employee> result = apiInstance.displayAll();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProducerControllerApi#displayAll");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Employee&gt;**](Employee.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="enrollNewEmployee"></a>
# **enrollNewEmployee**
> String enrollNewEmployee(body)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProducerControllerApi;


ProducerControllerApi apiInstance = new ProducerControllerApi();
Employee body = new Employee(); // Employee | 
try {
    String result = apiInstance.enrollNewEmployee(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProducerControllerApi#enrollNewEmployee");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Employee**](Employee.md)|  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="getSpecificEmployeeRec"></a>
# **getSpecificEmployeeRec**
> Employee getSpecificEmployeeRec(email)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProducerControllerApi;


ProducerControllerApi apiInstance = new ProducerControllerApi();
String email = "email_example"; // String | 
try {
    Employee result = apiInstance.getSpecificEmployeeRec(email);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProducerControllerApi#getSpecificEmployeeRec");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **String**|  |

### Return type

[**Employee**](Employee.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="updateSpecificEmployeeRec"></a>
# **updateSpecificEmployeeRec**
> String updateSpecificEmployeeRec(body)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProducerControllerApi;


ProducerControllerApi apiInstance = new ProducerControllerApi();
Employee body = new Employee(); // Employee | 
try {
    String result = apiInstance.updateSpecificEmployeeRec(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProducerControllerApi#updateSpecificEmployeeRec");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Employee**](Employee.md)|  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

