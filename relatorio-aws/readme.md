# RELATÓRIO DE IMPLEMENTAÇÃO DE SERVIÇOS AWS

Data: 31/08/2025
Empresa: Abstergo Industries
Responsável: JoaoVitorGL

# INTRODUÇÃO

Este relatório apresenta o processo de implementação de ferramentas na empresa Abstergo Industries, realizado por JoaoVitorGL. O objetivo do projeto foi elencar 3 serviços AWS, com a finalidade de realizar diminuição de custos imediatos.

# DESCRIÇÃO DO PROJETO

O projeto de implementação da ferramenta foi dividido em 3 etapas, cada uma com seus objetivos específicos. A seguir, serão descritas as etapas do projeto:

Etapa 1:

- Nome da ferramenta: Amazon EC2 Auto Scaling
- Foco da ferramenta: Otimização de Custos de Computação
- Descrição de caso de uso e Implantação:
  - Cenário: A Abstergo Industries possui aplicações web que experimentam picos de tráfego, resultando em altos custos com servidores superdimensionados que ficavam ociosos na maior parte do tempo.
  - Plano de Implantação: A implementação será realizada em quatro passos. Primeiro, será criada uma imagem de servidor padrão (AMI) com a aplicação configurada. Em segundo lugar, será definido um Launch Template que utilizará essa AMI. Terceiro, um Auto Scaling Group será configurado para manter um número mínimo de instâncias para a operação normal e um número máximo para suportar os picos. Por fim, serão estabelecidas políticas de escalonamento baseadas no uso de CPU: o sistema adicionará novas instâncias automaticamente quando a média de uso da CPU exceder 70% e as removerá quando cair abaixo de 30%, garantindo o pagamento apenas pela capacidade computacional necessária.

Etapa 2:

- Nome da ferramenta: Amazon S3 Intelligent-Tiering
- Foco da ferramenta: Otimização de Custos de Armazenamento de Dados
- Descrição de caso de uso e Implantação:
  - Cenário: A empresa armazena grandes volumes de dados (logs, backups, arquivos antigos) em uma camada de armazenamento de alto custo, sem diferenciar dados acessados frequentemente daqueles raramente utilizados.
  - Plano de Implantação: A ativação será direta e de baixo impacto. Primeiramente, serão identificados os buckets do Amazon S3 que contêm dados com padrões de acesso variáveis ou desconhecidos. Em seguida, será aplicada uma política de ciclo de vida nesses buckets para mover todos os objetos, novos e existentes, para a classe de armazenamento "S3 Intelligent-Tiering". A própria ferramenta, uma vez ativada, monitorará os padrões de acesso de cada objeto e os moverá automaticamente entre as camadas de acesso frequente e infrequente, otimizando os custos sem a necessidade de análise manual ou intervenção da equipe.

Etapa 3:

- Nome da ferramenta: AWS Cost Explorer
- Foco da ferramenta: Visibilidade, Análise e Gestão de Custos
- Descrição de caso de uso e Implantação:
  - Cenário: A gestão de custos era reativa, baseada apenas na fatura mensal, o que impedia a identificação rápida de gastos anômalos e oportunidades de economia.
  - Plano de Implantação: A implementação consistirá em três ações principais. Primeiro, o AWS Cost Explorer será ativado no console de gerenciamento de custos da conta AWS. Segundo, serão criadas políticas de acesso no IAM (Identity and Access Management) para conceder permissão de visualização às equipes de finanças e TI, permitindo que analisem os dados. Terceiro, serão configurados relatórios personalizados para detalhar os custos por projeto, utilizando as tags de recursos já existentes na infraestrutura. Adicionalmente, o serviço AWS Budgets será configurado para enviar alertas por e-mail caso os gastos de um projeto específico excedam o orçamento definido.

# CONCLUSÃO

A implementação da ferramenta na empresa Abstergo Industries tem como esperado uma redução significativa nos custos operacionais da nuvem, maior controle financeiro sobre os recursos de TI e uma infraestrutura mais eficiente e elástica, o que aumentará a eficiência e a produtividade da empresa. Recomenda-se a continuidade da utilização das ferramentas implementadas e a busca por novas tecnologias que possam melhorar ainda mais os processos da empresa.
