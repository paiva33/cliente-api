CREATE TABLE IF NOT EXISTS `cliente` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(80) NOT NULL,
  `data_nascimento` date NOT NULL,
  `ativo` boolean NOT NULL,	
  PRIMARY KEY (`id`)
)