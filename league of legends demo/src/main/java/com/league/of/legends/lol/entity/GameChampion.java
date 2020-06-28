package com.league.of.legends.lol.entity;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameChampion {
    @Id
    @GraphQLQuery(name = "id",description = "A League of Legends Champion's id")
    private String id ;
    @GraphQLQuery(name = "name",description = "A League of Legends Champion's name")
    private String name;
}
