package br.com.dio.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.dio.controller.dto.ParkingDTO;
import br.com.dio.model.Parking;

@Component
public class ParkingMapper {

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();
	
	public ParkingDTO ParkingDTO(Parking parking) {
		return MODEL_MAPPER.map(parking, ParkingDTO.class);
	} //INICIALIZA OBJETO RETORNA OS ATT PARA O OUTRO
	
	public List<ParkingDTO> toParkingDTOList(List<Parking> parkingList){
		
		return parkingList.stream().map(this::ParkingDTO).collect(Collectors.toList());
		
	}
}
