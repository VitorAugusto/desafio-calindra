package com.vitor.desafiocalindra.desafiocalindra.services;


import com.vitor.desafiocalindra.desafiocalindra.models.EnderecoDistancia;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistanciaUtilsService {


    //CALCULA A DISTÂNCIA EUCLIDIANA ENTRE 2 COORDENADAS.
    //X1, Y1  = Endereço 1
    //X2, Y2  = Endereço 2
    public double calcularDistanciaEntre2Pontos(double x1, double y1, double x2, double y2) {

        double distance = Math.hypot(x1-x2, y1-y2);
        return distance;
    }


    //RECEBE UMA LISTA DE ENDEREÇOS/DISTÂNCIA E RETORNA A COMBINAÇÃO COM A MENOR DISTÂNCIA ENTRE ELES.
    public EnderecoDistancia getMenorDistancia(List<EnderecoDistancia> listaEnderecos){

        EnderecoDistancia menorDistancia = new EnderecoDistancia()
        {
            {distancia = 999999999.99;}
        };

        for (int i = 0; i < listaEnderecos.size(); i++){
            if(listaEnderecos.get(i).distancia < menorDistancia.distancia){
                menorDistancia = listaEnderecos.get(i);
            }
        }
        return menorDistancia;
    }

    //RECEBE UMA LISTA DE ENDEREÇOS/DISTÂNCIA E RETORNA A COMBINAÇÃO COM A MAIOR DISTÂNCIA ENTRE ELES.
    public EnderecoDistancia getMaiorDistancia(List<EnderecoDistancia> listaEnderecos){

        EnderecoDistancia maiorDistancia = new EnderecoDistancia()
        {
            {distancia = 0.0;}
        };

        for (int i = 0; i < listaEnderecos.size(); i++){
            if(listaEnderecos.get(i).distancia > maiorDistancia.distancia){
                maiorDistancia = listaEnderecos.get(i);
            }
        }
        return maiorDistancia;
    }


}
