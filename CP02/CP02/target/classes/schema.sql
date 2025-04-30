-- Criação da tabela Empresa
CREATE TABLE empresa (
    cnpj VARCHAR(18) PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    pais VARCHAR(100) NOT NULL,
    logradouro VARCHAR(255) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    cep VARCHAR(9) NOT NULL
);

-- Tabela base para operações comerciais
CREATE TABLE operacao_comercial (
    codigo_operacao VARCHAR(50) NOT NULL,
    empresa_cnpj VARCHAR(18) NOT NULL,
    data_registro TIMESTAMP NOT NULL,
    valor_total DECIMAL(19,2) NOT NULL,
    PRIMARY KEY (codigo_operacao, empresa_cnpj),
    FOREIGN KEY (empresa_cnpj) REFERENCES empresa(cnpj)
);

-- Tabela para operações de exportação
CREATE TABLE exportacao (
    codigo_operacao VARCHAR(50) NOT NULL,
    empresa_cnpj VARCHAR(18) NOT NULL,
    destino_final VARCHAR(255) NOT NULL,
    incoterm VARCHAR(50) NOT NULL,
    PRIMARY KEY (codigo_operacao, empresa_cnpj),
    FOREIGN KEY (codigo_operacao, empresa_cnpj)
        REFERENCES operacao_comercial(codigo_operacao, empresa_cnpj)
);

-- Tabela para operações de importação
CREATE TABLE importacao (
    codigo_operacao VARCHAR(50) NOT NULL,
    empresa_cnpj VARCHAR(18) NOT NULL,
    origem_carga VARCHAR(255) NOT NULL,
    pais_origem VARCHAR(100) NOT NULL,
    PRIMARY KEY (codigo_operacao, empresa_cnpj),
    FOREIGN KEY (codigo_operacao, empresa_cnpj)
        REFERENCES operacao_comercial(codigo_operacao, empresa_cnpj)
);

-- Tabela para transportes
CREATE TABLE transporte (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigo_operacao VARCHAR(50) NOT NULL,
    empresa_cnpj VARCHAR(18) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    data_embarque TIMESTAMP NOT NULL,
    origem VARCHAR(255) NOT NULL,
    destino VARCHAR(255) NOT NULL,
    FOREIGN KEY (codigo_operacao, empresa_cnpj)
        REFERENCES operacao_comercial(codigo_operacao, empresa_cnpj)
);


-- Tabela para documentos
CREATE TABLE documento (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigo_operacao VARCHAR(50) NOT NULL,
    empresa_cnpj VARCHAR(18) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    data_emissao TIMESTAMP NOT NULL,
    FOREIGN KEY (codigo_operacao, empresa_cnpj)
        REFERENCES operacao_comercial(codigo_operacao, empresa_cnpj)
);

-- Índices para melhorar performance das consultas
CREATE INDEX idx_operacao_tipo ON operacao_comercial(empresa_cnpj, data_registro);
CREATE INDEX idx_transporte_data ON transporte(data_embarque);
CREATE INDEX idx_documento_tipo ON documento(tipo);
