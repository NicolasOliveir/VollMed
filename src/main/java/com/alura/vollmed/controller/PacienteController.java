package com.alura.vollmed.controller;

import com.alura.vollmed.paciente.DadosCadastroPaciente;
import com.alura.vollmed.paciente.Paciente;
import com.alura.vollmed.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    public void cadastroPaciente(@RequestBody DadosCadastroPaciente paciente){
        pacienteRepository.save(new Paciente(paciente));
    }
}
