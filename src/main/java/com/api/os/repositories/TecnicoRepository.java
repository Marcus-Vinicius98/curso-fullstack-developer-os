package com.api.os.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.os.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long>{

	Optional<Tecnico> findByCpf(String cpf);

	


	
	


	
	
	}



