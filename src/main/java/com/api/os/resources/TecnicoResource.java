package com.api.os.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.os.domain.Tecnico;
import com.api.os.dtos.TecnicoDTO;
import com.api.os.services.TecnicoService;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoResource {

	@Autowired
	private TecnicoService service;

	@Autowired
	private ModelMapper mapper;

	@PostMapping
	public ResponseEntity<TecnicoDTO> save(@Valid @RequestBody TecnicoDTO tecnicoDTO) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(service.save(tecnicoDTO).getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<TecnicoDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(mapper.map(service.findById(id), TecnicoDTO.class));

	}

	@GetMapping
	public ResponseEntity<List<TecnicoDTO>> findAll() {
		return ResponseEntity.ok().body(
				service.findAll().stream().map(x -> mapper.map(x, TecnicoDTO.class)).collect(Collectors.toList()));

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<TecnicoDTO> update(@PathVariable Long id, @RequestBody TecnicoDTO tecnicoDTO) {
		tecnicoDTO.setId(id);
		Tecnico newObj = service.update(tecnicoDTO);
		return ResponseEntity.ok().body(mapper.map(newObj, TecnicoDTO.class));

	}

}
