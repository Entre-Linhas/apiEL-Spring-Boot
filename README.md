#Normalmente é necessario configurar; Isso para o ambiente e modificações

No diretorio onde o pom.xml esta presente, execute o comando: "maven clean install package -U" ou "mvn package" sem aspas, assim vc build todos aspectos necessario.

Após isso, apenas rode a API ou use a target que foi feito atraves da build para lançar na nuvem AWS, não lembro exatamente oque, mas talvez o snapshot do target.

Se necessario use o arquivo "Ferramentas e configuração do ambiente.docx" para trazer compatiilidade.

#Melhorias Aplicadas

++ Funcionando no modo Validate

++ Versionamento de build aplicada

++ Gets da tabela de Materia, Pratica e Dica aplicada

++ FK do usuário com perfil aplicada, perfil possui o progresso(coluna)

++ Usuario com possiveis Exception configurado para criação de usuario

++ Construção da FK de algumas tabelas essenciais como Trilhas, Plano e Status

++ Construção da FK de tabelas que talvez use e talves não use como Atividades

++ Montagem dos caminhos restantes ou criação dos controlls faltantes como o da FK com GET/PUT da Atividades > Materia, Pratica e Dica

++ Adicionar os controlls nas partes extras, como Plano, Ferramentas e Pedidos

#Modo de segurança em andamento

* ??? Criaremos a tabela Comunidade e a FK para ela seria ManyToOne

* Estudo de autenticação para conseguir criptografar as senhas (Canceled, iremos usar FireBase)
  
* Estudos de segurança para criptografar senha (Canceled, iremos usar FireBase)
  
* Melhoria da resposta completa do Exception
  
* Melhoria dos tipos de validação através de .class

#Infinit.progress

-- Por fim apenas faltaria o controle de atualizações para manter atualizado oque é meio que infinito por sua vez não necessario no momento.

"Explicação de configuração de rotas serão aplicadas aqui e endereço da API assim que finalizar a metade do Modo de segurança"



#Using Metods

port:5000 - se necessario

#Corrective

https://dgc6qt23wamgi.cloudfront.net/"Continue com o frag das comandas, como no exemplo abaixo"

https://dgc6qt23wamgi.cloudfront.net/api/usuarios

#Emergency Post

http://apiel-dev-env-1.eba-txdr4tg3.us-east-2.elasticbeanstalk.com/"Continue com o frag das comandas, como no exemplo abaixo"

#GET - PEGAR OU INSERIR OU USAR DADOS

api/usuarios

retorna todos os dados dos usuarios

----------------

api/perfis

retorna todos os dados dos perfis

---------------
#POST - ADICIONAR DADOS

api/usuarios/login

{

  email: String

  senha: String

}

#POST - ADICIONAR DADOS

api/usuarios/cadastro

{

  "nome" : "RaRaRa",
  
  "email" : "Estamos!Junto",
  
  "senha" : "SoMaisUmPOUCO"
  
}

ou

{

  "idUsuario": 1,
  
  "nome": "String",
  
  "sobrenome": "String",
  
  "email": "String",
  
  "senha": "String",
  
  "cep": "String",
  
  "dataInicio": LocalDate,
  
  "dataTermino": LocalDate,
  
  "progresso": 0.1f,
  
  "endereco": "String",
  
  "numero": "String",
  
  "bairro": "String",
  
  "cidade": "String",
  
  "cpf": "String",
  
  "cnpj": "String",
  
  "plano": null,
  
  "status": null
  
}

------------------- PLANO E STATUS em breve ^^

api/pedidos/1

{

  "topicos_gerenciamento" : "Topic",
  
  "descricao_pedido" : "descript",
  
  "quantidade" : 10,
  
  "custo" : 10.5,
  
  "usuario" : {
  
    "idUsuario" : 1
    
  }
  
}

ou

{

  "id": 1,
  
  "topicosGerenciamento": "String",
  
  "descricaoPedido": "String",
  
  "quantidade": 10,
  
  "custo": 10.5,
  
  "usuario": {
  
    "idUsuario": 1,
    
    },
    
  "status": null
  
}

-------------------------------- STATUS em breve

api/precificacao/1

{

  "material" : "Lã",
  
  "preco" : 10.5,
  
  "quantidade" : 3,
  
  "pedidos" : {
  
    "id_pedidos" : 1
    
  }
  
}

ou

{

  "id": 1,
  
  "material": "String",
  
  "preco": 10.5,
  
  "quantidade": 3,
  
  "precoTotal": 31.5,
  
  "pedidos": {
  
    "id": 1
    
  }
  
}

-------------------------------- 

#PUT - EDITAR DADOS

api/atividades/1

{

  "progresso": 0.1,
  
  "materia" : {
  
    "idMateria" : 1
    
  },
  
  "pratica": {
  
    "idPratica" : 1
    
  },
  
  "dica": {
  
    "idDica" : 1
    
  }
  
}

ou

{

  "idAtividades": 1,
  
  "nomeAtividade": null,
  
  "status": null,
  
  "progresso": 0.1,
  
  "conteudo": null,
  
  "materia": {
  
  "idMateria" : 1
  
  },
  
  "pratica": {
  
    "idPratica" : 1
    
  },
  
  "dica": {
  
    "idDica" : 1
    
  }
  
  }
  
  }

----------------------------

api/perfis/1

{

  "combo" : 1,
  
  "trilhas" : { 
  
    "id" : 1
    
  }
  
}

ou

{

  "idPerfil": 1,
  
  "nivel": 1,
  
  "conquista": 10,
  
  "pontuacoes": 1000,
  
  "servico": String,
  
  "daily": LocalDate,
  
  "combo": 1,
  
  "maxCombo": 10,
  
  "progresso": 0.2f,
  
  }
  
----------------------------
api/usuarios/1

{

      "combo": 0,
      
    "maxCombo": 10,
    
    "progresso": null
    
}

ou

{


    "idUsuario": 2,
    
    "nome": "RaRaRa",
    
    "sobrenome": null,
    
    "email": "Estamos!Juntos",
    
    "senha": "Sasda",
    
    "cep": null,
    
    "dataInicio": null,
    
    "dataTermino": null,
    
    "progresso": null,
    
    "endereco": null,
    
    "numero": null,
    
    "bairro": null,
    
    "cidade": null,
    
    "cpf": null,
    
    "cnpj": null,
    
    "plano": null,
    
    "status": null
    
  }
  
-------------------------

  #DELETE - APAGA DADOS

  api/usuarios/1
  
#Tem varias outras que talves nem use!
