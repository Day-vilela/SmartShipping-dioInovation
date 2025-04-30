# SmartShipping - Sistema de Frete Inteligente

## 📘 Descrição
Aplicação desenvolvida com Spring Boot aplicando o padrão de projeto Strategy para o cálculo de frete de pedidos. 

## 🛠 Tecnologias
- Java 17+
- Spring Boot
- Maven
- IntelliJ IDEA
- Lombok
- H2 (opcional)

## 🎯 Padrão Strategy
Utilizamos o padrão Strategy para encapsular diferentes regras de cálculo de frete:
- Frete por peso
- Frete por distância
- Frete por valor do pedido
- Etc.

## 🏁 Como executar
1. Clone o projeto
2. Execute `./mvnw spring-boot:run`
3. Use o Postman ou Swagger para testar os endpoints

## 📂 Estrutura
Veja o arquivo `Directory Structure Overview`.

## 📌 Exemplo de uso
```json
{
  "peso": 10.0,
  "valor": 300.00,
  "destino": "SP"
}
