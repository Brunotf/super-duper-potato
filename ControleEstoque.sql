CREATE DATABASE ControleEstoque
GO
USE ControleEstoque

CREATE TABLE finalidade (
id INT NOT NULL,
tipo VARCHAR(15) NOT NULL
PRIMARY KEY (id)
)

INSERT INTO finalidade (id, tipo) VALUES
('1','Cliente'),
('2', 'Salão')

CREATE TABLE tipoProd (
nomeTipo VARCHAR(30) NOT NULL
PRIMARY KEY (nomeTipo)
)

INSERT INTO tipoProd (nomeTipo) VALUES ('Condicionador'),
('Xampú'), 
('Esmalte'), 
('Tinta')

CREATE TABLE origem (
id INT NOT NULL,
tipo VARCHAR(15) NOT NULL
PRIMARY KEY(id)
)

INSERT INTO origem (id,tipo) VALUES
('1','Importado'),
('2','Nacional')

DROP TABLE produto

CREATE TABLE produto (
finalidade INT NOT NULL CHECK (finalidade > 0 AND finalidade < 3),
id INT IDENTITY (1,1) NOT NULL,
nome VARCHAR(100) UNIQUE NOT NULL,
marca VARCHAR(100) NOT NULL,
descricao VARCHAR (300) NOT NULL,
tipoProduto VARCHAR(30) NOT NULL,
origem INT NOT NULL CHECK (origem = 1 OR origem = 2),
quantidade INT NOT NULL CHECK (quantidade >= 0),
quantidadeAviso INT NOT NULL CHECK (quantidadeAviso >= 0),
validade CHAR(10) NOT NULL,
validadeAviso INT NOT NULL CHECK (validadeAviso >= 0),
valorProduto DECIMAL(7,2) NOT NULL CHECK (valorProduto >= 0),
descontoMax INT NOT NULL CHECK (descontoMax >= 0 AND descontoMax <= 100),
imagem VARCHAR(300)
PRIMARY KEY (id)
FOREIGN KEY (finalidade) REFERENCES finalidade(id),
FOREIGN KEY (tipoProduto) REFERENCES tipoProd(nomeTipo),
FOREIGN KEY (origem) REFERENCES origem(id)
)

SELECT * FROM produto

SELECT * FROM tipoProd

INSERT INTO produto (finalidade, nome, marca, descricao,tipoProduto, origem, quantidade, quantidadeAviso, validade,validadeAviso, valorProduto, descontoMax) VALUES
				(1, 'Xampu SEDA', 'SEDA', 'Usa-se na cabeça', 'Xampú', 1, 10, 5, '10/10/2015', 7, 50, 5),
				(1, 'Xampú Tressemé', 'Tressemé', 'Usa-se na cabeça', 'Xampú', 1, 10, 5, '14/07/2018', 7, 100, 10),
				(1, 'Condicinador Garnier', 'Garnier Fructis', 'Usa-se na cabeça', 'Xampú', 1, 10, 4, '28/03/2019', 7, 20, 10)
