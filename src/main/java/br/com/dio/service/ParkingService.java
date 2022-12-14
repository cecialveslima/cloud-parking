package br.com.dio.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.dio.model.Parking;

@Service
public class ParkingService {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static Map<String, Parking> parkingMap =  new HashMap();
	
	static {
		var id = getUUID();
		
		Parking parking = new Parking(id,"XYS-1294", "SP", "CORSA","PRETO");
		parkingMap.put(id, parking);
		
	}
	
	public List<Parking> findAll(){
		return parkingMap.values().stream().collect(Collectors.toList());
	}

	private static String getUUID() {
		return UUID.randomUUID().toString().replace("-","");
	}

	public ParkingService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
