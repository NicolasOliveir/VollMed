package com.alura.vollmed.paciente;

import com.alura.vollmed.endereco.Endereco;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroPaciente(
        @NotBlank
        String nome,
        @NotBlank
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        String cpf,
        @NotBlank
        Endereco endereco ) { }
