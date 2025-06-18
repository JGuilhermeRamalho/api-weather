package com.example.weather.repository;

import com.example.weather.model.FavoriteCity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteCityRepository extends JpaRepository<FavoriteCity, Long> {
    List<FavoriteCity> findByUsuarioId(Long usuarioId);
    Optional<FavoriteCity> findByNameAndUsuarioId(String name, Long usuarioId);
}