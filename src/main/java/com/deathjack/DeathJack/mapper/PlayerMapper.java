package com.deathjack.DeathJack.mapper;

import com.deathjack.DeathJack.controller.entity.PlayerDetailWeb;
import com.deathjack.DeathJack.domain.entity.Player;
import com.deathjack.DeathJack.persistance.entity.PlayerEntity;

import java.sql.ResultSet;

public class PlayerMapper {
    public static PlayerEntity toPlayerEntity (ResultSet resultSet) {
        try {
            PlayerEntity playerEntity = new PlayerEntity(0, 0, "", "", true);

            playerEntity.setId(resultSet.getInt("id"));
            playerEntity.setId_score(resultSet.getInt("id_score"));
            playerEntity.setName(resultSet.getString("name"));
            playerEntity.setPassword(resultSet.getString("password"));
            playerEntity.setBot(resultSet.getBoolean("bot"));
            return playerEntity;
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }

    }

    public static Player toPlayer (PlayerEntity playerEntity) {
        try {
            Player player = new Player(0, 0, "", "", true);

            player.setId(playerEntity.getId());
            player.setId_score(playerEntity.getId_score());
            player.setName(playerEntity.getName());
            player.setPassword(playerEntity.getPassword());
            player.setBot(playerEntity.isBot());
            return player;
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }

    }

    public static PlayerDetailWeb toPlayerDetailWeb (Player player) {
        try {
            PlayerDetailWeb playerDetailWeb = new PlayerDetailWeb(0, 0, "", "", true);

            playerDetailWeb.setId(player.getId());
            playerDetailWeb.setId_score(player.getId_score());
            playerDetailWeb.setName(player.getName());
            playerDetailWeb.setPassword(player.getPassword());
            playerDetailWeb.setBot(player.isBot());
            return playerDetailWeb;
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }

    }
}
