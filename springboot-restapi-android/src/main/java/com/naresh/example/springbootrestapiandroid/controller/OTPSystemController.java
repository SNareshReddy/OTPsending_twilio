package com.naresh.example.springbootrestapiandroid.controller;

import java.util.HashMap;
import java.util.Map;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.example.springbootrestapiandroid.model.OTPSystem;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController
public class OTPSystemController {
	
	private Map<String, OTPSystem> otp_data = new HashMap<>();
	private final static String ACCOUNT_SID = "ACfb13cad6892c8cee15aadfe7a7d79400";
	private final static String AUTH_ID = "9c99711c61a5127bfb17b52d1c06a3dc";

	static {
		Twilio.init(ACCOUNT_SID, AUTH_ID);
	}

	//@RequestMapping(value = "/mobilenumbers/{mobilenumber}/otp", method = RequestMethod.POST)
	@PostMapping("/mobilenumbers/{mobilenumber}/otp")
	public ResponseEntity<Object> sendOTP(@PathVariable("mobilenumber") String mobilenumber) {
		OTPSystem otpSystem = new OTPSystem();
		otpSystem.setMobilenumber(mobilenumber);
		//String otp = String.format("%04d", random.nextInt(10000));
		otpSystem.setOtp(String.valueOf((int) (Math.random() * (10000 - 1000)) + 1000));
		//otpSystem.setOtp(String.valueOf(Integer.parseInt(otp)));
		
		otpSystem.setExpirytime(System.currentTimeMillis() + 20000);
		
		otp_data.put(mobilenumber, otpSystem);
		 
		Message.creator(new PhoneNumber("+919000802978"), new PhoneNumber("+18508763191"),"Your OTP is " + otpSystem.getOtp()).create();
		return new ResponseEntity<>("OTP is send successfully", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/mobilenumbers/{mobilenumber}/otp", method = RequestMethod.PUT)
	public ResponseEntity<Object> verifyOTP(@PathVariable("mobilenumber") String mobilenumber, @RequestBody OTPSystem requestBodyOTPSystem) {
		
		if(requestBodyOTPSystem.getOtp()==null || requestBodyOTPSystem.getOtp().trim().length()<=0) {
			return new ResponseEntity<>("Please provide OTP", HttpStatus.BAD_REQUEST);
		}
		
		if(otp_data.containsKey(mobilenumber)) {
			OTPSystem otpSystem = otp_data.get(mobilenumber);
			if(otpSystem!=null) {
				if(otpSystem.getExpirytime()>=System.currentTimeMillis()) {
					if(otpSystem.getOtp().equals(requestBodyOTPSystem.getOtp())) {
						otp_data.remove(mobilenumber);
						return new ResponseEntity<>("OTP is verified successfully", HttpStatus.OK);
					}
					return new ResponseEntity<>("Invalid OTP", HttpStatus.BAD_REQUEST);
				}
				return new ResponseEntity<>("OTP is expired...", HttpStatus.BAD_REQUEST);	
			}
			return new ResponseEntity<>("Something went wrong...", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Mobile number not found", HttpStatus.NOT_FOUND);
		
	}

}
