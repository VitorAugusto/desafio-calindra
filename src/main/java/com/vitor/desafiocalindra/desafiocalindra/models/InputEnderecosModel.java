package com.vitor.desafiocalindra.desafiocalindra.models;

import java.util.List;

public class InputEnderecosModel {

    private List<String> enderecos;

    public InputEnderecosModel(){

    }

    public InputEnderecosModel(List<String> enderecos){
        this.enderecos = enderecos;
    }

    public List<String> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<String> enderecos) {
        this.enderecos = enderecos;
    }
}
