INSERT INTO empresa (cnpj, nome, pais, cep, logradouro, cidade, estado)
VALUES
('12.345.678/0001-90', 'TechGlobal S.A.', 'Brasil', '01310-000', 'Av. Paulista, 1000', 'São Paulo', 'SP'),
('98.765.432/0001-00', 'Importadora Luna Ltda.', 'Brasil', '20031-005', 'Rua da Alfândega, 45', 'Rio de Janeiro', 'RJ');

-- Exportação
INSERT INTO operacao_comercial (codigo_operacao, empresa_cnpj, data_registro, valor_total)
VALUES ('EXP001', '12.345.678/0001-90', '2025-04-01 10:00:00', 150000.00);

INSERT INTO exportacao (codigo_operacao, empresa_cnpj, destino_final, incoterm)
VALUES ('EXP001', '12.345.678/0001-90', 'Lisboa, Portugal', 'FOB');

-- Importação
INSERT INTO operacao_comercial (codigo_operacao, empresa_cnpj, data_registro, valor_total)
VALUES ('IMP001', '98.765.432/0001-00', '2025-04-05 15:30:00', 85000.00);

INSERT INTO importacao (codigo_operacao, empresa_cnpj, origem_carga, pais_origem)
VALUES ('IMP001', '98.765.432/0001-00', 'Shenzhen', 'China');

INSERT INTO documento (codigo_operacao, empresa_cnpj, tipo, nome, data_emissao)
VALUES
('EXP001', '12.345.678/0001-90', 'Nota Fiscal', 'NF Exportação Portugal', '2025-03-30 09:00:00'),
('IMP001', '98.765.432/0001-00', 'Invoice', 'Fatura Importação Eletrônicos', '2025-04-02 08:45:00');

INSERT INTO transporte (codigo_operacao, empresa_cnpj, tipo, data_embarque, origem, destino)
VALUES
('EXP001', '12.345.678/0001-90', 'Navio', '2025-04-02 11:00:00', 'São Paulo', 'Lisboa'),
('IMP001', '98.765.432/0001-00', 'Avião', '2025-04-06 13:20:00', 'Rio de Janeiro', 'Shenzhen');

