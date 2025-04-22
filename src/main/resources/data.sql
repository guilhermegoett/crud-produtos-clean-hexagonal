-- Cria��o da tabela (opcional se estiver usando JPA com @Entity, mas inclu�do aqui para garantir)
CREATE TABLE IF NOT EXISTS produtos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    descricao VARCHAR(255),
    preco DOUBLE,
    quantidade INT
);

-- Inserts
INSERT INTO produtos (nome, descricao, preco, quantidade) VALUES ('Camiseta Branca', 'Camiseta 100% algodão', 39.90, 100);
INSERT INTO produtos (nome, descricao, preco, quantidade) VALUES ('Tênis Esportivo', 'Confortável e resistente', 249.99, 50);
INSERT INTO produtos (nome, descricao, preco, quantidade) VALUES ('Fone de Ouvido', 'Bluetooth com cancelamento de ruído', 199.99, 30);
INSERT INTO produtos (nome, descricao, preco, quantidade) VALUES ('Notebook', 'Core i5, 8GB RAM, SSD 256GB', 3599.00, 10);
INSERT INTO produtos (nome, descricao, preco, quantidade) VALUES ('Mouse Gamer', 'RGB, 6 botõoes programáveis', 89.90, 75);
INSERT INTO produtos (nome, descricao, preco, quantidade) VALUES ('Teclado Mecânico', 'Switch azul, LED', 229.00, 40);
INSERT INTO produtos (nome, descricao, preco, quantidade) VALUES ('Cadeira Gamer', 'Reclinável com apoio lombar', 999.99, 15);
INSERT INTO produtos (nome, descricao, preco, quantidade) VALUES ('Monitor 24"', 'Full HD, 75Hz', 799.00, 20);
INSERT INTO produtos (nome, descricao, preco, quantidade) VALUES ('Impressora Multifuncional', 'Scanner + Wi-Fi', 499.00, 18);
INSERT INTO produtos (nome, descricao, preco, quantidade) VALUES ('Smartphone Android', '64GB, câmera dupla', 1299.00, 25);
INSERT INTO produtos (nome, descricao, preco, quantidade) VALUES ('Capinha de Celular', 'Transparente silicone', 29.90, 200);
INSERT INTO produtos (nome, descricao, preco, quantidade) VALUES ('Power Bank', '10000mAh', 119.00, 60);
INSERT INTO produtos (nome, descricao, preco, quantidade) VALUES ('Relógio Digital', 'Resistente a Água', 89.90, 70);
INSERT INTO produtos (nome, descricao, preco, quantidade) VALUES ('Echo Dot', 'Assistente de voz Alexa', 349.00, 35);
INSERT INTO produtos (nome, descricao, preco, quantidade) VALUES ('Carregador USB-C', '18W Turbo', 49.90, 80);
INSERT INTO produtos (nome, descricao, preco, quantidade) VALUES ('Cabo HDMI', '1.5m 4K', 39.90, 90);
INSERT INTO produtos (nome, descricao, preco, quantidade) VALUES ('Pendrive 64GB', 'USB 3.0', 59.90, 100);
INSERT INTO produtos (nome, descricao, preco, quantidade) VALUES ('HD Externo 1TB', 'USB 3.0', 349.00, 22);
INSERT INTO produtos (nome, descricao, preco, quantidade) VALUES ('Webcam Full HD', 'Com microfone', 199.00, 28);
INSERT INTO produtos (nome, descricao, preco, quantidade) VALUES ('Tripé Celular', 'Ajustável alt 1.6m', 89.00, 42);
