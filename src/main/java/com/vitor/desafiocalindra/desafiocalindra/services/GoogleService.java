package com.vitor.desafiocalindra.desafiocalindra.services;


import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GoogleService {

    static GeoApiContext context = new GeoApiContext.Builder()
            .apiKey("AIzaSyBt6G2T2Dgb-0gAVu8d-DNBjyhLkaE6Ez4")
            .build();


    //RECEBE UMA STRING DO ENDEREÇO E RETORNA AS SUAS COORDENADAS.
    public LatLng getCoordenadasFromEndereco(String endereco){

        LatLng coordenadas = new LatLng();

        try {
            GeocodingResult[] results =  GeocodingApi.geocode(context, endereco).await();

            //Caso encontre as coordenadas do respectivo endereço
            if(results.length != 0){
                coordenadas = results[0].geometry.location;
                return coordenadas;
            }
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Caso não tenha encontrado as coordenadas do endereço recebido.
        return new LatLng(){{lat = 00; lng = 00;}};
    }

}
