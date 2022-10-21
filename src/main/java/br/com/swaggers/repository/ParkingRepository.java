package br.com.swaggers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.swaggers.model.Parking;



@Repository

public interface ParkingRepository extends JpaRepository<Parking, String> { //<Entidade, tipo de dado da chave PK>
}
