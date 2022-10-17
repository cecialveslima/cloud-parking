package br.com.dio.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.controller.dto.ParkingDTO;
import br.com.dio.controller.mapper.ParkingMapper;
import br.com.dio.model.Parking;
import br.com.dio.service.ParkingService;

@RestController
@RequestMapping("/parking")
public class ParkingController {
	
	private final ParkingService parkingService = new ParkingService();
	private final ParkingMapper parkingMapper = new ParkingMapper();
	
	
	@GetMapping
	public List<ParkingDTO> findAll(){
		List<Parking> parkingList = parkingService.findAll();
		List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
		return result;
	}
}
