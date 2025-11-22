Resumo dos Padrões de Projeto Utilizados

Este documento apresenta o estudo teórico dos padrões de projeto aplicados no sistema Task Manager, juntamente com as justificativas detalhadas para o uso de cada padrão no contexto da solução desenvolvida.

1. Singleton
Estudo Teórico

O padrão Singleton garante que uma classe possua apenas uma instância durante toda a execução do programa, fornecendo um ponto global de acesso a ela. É útil quando existe um recurso central que deve ser único e compartilhado por diferentes partes do sistema.

Justificativa no Projeto

No Task Manager, o gerenciamento de tarefas precisa ser centralizado para que todas as operações (criar, editar, concluir, notificar observadores, etc.) atuem sobre a mesma lista de tarefas.
A classe TaskManager foi implementada como Singleton para manter um único estado global e evitar inconsistências.

2. Observer
Estudo Teórico

O padrão Observer define uma relação de dependência um-para-muitos: quando o estado de um objeto muda, todos os seus observadores são notificados automaticamente. O padrão é indicado para sistemas que precisam registrar eventos, logs ou acionar comportamentos externos quando algo ocorre.

Justificativa no Projeto

Em um gerenciador de tarefas, é útil registrar ações, como criação, atualização ou conclusão de tarefas.
A implementação de Observer permite adicionar comportamentos reativos (como logs) sem alterar a lógica principal do sistema.
Com isso, o Task Manager continua organizado, extensível e com baixo acoplamento.

3. Command
Estudo Teórico

O padrão Command encapsula uma operação em um objeto, permitindo que ações sejam tratadas como entidades independentes. Isso separa a lógica da interface e facilita a extensão do sistema com novos comandos.

Justificativa no Projeto

Cada opção do menu do Task Manager (criar tarefa, listar, atualizar, concluir etc.) foi tratada como um comando individual.
Essa abordagem torna o código modular, organizado e fácil de manter, permitindo adicionar novas operações sem modificar o fluxo principal da aplicação (Main).

4. Factory Method
Estudo Teórico

O padrão Factory Method delega a responsabilidade de criar objetos para subclasses ou classes especializadas. Ele desacopla o código cliente da lógica de inicialização de objetos, facilitando manutenção e expansão.

Justificativa no Projeto

Como o Task Manager inclui diferentes tipos de tarefa (SimpleTask, UrgentTask, DeadlineTask), foi utilizada uma TaskFactory para centralizar sua criação.
Isso evita que o menu ou os comandos precisem saber detalhes de construção de cada tarefa, resultando em um código mais limpo e com responsabilidade bem definida.

Conclusão

A aplicação dos padrões Singleton, Observer, Command e Factory Method tornou o sistema Task Manager mais modular, extensível e organizado.
Cada padrão contribuiu para resolver problemas específicos de forma clean e escalável, reforçando boas práticas de desenvolvimento orientado a objetos.
