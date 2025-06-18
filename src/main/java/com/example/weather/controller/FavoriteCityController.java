package com.example.weather.controller;


import com.example.weather.model.FavoriteCity;
import com.example.weather.service.FavoriteCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favoritos")
public class FavoriteCityController {

    @Autowired
    private FavoriteCityService service;

    @PostMapping("/{cidade}")
    public ResponseEntity<Void> adicionar(@PathVariable String cidade,
                                          @RequestHeader("usuarioId") Long usuarioId) {
        service.adicionarFavorito(cidade, usuarioId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<FavoriteCity>> listar(@RequestHeader("usuarioId") Long usuarioId) {
        return ResponseEntity.ok(service.listarFavoritos(usuarioId));
    }

    @DeleteMapping("/{cidade}")
    public ResponseEntity<Void> remover(@PathVariable String cidade,
                                        @RequestHeader("usuarioId") Long usuarioId) {
        service.removerFavorito(cidade, usuarioId);
        return ResponseEntity.ok().build();
    }
}
