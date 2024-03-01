package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.DTO.Category;
import com.Repository.CategoryRepository;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class CategoryController {
    @Autowired
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @PostMapping("/category/create")
	public ResponseEntity<Category> createCategory(@RequestBody Category data){
		System.out.println("createCategory");
		System.out.println(data);
		Category newData = new Category(data.getCategoryName());
		
		categoryRepository.save(newData);
		return new ResponseEntity<Category>(newData, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/category/get/all")
	List<Category> getAllCategory(){
		System.out.println("getAllCategory");
		return categoryRepository.findAll();
	}
}
