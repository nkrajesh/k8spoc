package com.raj.controller;

import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    Environment env;
 
    @RequestMapping(value= "/sample", method = RequestMethod.GET)
    public ResponseEntity<String> addEmployee(@RequestParam String name, HttpServletRequest request) throws URISyntaxException {
    	String salutaton = env.getProperty("sample.salutation");
    	String msg = env.getProperty("sample.message");
    	return new ResponseEntity<String>(salutaton+" "+name+" "+msg + " from v2.. "+request.getRemoteHost() +","+request.getRemotePort(), HttpStatus.OK);    	 
    }
    
    @RequestMapping(value= "/sample1", method = RequestMethod.GET)
    public ResponseEntity<String> addEmployee1(@RequestParam String name, HttpServletRequest request) throws URISyntaxException {
    	String salutaton = env.getProperty("sample.salutation");
    	String msg = env.getProperty("sample.message");
    	return new ResponseEntity<String>(salutaton+" "+name+" "+msg + " from "+request.getRemoteHost() +","+request.getRemotePort(), HttpStatus.OK);    	 
    }
}
