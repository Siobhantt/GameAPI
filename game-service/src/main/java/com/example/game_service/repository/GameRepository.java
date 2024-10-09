package com.example.game_service.repository;

import com.example.game_service.commons.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

//La clase y el tipo del id
public interface GameRepository extends JpaRepository<Game,Long> {

}
