package com.vitor.desafiocalindra.desafiocalindra.models;

import java.util.List;

public class OutputRelatorioFinal {

    List<Endereco> listaEnderecosRecebidos;
    List<EnderecoDistancia> listaEnderecosDistancia;
    EnderecoDistancia maiorDistancia;
    EnderecoDistancia menorDistancia;

    public List<Endereco> getListaEnderecosRecebidos() {
        return listaEnderecosRecebidos;
    }

    public void setListaEnderecosRecebidos(List<Endereco> listaEnderecosRecebidos) {
        this.listaEnderecosRecebidos = listaEnderecosRecebidos;
    }

    public List<EnderecoDistancia> getListaEnderecosDistancia() {
        return listaEnderecosDistancia;
    }

    public void setListaEnderecosDistancia(List<EnderecoDistancia> listaEnderecosDistancia) {
        this.listaEnderecosDistancia = listaEnderecosDistancia;
    }

    public EnderecoDistancia getMaiorDistancia() {
        return maiorDistancia;
    }

    public void setMaiorDistancia(EnderecoDistancia maiorDistancia) {
        this.maiorDistancia = maiorDistancia;
    }

    public EnderecoDistancia getMenorDistancia() {
        return menorDistancia;
    }

    public void setMenorDistancia(EnderecoDistancia menorDistancia) {
        this.menorDistancia = menorDistancia;
    }
}
