package br.com.swaggers.controller;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.swaggers.controller.dto.ParkingCreateDTO;
import br.com.swaggers.controller.dto.ParkingDTO;
import br.com.swaggers.mapper.ParkingMapper;
import br.com.swaggers.model.Parking;
import br.com.swaggers.service.ParkingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/parking")
@Api(value="Testes" , tags="Parking Controller")
@Tag(name = "")
public class ParkingController {
	
    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;
    

    
	public ParkingController() {
		this.parkingService = null;
		this.parkingMapper = new ParkingMapper();
	}

	public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
		super();
		this.parkingService = parkingService;
		this.parkingMapper = parkingMapper;
	}

	@GetMapping
	@ApiOperation("Encontrando parkings")
	public ResponseEntity<List<ParkingDTO>> findAll(){
		List<Parking> parkingList = parkingService.findAll();
		List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
		return ResponseEntity.ok(result);
	} //retorna statuscode = 200 - sucess
	
	@GetMapping("/{id}")
	public ResponseEntity<ParkingDTO> findById(@PathVariable String id){
		Parking parking = (Parking) parkingService.findById(id);

		ParkingDTO result = parkingMapper.toParkingDTO(parking);
		return ResponseEntity.ok(result);
	} //retorna statuscode = 200 - sucess
	
	@PostMapping
	public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO dto){
		var parkingCreate = parkingMapper.toParkingCreate(dto);

		Parking parking = parkingService.create(parkingCreate);
		ParkingDTO result = parkingMapper.toParkingDTO(parking);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	} //retorna statuscode = 201 - created
	
    
	@DeleteMapping("/{id}")
	public ResponseEntity<ParkingDTO> delete(@PathVariable String id){
		parkingService.delete(id);
		return ResponseEntity.noContent().build();
	} 
	
	@PutMapping("/{id}")
	public ResponseEntity<ParkingDTO> create(@PathVariable String id,@RequestBody ParkingCreateDTO dto){
		var parkingCreate = parkingMapper.toParkingCreate(dto);
		Parking parking = parkingService.update(id,parkingCreate);
		ParkingDTO result = parkingMapper.toParkingDTO(parking);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	} 
}
