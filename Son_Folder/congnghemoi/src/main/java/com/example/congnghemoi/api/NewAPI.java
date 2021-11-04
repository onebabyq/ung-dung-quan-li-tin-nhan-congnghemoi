package com.example.congnghemoi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.congnghemoi.entity.NewEntity;
import com.example.congnghemoi.service.NewService;

@RestController
@RequestMapping(value = "/api")
public class NewAPI {
	@Autowired
	private NewService newService;
	
	@GetMapping(value="/news")
	public List<NewEntity> getNews() {
		
		return newService.findAll();
	}
	
	@GetMapping(value="/news/{id}")
	public NewEntity getNewById(@PathVariable long id) {
		
		return newService.findById(id);
	}
	@PostMapping(value="/news")
	public NewEntity saveNew(@RequestBody NewEntity newEntity) {
		
		return newService.save(newEntity);
	}
	@PutMapping(value="/news/{id}")
	public NewEntity updateNew(@RequestBody NewEntity newEntity) {
		NewEntity temp = newService.findById(newEntity.getId());
		if(temp==null)
			return null;
		return newService.save(newEntity);
	}
	@DeleteMapping(value="/news/{id}")
	public String deleteNew(@PathVariable long id) {
		newService.deleteById(id);
		return "Deleted New with id : "+id;
	}
}
