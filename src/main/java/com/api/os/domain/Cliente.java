package com.api.os.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "cliente")
	private List<OrdemServico> ordemServico = new ArrayList<>();

	public Cliente() {
		super();

	}

	public Cliente(Long id, String nome, String cpf, String telefone) {
		super(id, nome, cpf, telefone);

	}

	public List<OrdemServico> getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(List<OrdemServico> ordemServico) {
		this.ordemServico = ordemServico;
	}

}
