package com.alura.vollmed.medico;

public enum EspecialidadeEnum {
    ORTOPEDIA("ortopedia"),
    CARDIOLOGIA("cardiologista"),
    GINECOLOGIA("ginecologia"),
    DERMATOLOGIA("dermatologia");

    private final String especialidade;

    EspecialidadeEnum(String especialidade) {this.especialidade = especialidade;}

    public static EspecialidadeEnum fromLowCase(String text) {
        for (EspecialidadeEnum categoria : EspecialidadeEnum.values()) {
            if (categoria.especialidade.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhum especialidade compativel com: " + text);
    }
}
