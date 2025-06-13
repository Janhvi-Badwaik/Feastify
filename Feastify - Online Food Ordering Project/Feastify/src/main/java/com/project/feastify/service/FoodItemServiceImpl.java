package com.project.feastify.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.project.feastify.dto.FoodItemReqDTO;
import com.project.feastify.dto.FoodItemRespDTO;
import com.project.feastify.entities.FoodItem;
import com.project.feastify.repository.FoodItemRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor

public class FoodItemServiceImpl implements FoodItemService {

	@Autowired
	private final FoodItemRepository foodItemRepository;
	
	private final ModelMapper modelMapper;

	@Override
	public String uploadFile(MultipartFile file) {
	String filenameExtension= file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."+1));
	String key = UUID.randomUUID().toString()+"."+filenameExtension;
	//try {
		/*PutObjectRequest.putObjectRequest = PutObjectRequest.Builder();
		 * 
		 * 
		 * 
		 */
	//}
	return null;
	}

	@Override
	public FoodItemRespDTO addFood(FoodItemReqDTO request, MultipartFile file) {
		
		FoodItem  foodItem = modelMapper.map(request, FoodItem.class);
		String imageUrl= uploadFile(file);
		foodItem.setImageURL(imageUrl);
		foodItem =  foodItemRepository.save(foodItem);
		return modelMapper.map(foodItem, FoodItemRespDTO.class);
		
		
		//return null;
	}
	
	
}
