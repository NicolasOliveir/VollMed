package com.alura.vollmed.controller;


import com.alura.vollmed.medico.DadosCadastroMedico;
import com.alura.vollmed.medico.Medico;
import com.alura.vollmed.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping()
    public void cadastrarMedico(@RequestBody DadosCadastroMedico dados) {
        medicoRepository.save(new Medico(dados));
    }

}
