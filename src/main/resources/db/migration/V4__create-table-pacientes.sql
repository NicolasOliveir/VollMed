CREATE TABLE IF NOT EXISTS pacientes
(
    id          Bigserial                               NOT NULL,
    nome        VARCHAR(100)                            NOT NULL,
    email       VARCHAR(100)                            NOT NULL,
    telefone    VARCHAR(20)                             NOT NULL,
    cpf         VARCHAR(15)                             NOT NULL,
    logradouro  VARCHAR(100)                            NOT NULL,
    bairro      VARCHAR(100)                            NOT NULL,
    cep         VARCHAR(9)                              NOT NULL,
    complemento VARCHAR(100),
    numero      VARCHAR(20),
    uf          CHAR(2)                                 NOT NULL,
    cidade      VARCHAR(100)                            NOT NULL,
    ativo       BOOLEAN                                 NOT NULL,


    PRIMARY KEY (id)
);
