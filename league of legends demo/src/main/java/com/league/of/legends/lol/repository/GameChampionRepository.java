package com.league.of.legends.lol.repository;

import com.league.of.legends.lol.entity.GameChampion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameChampionRepository  extends JpaRepository<GameChampion,String> {
}
