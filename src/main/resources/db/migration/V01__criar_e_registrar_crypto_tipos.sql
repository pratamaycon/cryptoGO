CREATE TABLE cripto_tipos (
  id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	data_criacao datetime NOT NULL 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into cripto_tipos(id, nome, data_criacao) values(1, 'Bitcon', '2021-01-27');