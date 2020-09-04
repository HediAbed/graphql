package com.league.of.legends.lol.config;

import com.github.javafaker.Faker;
import com.league.of.legends.lol.entity.GameChampion;
import com.league.of.legends.lol.entity.Player;
import com.league.of.legends.lol.service.ChampionService;
import com.league.of.legends.lol.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InitData implements ApplicationRunner {
    @Autowired
    private ChampionService championService;

    @Autowired
    private PlayerService playerService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Faker faker = new Faker();

        for (int i=0; i<10;i++){
            GameChampion champion = new GameChampion();
            champion.setId(UUID.randomUUID().toString());
            champion.setName(faker.leagueOfLegends().champion());
            championService.save(champion);
        }

        for (int i=0; i<10;i++){
            Player player = new Player();
            player.setId(UUID.randomUUID().toString());
            player.setUsername(faker.name().username());
            player.setAge(19+i);
            playerService.save(player);
        }
    }
}