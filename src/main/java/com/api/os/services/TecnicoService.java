package com.api.os.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.os.domain.Tecnico;
import com.api.os.repositories.TecnicoRepository;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;

	public Tecnico findById(Long id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElse(null);
	}

}
