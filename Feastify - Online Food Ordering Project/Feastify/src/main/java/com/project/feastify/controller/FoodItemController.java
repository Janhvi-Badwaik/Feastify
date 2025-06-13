package com.project.feastify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.project.feastify.dto.FoodItemReqDTO;
import com.project.feastify.service.FoodItemService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/food_items")
@AllArgsConstructor
public class FoodItemController {
	@Autowired
	private final FoodItemService foodItemService;
	
	@PostMapping
	public ResponseEntity<?> addFood(@RequestBody FoodItemReqDTO request ,@RequestPart("file") MultipartFile file ){
		//ObjectMapper objectMapper = new ObjectMapper();
		return ResponseEntity.status(HttpStatus.CREATED).body(foodItemService.addFood(request, file));
	}
	
	
	
	/*public ResponseEntity<?> addFoodItem (@Req)*/

}
