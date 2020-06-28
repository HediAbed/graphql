package com.league.of.legends.lol.service;

import com.league.of.legends.lol.entity.GameChampion;
import com.league.of.legends.lol.repository.GameChampionRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class ChampionService {
    @Autowired
    private GameChampionRepository gameChampionRepository;

    @GraphQLQuery(name = "champions")
    public List<GameChampion> getAll(){
        return gameChampionRepository.findAll();
    }

    @GraphQLQuery(name = "champion")
    public GameChampion getById(@GraphQLArgument(name = "id") String id){
        return gameChampionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @GraphQLMutation(name = "saveChampion")
    public GameChampion save(@GraphQLArgument(name = "champion") GameChampion champion){
        champion.setId(UUID.randomUUID().toString());
        return gameChampionRepository.save(champion);
    }

    @GraphQLMutation(name = "deleteChampion")
    public void delete(@GraphQLArgument(name = "id") String id){
        gameChampionRepository.deleteById(id);
    }

}
