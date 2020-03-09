DROP TABLE IF EXISTS transportadora;
 
CREATE TABLE transportadora (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  email VARCHAR(250) NOT NULL,
  nome VARCHAR(250) NOT NULL,
  cnpj VARCHAR(250) NOT NULL,
  telefone VARCHAR(30) NOT NULL,
  celular VARCHAR(30) NOT NULL,
  modal	VARCHAR(20) NOT NULL,
  cep VARCHAR(250) NOT NULL,
  uf  VARCHAR(2) NOT NULL,
  cidade VARCHAR(250) NOT NULL,
  bairro VARCHAR(250) NOT NULL,
  rua VARCHAR(250) NOT NULL,
  numero VARCHAR(20) NOT NULL,
  complemento VARCHAR(250) DEFAULT NULL, 
  url_logo VARCHAR(1000) NOT NULL
);

INSERT INTO transportadora (
  email,
  nome,
  cnpj,
  telefone,
  celular,
  modal,
  cep,
  uf,
  cidade,
  bairro,
  rua,
  numero,
  complemento, 
  url_logo)
  VALUES (
    'atendimento@rapidaocometa.com.br',
    'Rapidão Cometa',
    '17.512.518/0001-07',
    '(11) 2156-4762',
    '(11) 9 8818-4868',
    'Rodoviário',
    '09273-270',
    'SP',
    'Santo André',
    'Jardim Alzira Franco',
    'Travessa Hibisco',
    '741',
    'Sem complemento',
    'https://teclandotudo.com/wp-content/uploads/2013/06/Rapid%C3%A3o-Cometa-Rastreamento-de-Carga.jpg'
  );
  
INSERT INTO transportadora (
  email,
  nome,
  cnpj,
  telefone,
  celular,
  modal,
  cep,
  uf,
  cidade,
  bairro,
  rua,
  numero,
  complemento, 
  url_logo)
  VALUES (
    'atendimento@hamburg.com',
    'Hamburg Log',
    '24.883.117/0001-29',
    '(11) 2135-5627',
    '(11) 9 8785-1455',
    'Rodoviário',
    '08343-580',
    'SP',
    'São Paulo',
    'Jardim da Conquista (Zona Leste)',
    'Travessa Zazueira',
    '261',
    'Sem complemento',
    'https://cdn.freebiesupply.com/logos/large/2x/hamburg-logo-png-transparent.png'
  );
  
INSERT INTO transportadora (
  email,
  nome,
  cnpj,
  telefone,
  celular,
  modal,
  cep,
  uf,
  cidade,
  bairro,
  rua,
  numero,
  complemento, 
  url_logo)
  VALUES (
    'atendimento@sedex.com.br',
    'Sedex Log',
    '94.772.213/0001-85',
    '(11) 2145-2563',
    '(11) 9 7848-2365',
    'Aéreo',
    '14176-885',
    'SP',
    'Sertãozinho',
    'Chácaras de Recreio Pedregal - Vila Garcia',
    'Rua José Artur da Silva',
    '315',
    'Sem complemento',
    'https://www.lojas-na.net/WebRoot/Store/Shops/SINFIC_002E_Lojas-na-Net_002E_061004/55E5/9A96/AE6B/68EF/8C04/25E6/6498/70E6/icon-correios-brasil_ml.png'
  );