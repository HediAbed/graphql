package com.league.of.legends.lol.service;

import com.league.of.legends.lol.entity.GameChampion;
import com.league.of.legends.lol.entity.Player;
import com.league.of.legends.lol.repository.PlayerRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @GraphQLQuery(name = "players")
    public List<Player> getAll(){
        return playerRepository.findAll();
    }

    @GraphQLQuery(name = "player")
    public Player getById(@GraphQLArgument(name = "id") String id){
        return playerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @GraphQLMutation(name = "savePlayer")
    public Player save(@GraphQLArgument(name = "player") Player player){
        player.setId(UUID.randomUUID().toString());
        return playerRepository.save(player);
    }

    @GraphQLMutation(name = "deletePlayer")
    public void delete(@GraphQLArgument(name = "id") String id){
        playerRepository.deleteById(id);
    }
}
