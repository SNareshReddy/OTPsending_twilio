/*package com.naresh.example.springbootrestapiandroid.controller;

import java.net.URLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OTPRest {
	
	@PostMapping("/otp")
	public ResponseEntity<Object> sendOtp(){
		
		
		return new ResponseEntity<>("success",HttpStatus.OK);
	}
	
	URLConnection myUrl = null;
	
	HttpResponse<String> response = Unirest.post("https://control.msg91.com/api/verifyRequestOTP.php?authkey=&mobile=&otp=")
	  .header("content-type", "application/x-www-form-urlencoded")
	  .asString();
	

}
*/