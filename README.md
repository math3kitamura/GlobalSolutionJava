# HealthMonitor — Plataforma Inteligente de Saúde e Monitoramento

> *Global Solution 2026 — ODS 9: Indústria, Inovação e Infraestrutura*  
> FIAP · 2ESPZ · Domain Driven Design - Java · Professora Damiana Costa

---

## Integrantes

| Nome | RM |
|------|----|
| Matheus Kitamura Gurther | RM563205 |
| Joao Guilherme Guida | RM565244 |
| Gustavo Barroso | RM565705 |
| Victor Alves | RM565723 |

---

## Sobre o Projeto

O *HealthMonitor* é uma plataforma inteligente de saúde desenvolvida em Java, voltada para o monitoramento de pacientes, agendamento de consultas e geração de alertas médicos em tempo real. A solução simula uma infraestrutura digital de saúde, conectando pacientes, médicos e administradores por meio de sensores inteligentes e um sistema de gestão integrado.

### Relação com o ODS 9

O projeto se alinha ao ODS 9 (Indústria, Inovação e Infraestrutura) ao propor:
- *Infraestrutura digital de saúde*: sistema integrado de gestão de consultas e monitoramento;
- *Inovação*: uso de sensores inteligentes (SensorSaude) para captura e análise de sinais vitais;
- *Automação*: geração automática de alertas com base em leituras críticas (temperatura, oxigenação, batimentos cardíacos);
- *Serviços conectados*: interface gráfica que conecta diferentes perfis de usuário em uma plataforma unificada.

---

## Funcionalidades

- *Login* com autenticação por perfil (Administrador, Médico, Paciente)
- *Cadastro* de médicos e pacientes
- *Agendamento, gerenciamento e cancelamento* de consultas
- *Monitoramento em tempo real* com sensor de saúde (temperatura, pressão arterial, batimentos, oxigenação)
- *Geração de alertas* automáticos por nível de risco (BAIXO, MODERADO, ALTO)
- *Relatórios* de consultas e monitoramento
- *Painel do Administrador* com visão geral do sistema

---

## Estrutura do Projeto


```text
src/
├── app/
│   └── Main.java                  → Ponto de entrada da aplicação
├── abstracts/
│   └── Usuario.java               → Classe abstrata base para todos os usuários
├── interfaces/
│   ├── Monitoravel.java           → Interface para entidades monitoráveis
│   └── Notificavel.java           → Interface para entidades que enviam notificações
├── model/
│   ├── Administrador.java         → Usuário do tipo Administrador
│   ├── Medico.java                → Usuário do tipo Médico
│   ├── Paciente.java              → Usuário do tipo Paciente
│   ├── SensorSaude.java           → Sensor inteligente de sinais vitais
│   ├── Consulta.java              → Entidade de consulta médica
│   ├── Alerta.java                → Entidade de alerta clínico
│   └── Relatorio.java             → Entidade de relatório
├── service/
│   ├── UsuarioService.java        → Regras de negócio de usuários
│   ├── ConsultaService.java       → Regras de negócio de consultas
│   └── MonitoramentoService.java  → Regras de negócio de monitoramento
└── view/
    ├── TelaLogin.java
    ├── TelaMenu.java
    ├── TelaAdministrador.java
    ├── TelaCadastroMedico.java
    ├── TelaCadastroPaciente.java
    ├── TelaConsulta.java
    ├── TelaGerenciarConsultas.java
    ├── TelaListaMedicos.java
    ├── TelaListaPacientes.java
    ├── TelaMonitoramento.java
    └── TelaRelatorioAlerta.java
```
---

## Conceitos de POO Aplicados

### Classe Abstrata — Usuario
Usuario é a classe abstrata base que representa qualquer usuário do sistema. Ela possui os atributos comuns (id, nome, cpf, telefone, login, senha), o método concreto autenticar() e o método abstrato exibirDados(), obrigando cada subclasse a definir sua própria forma de exibição.

### Herança
- Administrador, Medico e Paciente *herdam de Usuario*
- A herança representa uma relação real "é um usuário do sistema", reutilizando lógica de autenticação e dados comuns

### Interfaces
- Monitoravel — define o contrato emitirAlerta() e gerarRelatorio(), implementado por Paciente e SensorSaude
- Notificavel — define enviarNotificacao(), implementado por Medico e Administrador

### Sobrescrita (@Override)
Todos os subclasses sobrescrevem o método exibirDados() da classe abstrata Usuario, exibindo as informações específicas de cada perfil.

### Sobrecarga de Métodos
Na classe Relatorio, o método gerarRelatorio() é sobrecarregado:
- gerarRelatorio() — sem parâmetros, gera relatório padrão
- gerarRelatorio(String tipo) — com parâmetro, gera relatório por tipo específico

### Encapsulamento
Todos os atributos das classes são private, com acesso controlado por getters e setters públicos.

### Interface Gráfica (Swing)
A aplicação utiliza *Java Swing* para toda a interação com o usuário, por meio de telas específicas para cada funcionalidade.

---

## Como Executar

### Pré-requisitos
- Java JDK 11 ou superior
- IntelliJ IDEA (recomendado) ou qualquer IDE Java

### Passos
1. Clone o repositório:
   bash
   git clone <url-do-repositório>
   
2. Abra o projeto na sua IDE
3. Execute a classe app.Main
4. Na tela de login, utilize as credenciais padrão do administrador:
   - *Login:* admin
   - *Senha:* 123

---
