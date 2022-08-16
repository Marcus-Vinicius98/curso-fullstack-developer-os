package com.api.os.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.os.domain.Tecnico;
import com.api.os.dtos.TecnicoDTO;
import com.api.os.repositories.TecnicoRepository;
import com.api.os.services.exceptions.DataIntegratyViolationException;
import com.api.os.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;

	@Autowired
	private ModelMapper mapper;

	public Tecnico save(TecnicoDTO tecnicoDTO) {
		findByCpf(tecnicoDTO);
		return repository.save(mapper.map(tecnicoDTO, Tecnico.class));
	}

	public Tecnico findById(Long id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id:" + id + ", Tipo: " + Tecnico.class.getName()));
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}

	public void findByCpf(TecnicoDTO tecnicoDTO) {
		Optional<Tecnico> obj = repository.findByCpf(tecnicoDTO.getCpf());
		if (obj.isPresent() && !obj.get().getId().equals(tecnicoDTO.getId())) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados");

		}

	}

}
