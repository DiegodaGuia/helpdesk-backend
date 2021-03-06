package com.valdir.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.valdir.helpdesk.domain.Chamado;
import com.valdir.helpdesk.domain.Cliente;
import com.valdir.helpdesk.domain.Tecnico;
import com.valdir.helpdesk.domain.enums.Perfil;
import com.valdir.helpdesk.domain.enums.Prioridade;
import com.valdir.helpdesk.domain.enums.Status;
import com.valdir.helpdesk.repositories.ChamadoRepository;
import com.valdir.helpdesk.repositories.ClienteRepository;

@Service
public class DBService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;

	public void instaciaDB() {
		
		Tecnico tec1 = new Tecnico(null, "diego guia", "05422376366", "diegodguia@gmail.com", encoder.encode("123"));
		tec1.addPerfis(Perfil.ADMIN);

		Cliente cli1 = new Cliente(null, "Larissa", "05422358641", "lari@gmail.com", encoder.encode("123"));

		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "chamado 01", "primeiro chamado", tec1,
				cli1);

		
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}
}
