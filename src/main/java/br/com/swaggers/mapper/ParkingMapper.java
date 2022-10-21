package br.com.swaggers.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.swaggers.controller.dto.ParkingCreateDTO;
import br.com.swaggers.controller.dto.ParkingDTO;
import br.com.swaggers.model.Parking;

@Component
public class ParkingMapper {

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();
	
	public ParkingDTO toParkingDTO(Parking parking) {
		return MODEL_MAPPER.map(parking, ParkingDTO.class);
	} //INICIALIZA OBJETO RETORNA OS ATT PARA O OUTRO
	
	public List<ParkingDTO> toParkingDTOList(List<Parking> parkingList){
		
		return parkingList.stream().map(this::toParkingDTO).collect(Collectors.toList());
		
	}
	
	public Parking toParking(ParkingDTO dto) {
		return MODEL_MAPPER.map(dto, Parking.class);
		
	}

	public Parking toParkingCreate(ParkingCreateDTO dto) {
		return MODEL_MAPPER.map(dto, Parking.class);
	}

	public Parking exit(String id, Parking parking) {
		// TODO Auto-generated method stub
		return null;
	}
}
