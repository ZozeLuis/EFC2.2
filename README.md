# EFC2.2
Task Manager – Projeto com Padrões de Projeto (Java)

Este projeto implementa um sistema simples de gerenciamento de tarefas utilizando quatro padrões de projeto clássicos: Singleton, Observer, Command e Factory Method.

O objetivo é demonstrar, de forma prática, como aplicar esses padrões em um sistema funcional, incluindo também princípios fundamentais de Clean Code. Abaixo está a descrição do projeto e a indicação de onde cada padrão e estratégia de Clean Code aparece.

Descrição do Projeto

O Task Manager permite:

Criar tarefas de diferentes tipos: SimpleTask, UrgentTask, DeadlineTask

Listar tarefas

Atualizar tarefas

Completar tarefas

Registrar ações por meio de observers

Executar operações por meio de commands

Gerenciar todas as tarefas por meio de um Singleton

Criar diferentes tipos de tarefa por meio de uma Factory

O usuário interage com o programa através de um menu no console.

Padrões Utilizados e Onde Estão no Código
1. Singleton

Classe: TaskManager
Função: Gerencia todas as tarefas e mantém apenas uma instância ativa.
Clean Code: Responsabilidade única, nomes claros (getInstance), ausência de duplicação de estado.

2. Observer

Classes: Observer (interface), LogObserver, lista de observers em TaskManager.
Função: Registrar ações como criação, atualização ou conclusão de tarefas.
Clean Code: Baixo acoplamento, código aberto para extensão, melhor organização de responsabilidades.

3. Command

Classes: Command (interface), CreateTaskCommand, ListTasksCommand, UpdateTaskCommand, CompleteTaskCommand.
Função: Cada operação do menu é encapsulada em um comando independente.
Clean Code: Métodos curtos, separação clara de ações, código modular e fácil de manter.

4. Factory Method

Classe: Task e suas implementações concretas.
Função: Centraliza a criação de tarefas dos tipos existentes.
Clean Code: Reduz acoplamento no menu, remove criação manual de objetos, cumpre o princípio de responsabilidade única.

Como Compilar e Executar
Via terminal

Certifique-se de estar na pasta onde estão os arquivos .java.

Compile todos os arquivos:

javac *.java


Execute o programa pela classe principal:

java Main

Via IDE (Eclipse, IntelliJ ou VSCode)

Importe a pasta do projeto como um projeto Java.

Localize o arquivo Main.java.

Clique com o botão direito e selecione Run.
