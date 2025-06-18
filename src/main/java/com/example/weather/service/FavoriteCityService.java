package com.example.weather.service;

import com.example.weather.model.FavoriteCity;
import com.example.weather.repository.FavoriteCityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class FavoriteCityService {

    @Autowired
    private FavoriteCityRepository repository;

    public void adicionarFavorito(String nome, Long usuarioId) {

        if(repository.findByNameAndUsuarioId(nome, usuarioId).isEmpty()) {

            FavoriteCity favoriteCity = new FavoriteCity();
            favoriteCity.setName(nome);
            favoriteCity.setUsuarioId(usuarioId);

            repository.save(favoriteCity);

        }
    }

    public List<FavoriteCity> listarFavoritos(Long usuarioId) {

        return repository.findByUsuarioId(usuarioId);

    }

    public void removerFavorito(String nome, Long usuarioId) {

        repository.findByNameAndUsuarioId(nome, usuarioId).ifPresent(repository::delete);

    }
}
