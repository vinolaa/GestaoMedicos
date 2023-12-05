-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 05/12/2023 às 17:37
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `projetoprogapp`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `consulta`
--

CREATE TABLE `consulta` (
  `cod_consulta` int(11) NOT NULL,
  `cod_paciente` int(11) NOT NULL,
  `crm` int(11) NOT NULL,
  `dia` date NOT NULL,
  `hora` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `especialidade_medico`
--

CREATE TABLE `especialidade_medico` (
  `cod_especialidade` int(11) NOT NULL,
  `nome` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `especialidade_medico`
--

INSERT INTO `especialidade_medico` (`cod_especialidade`, `nome`) VALUES
(1, 'Cardiologista'),
(2, 'Dermatologista'),
(3, 'Ortopedista');

-- --------------------------------------------------------

--
-- Estrutura para tabela `exame`
--

CREATE TABLE `exame` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `valor` double NOT NULL,
  `orientacoes` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `exame`
--

INSERT INTO `exame` (`codigo`, `nome`, `valor`, `orientacoes`) VALUES
(1, 'Hemograma', 90, 'Não ingerir bebidas alcoólicas 72 horas antes do exame, evitar exercícios físicos na véspera e comparecer ao laboratório com sua identidade para abertura de ficha. '),
(2, 'Glicemia em Jejum', 120, 'É necessário estar de 8 a 12 horas de jejum, sem consumir nenhum tipo de alimento ou bebidas, apenas água é permitido'),
(3, 'Eletrocardiograma', 150, 'Se alimentar normalmente antes do exame. Você também pode ingerir líquidos à vontade, mas bebidas alcoólicas não são recomendadas');

-- --------------------------------------------------------

--
-- Estrutura para tabela `exame_agendado`
--

CREATE TABLE `exame_agendado` (
  `nome_paciente` varchar(50) NOT NULL,
  `crm` int(11) NOT NULL,
  `data` date NOT NULL,
  `hora` time NOT NULL,
  `valor_pago` double NOT NULL,
  `cod_exame_agendado` int(11) NOT NULL,
  `cod_exame` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `exame_agendado`
--

INSERT INTO `exame_agendado` (`nome_paciente`, `crm`, `data`, `hora`, `valor_pago`, `cod_exame_agendado`, `cod_exame`) VALUES
('Gabriel', 123456, '2023-03-11', '09:30:00', 50, 1, 1),
('Caio', 998877, '2023-12-04', '10:00:00', 50, 2, 1),
('Caio', 123456, '2023-12-05', '14:30:00', 80, 3, 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `forma_pagamento`
--

CREATE TABLE `forma_pagamento` (
  `cod_forma_pagamento` int(11) NOT NULL,
  `forma_pagamento` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `forma_pagamento`
--

INSERT INTO `forma_pagamento` (`cod_forma_pagamento`, `forma_pagamento`) VALUES
(1, 'Pix'),
(2, 'Cartão de Débito'),
(3, 'Cartão de Crédito'),
(4, 'Dinheiro'),
(5, 'Boleto Bancário'),
(7, 'Cheque');

-- --------------------------------------------------------

--
-- Estrutura para tabela `medico`
--

CREATE TABLE `medico` (
  `crm` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `telefone` varchar(10) NOT NULL,
  `cod_especialidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `medico`
--

INSERT INTO `medico` (`crm`, `nome`, `endereco`, `telefone`, `cod_especialidade`) VALUES
(123456, 'Alan', 'Rua XYZ', '95261-2123', 2),
(998877, 'Matheus', 'Rua Dois', '96587-9144', 2);

-- --------------------------------------------------------

--
-- Estrutura para tabela `paciente`
--

CREATE TABLE `paciente` (
  `cod_paciente` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `telefone` varchar(10) NOT NULL,
  `foto` varchar(40) NOT NULL,
  `data_nascimento` date NOT NULL,
  `sexo` varchar(13) NOT NULL,
  `cod_forma_pagamento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `paciente`
--

INSERT INTO `paciente` (`cod_paciente`, `nome`, `endereco`, `telefone`, `foto`, `data_nascimento`, `sexo`, `cod_forma_pagamento`) VALUES
(1, 'Caio', 'Rua Teste', '91234-5678', 'Foto', '2000-11-03', 'Masculino', 1),
(2, 'Maria', 'Rua ABC', '91238-5452', 'Foto', '1998-07-12', 'Não Informar', 4),
(3, 'Gabriel', 'Rua das Flores, 1312', '99872-1243', 'Foto', '1999-07-11', 'Masculino', 1);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `consulta`
--
ALTER TABLE `consulta`
  ADD PRIMARY KEY (`cod_consulta`),
  ADD KEY `fk_cod_paciente` (`cod_paciente`),
  ADD KEY `fk_crm` (`crm`);

--
-- Índices de tabela `especialidade_medico`
--
ALTER TABLE `especialidade_medico`
  ADD PRIMARY KEY (`cod_especialidade`);

--
-- Índices de tabela `exame`
--
ALTER TABLE `exame`
  ADD PRIMARY KEY (`codigo`);

--
-- Índices de tabela `exame_agendado`
--
ALTER TABLE `exame_agendado`
  ADD PRIMARY KEY (`cod_exame_agendado`),
  ADD KEY `fk_cod_exame` (`cod_exame`);

--
-- Índices de tabela `forma_pagamento`
--
ALTER TABLE `forma_pagamento`
  ADD PRIMARY KEY (`cod_forma_pagamento`);

--
-- Índices de tabela `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`crm`),
  ADD KEY `fk_cod_especialidade` (`cod_especialidade`);

--
-- Índices de tabela `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`cod_paciente`),
  ADD KEY `fk_cod_forma_pagamento` (`cod_forma_pagamento`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `consulta`
--
ALTER TABLE `consulta`
  MODIFY `cod_consulta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `exame`
--
ALTER TABLE `exame`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `exame_agendado`
--
ALTER TABLE `exame_agendado`
  MODIFY `cod_exame_agendado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `forma_pagamento`
--
ALTER TABLE `forma_pagamento`
  MODIFY `cod_forma_pagamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `paciente`
--
ALTER TABLE `paciente`
  MODIFY `cod_paciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `consulta`
--
ALTER TABLE `consulta`
  ADD CONSTRAINT `fk_cod_paciente` FOREIGN KEY (`cod_paciente`) REFERENCES `paciente` (`cod_paciente`),
  ADD CONSTRAINT `fk_crm` FOREIGN KEY (`crm`) REFERENCES `medico` (`crm`);

--
-- Restrições para tabelas `medico`
--
ALTER TABLE `medico`
  ADD CONSTRAINT `fk_cod_especialidade` FOREIGN KEY (`cod_especialidade`) REFERENCES `especialidade_medico` (`cod_especialidade`);

--
-- Restrições para tabelas `paciente`
--
ALTER TABLE `paciente`
  ADD CONSTRAINT `fk_cod_forma_pagamento` FOREIGN KEY (`cod_forma_pagamento`) REFERENCES `forma_pagamento` (`cod_forma_pagamento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
