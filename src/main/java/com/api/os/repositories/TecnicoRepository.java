package com.api.os.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.os.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long>{

}
