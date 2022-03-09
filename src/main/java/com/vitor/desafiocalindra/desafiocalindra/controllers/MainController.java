package com.vitor.desafiocalindra.desafiocalindra.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.maps.model.LatLng;
import com.vitor.desafiocalindra.desafiocalindra.models.Endereco;
import com.vitor.desafiocalindra.desafiocalindra.models.EnderecoDistancia;
import com.vitor.desafiocalindra.desafiocalindra.models.InputEnderecosModel;
import com.vitor.desafiocalindra.desafiocalindra.models.OutputRelatorioFinal;
import com.vitor.desafiocalindra.desafiocalindra.services.DistanciaUtilsService;
import com.vitor.desafiocalindra.desafiocalindra.services.GoogleService;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    GoogleService googleService;
    @Autowired
    DistanciaUtilsService distanciaUtils;

    @GetMapping("/saudacoes")
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("Olá, Calindra !");
    }

    @RequestMapping(value = "/get-distancia", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> setEnderecosAndGetDistancias(@RequestBody InputEnderecosModel enderecos){

        if (enderecos.getEnderecos().size() < 2) {
            return ResponseEntity.badRequest()
                    .body("É NECESSÁRIO ENVIAR NO MÍNIMO 2 ENDEREÇOS !");
        }

        List<Endereco> listaEnderecos = new ArrayList<>();

        for (String linhaEndereco: enderecos.getEnderecos()) {
            LatLng coordenadasEndereco = googleService.getCoordenadasFromEndereco(linhaEndereco);
            Endereco endereco = new Endereco(){{
                enderecoInput = linhaEndereco;
                latitude = coordenadasEndereco.lat;
                longitude = coordenadasEndereco.lng;
            }};
            listaEnderecos.add(endereco);
        }

        List<EnderecoDistancia> listaEnderecoDistancia = new ArrayList<>();

        for (int i = 0; i < listaEnderecos.size(); i++) {
            for (int j = i + 1; j < listaEnderecos.size(); j++) {

                Endereco end1 = listaEnderecos.get(i);
                Endereco end2 = listaEnderecos.get(j);

                EnderecoDistancia enderecoDistancia = new EnderecoDistancia(){{
                    endereco1 = end1;
                    endereco2 = end2;
                    distancia = distanciaUtils.calcularDistanciaEntre2Pontos
                            (end1.latitude, end1.longitude, end2.latitude, end2.longitude);
                }};

                listaEnderecoDistancia.add(enderecoDistancia);
            }
        }

        OutputRelatorioFinal relatorioFinal = new OutputRelatorioFinal(){{
            setListaEnderecosRecebidos(listaEnderecos);
            setListaEnderecosDistancia(listaEnderecoDistancia);
            setMaiorDistancia(distanciaUtils.getMaiorDistancia(listaEnderecoDistancia));
            setMenorDistancia(distanciaUtils.getMenorDistancia(listaEnderecoDistancia));
        }};

        String relatorioFinalJSON = "";

        ObjectMapper mapper = new ObjectMapper();
        try {
            relatorioFinalJSON = mapper.writeValueAsString(relatorioFinal);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(relatorioFinalJSON);
    }


}
