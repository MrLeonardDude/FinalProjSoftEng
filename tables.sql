CREATE TABLE `files` (
  `id` int(4) NOT NULL,
  `title` varchar(20) DEFAULT NULL,
  `file` mediumblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `historico_tarefa` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `progresso` int(11) DEFAULT NULL,
  `relatorio` varchar(100) DEFAULT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `membro` varchar(15) DEFAULT NULL,
  `tarefa` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `membro` (`membro`),
  KEY `tarefa` (`tarefa`),
  CONSTRAINT `historico_tarefa_ibfk_1` FOREIGN KEY (`membro`) REFERENCES `membros` (`username`),
  CONSTRAINT `historico_tarefa_ibfk_2` FOREIGN KEY (`tarefa`) REFERENCES `tarefas` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1

CREATE TABLE `membros` (
  `nome` varchar(50) DEFAULT NULL,
  `funcao` varchar(15) DEFAULT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `reuniao` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `data` varchar(20) NOT NULL,
  `local` varchar(20) DEFAULT NULL,
  `pauta` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1

CREATE TABLE `session_teste` (
  `id` int(11) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `tarefas` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `definicao` varchar(50) DEFAULT NULL,
  `descricao` varchar(100) DEFAULT NULL,
  `progressoTotal` int(11) DEFAULT '0',
  `estado` varchar(20) DEFAULT NULL,
  `dependencias` json DEFAULT NULL,
  `membros` json DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1
