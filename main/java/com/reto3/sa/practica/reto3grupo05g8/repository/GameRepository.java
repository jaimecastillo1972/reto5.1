/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.sa.practica.reto3grupo05g8.repository;

import com.reto3.sa.practica.reto3grupo05g8.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Grupo 8
 * Repositorio
 */
public interface GameRepository extends JpaRepository<Game, Integer>{
    
}
