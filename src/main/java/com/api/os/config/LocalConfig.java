package com.api.os.config;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.api.os.domain.Cliente;
import com.api.os.domain.OrdemServico;
import com.api.os.domain.Tecnico;
import com.api.os.domain.enums.Prioridade;
import com.api.os.domain.enums.Status;
import com.api.os.repositories.ClienteRepository;
import com.api.os.repositories.OrdemServicoRepository;
import com.api.os.repositories.TecnicoRepository;

@Configuration
public class LocalConfig {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Bean
	public void StartDb() {
		
		Cliente c1 = new Cliente(null, "marcus","679.122.690-02", "85 85745-7482");
		Tecnico t1 = new Tecnico(null, "andreia", "611.778.100-85", "85 85745-7482");
		OrdemServico os1 = new OrdemServico(null,Prioridade.ALTA, "Teste create", Status.ANDAMENTO, t1, c1);
		
		clienteRepository.saveAll(Arrays.asList(c1));
		tecnicoRepository.saveAll(Arrays.asList(t1));
		ordemServicoRepository.saveAll(Arrays.asList(os1));
		
		
	}

}
