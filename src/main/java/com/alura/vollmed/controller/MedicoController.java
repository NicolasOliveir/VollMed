package com.alura.vollmed.controller;


import com.alura.vollmed.medico.DadosAtualizacaoMedico;
import com.alura.vollmed.medico.DadosCadastroMedico;
import com.alura.vollmed.medico.DadosListagemMedico;
import com.alura.vollmed.medico.Medico;
import com.alura.vollmed.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping
    public Page<DadosListagemMedico> listar(Pageable paginacao) {
        return medicoRepository.findAllByAtivoTrue(paginacao)
                .map(DadosListagemMedico::new);
    }

    @PostMapping()
    @Transactional
    public void cadastrarMedico(@RequestBody @Valid DadosCadastroMedico dados) {
        medicoRepository.save(new Medico(dados));
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void remover(@RequestParam @PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();
    }

}
