package com.api.os.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.os.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
