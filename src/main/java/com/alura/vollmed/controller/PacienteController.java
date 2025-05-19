package com.alura.vollmed.controller;

import com.alura.vollmed.medico.DadosListagemMedico;
import com.alura.vollmed.paciente.DadosAtualizacaoPaciente;
import com.alura.vollmed.paciente.DadosCadastroPaciente;
import com.alura.vollmed.paciente.DadosListagemPaciente;
import com.alura.vollmed.paciente.Paciente;
import com.alura.vollmed.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public void cadastroPaciente(@RequestBody @Valid DadosCadastroPaciente paciente){
        pacienteRepository.save(new Paciente(paciente));
    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(Pageable paginacao) {
        return pacienteRepository.findAll(paginacao)
                .map(DadosListagemPaciente::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados){
        var paciente = pacienteRepository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
    }

    @DeleteMapping
    @Transactional
    public void excluir(@RequestParam Long id){
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.excluir();
    }
}
