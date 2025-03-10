package com.demo.h2;

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
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LaptopController {
	
	@Autowired
	LaptopDAO dao;

	@PostMapping(path ="/insert", consumes = {"application/json"})
	public LaptopDTO insertLaptop(@RequestBody LaptopDTO laptop) {
		dao.save(laptop);
		return laptop;
	}
	
	@PutMapping(path ="/insert", consumes = {"application/json"})
	public LaptopDTO insertOrUpdateLaptop(@RequestBody LaptopDTO laptop) {
		dao.save(laptop);
		return laptop;
	}
	
	@GetMapping("/getAll")
	public List<LaptopDTO> getLaptopAll() {
		List<LaptopDTO> lap = dao.findAll();
		return lap;
	}
	
	@DeleteMapping(path = "/getAll/delete/{id}")
	public String deleteLaptop(@PathVariable("id") int id) {
		LaptopDTO lap = dao.getOne(id);
		dao.delete(lap);
		return "Deleted";
	}
	
	
	@GetMapping(path ="/getAllinPages", produces = {"application/xml"})
	public List<LaptopDTO> getLaptopAllinPage() {
		return dao.findAll();
	}
	
	@GetMapping("/getAllinPages/{id}")
	public Optional<LaptopDTO> getLaptopByIdPage(@PathVariable("id") int id) {
		return dao.findById(id);
	}
}
