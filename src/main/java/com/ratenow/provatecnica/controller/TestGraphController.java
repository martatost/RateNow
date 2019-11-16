package com.ratenow.provatecnica.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ratenow.provatecnica.model.TestGraph;
import com.ratenow.provatecnica.repositories.TestGraphRepository;

@RestController
public class TestGraphController {
	
	@Autowired
	TestGraphRepository testGraphRepository;
	
	//EndPoint POST
	@RequestMapping (value="/testgraph", method= RequestMethod.POST,
			consumes= MediaType.APPLICATION_JSON_VALUE)
	public void newTestGraph(@RequestBody TestGraph testGraph){
		testGraphRepository.save(testGraph);
	}
	
	
	
	//EndPoints GET
	@RequestMapping (value="/testgraph/{graphid}", method=RequestMethod.GET)
	public TestGraph getById(@PathVariable ("graphid") Long id) {
		
		Optional<TestGraph> optional = testGraphRepository.findById(id);
		TestGraph testGraph = optional.isPresent() ? optional.get() : null;
		return testGraph;
	}

}
