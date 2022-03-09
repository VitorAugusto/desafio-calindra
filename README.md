# Desafio Calindra - Backend

## 👾 REST API

 Software desenvolvido em Java - Spring Boot, para o cálculo de distâncias entre diferentes endereços utilizando a API Geocoding do Google Maps 🗺️.
 
 A aplicação retorna via REST API:
 
 1) Os endereços recebidos
 2) As distâncias euclidianas entre todas as combinações de endereços
 3) Os endereços mais distantes entre si
 4) Os endereços mais próximos entre si


 `Formato de envio dos Endereços (JSON) :`
> URL POST: http://localhost:8080/api/get-distancias
 
 ```
 {
    "enderecos":
    [
        "Av. Rio Branco, 1 Centro, Rio de Janeiro RJ,20090003",
        "Praça Mal. Âncora, 122 Centro, Rio de Janeiro RJ, 20021200",
        "Rua 19 de Fevereiro, 34 Botafogo, Rio de Janeiro RJ, 22280030"
    ]
}
```

 `Retorno esperado (JSON) :`
 
 ```
{
    "listaEnderecosRecebidos": [
        {
            "enderecoInput": "Av. Rio Branco, 1 Centro, Rio de Janeiro RJ,20090003",
            "latitude": -22.8973551,
            "longitude": -43.1802782
        },
        {
            "enderecoInput": "Praça Mal. Âncora, 122 Centro, Rio de Janeiro RJ, 20021200",
            "latitude": -22.9039608,
            "longitude": -43.1703536
        },
        {
            "enderecoInput": "Rua 19 de Fevereiro, 34 Botafogo, Rio de Janeiro RJ, 22280030",
            "latitude": -22.9507471,
            "longitude": -43.1876543
        }
    ],
    "listaEnderecosDistancia": [
        {
            "endereco1": {
                "enderecoInput": "Av. Rio Branco, 1 Centro, Rio de Janeiro RJ,20090003",
                "latitude": -22.8973551,
                "longitude": -43.1802782
            },
            "endereco2": {
                "enderecoInput": "Praça Mal. Âncora, 122 Centro, Rio de Janeiro RJ, 20021200",
                "latitude": -22.9039608,
                "longitude": -43.1703536
            },
            "distancia": 0.011921952761606592
        },
        {
            "endereco1": {
                "enderecoInput": "Av. Rio Branco, 1 Centro, Rio de Janeiro RJ,20090003",
                "latitude": -22.8973551,
                "longitude": -43.1802782
            },
            "endereco2": {
                "enderecoInput": "Rua 19 de Fevereiro, 34 Botafogo, Rio de Janeiro RJ, 22280030",
                "latitude": -22.9507471,
                "longitude": -43.1876543
            },
            "distancia": 0.05389909568082081
        },
        {
            "endereco1": {
                "enderecoInput": "Praça Mal. Âncora, 122 Centro, Rio de Janeiro RJ, 20021200",
                "latitude": -22.9039608,
                "longitude": -43.1703536
            },
            "endereco2": {
                "enderecoInput": "Rua 19 de Fevereiro, 34 Botafogo, Rio de Janeiro RJ, 22280030",
                "latitude": -22.9507471,
                "longitude": -43.1876543
            },
            "distancia": 0.04988258301431545
        }
    ],
    "maiorDistancia": {
        "endereco1": {
            "enderecoInput": "Av. Rio Branco, 1 Centro, Rio de Janeiro RJ,20090003",
            "latitude": -22.8973551,
            "longitude": -43.1802782
        },
        "endereco2": {
            "enderecoInput": "Rua 19 de Fevereiro, 34 Botafogo, Rio de Janeiro RJ, 22280030",
            "latitude": -22.9507471,
            "longitude": -43.1876543
        },
        "distancia": 0.05389909568082081
    },
    "menorDistancia": {
        "endereco1": {
            "enderecoInput": "Av. Rio Branco, 1 Centro, Rio de Janeiro RJ,20090003",
            "latitude": -22.8973551,
            "longitude": -43.1802782
        },
        "endereco2": {
            "enderecoInput": "Praça Mal. Âncora, 122 Centro, Rio de Janeiro RJ, 20021200",
            "latitude": -22.9039608,
            "longitude": -43.1703536
        },
        "distancia": 0.011921952761606592
    }
}
```

## 📝 Regras e Validações

1) É necessário enviar no mínimo 2 endereços, caso contrário a aplicação retorna um erro.
2) Caso o endereço informado não seja encontrado pela API Geocoding, será atribuido a este endereço as informações de latitude e longitude como 0. 

