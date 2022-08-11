package com.api.os.resources;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.os.dtos.TecnicoDTO;
import com.api.os.services.TecnicoService;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoResource {

	@Autowired
	private TecnicoService service;

	@Autowired
	private ModelMapper mapper;

	@GetMapping(value = "/{id}")
	public ResponseEntity<TecnicoDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(mapper.map(service.findById(id), TecnicoDTO.class));

	}

}
