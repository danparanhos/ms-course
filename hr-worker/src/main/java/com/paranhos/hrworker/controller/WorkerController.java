package com.paranhos.hrworker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paranhos.hrworker.model.Worker;
import com.paranhos.hrworker.repository.WorkerRepository;

@RestController
@RequestMapping("/workers")
public class WorkerController {

	@Autowired
	private WorkerRepository repository;
	
	@GetMapping
	private ResponseEntity<List<Worker>> listAll() {
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("{id}")
	private ResponseEntity<Worker> findById(@PathVariable Long id) {
		Worker obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}
	
}
