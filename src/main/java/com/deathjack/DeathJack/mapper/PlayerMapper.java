package com.deathjack.DeathJack.mapper;

import com.deathjack.DeathJack.controller.entity.CreatePlayer;
import com.deathjack.DeathJack.controller.entity.PlayerDetailWeb;
import com.deathjack.DeathJack.controller.entity.PlayerListWeb;
import com.deathjack.DeathJack.controller.entity.UpdatePlayer;
import com.deathjack.DeathJack.domain.entity.Player;
import com.deathjack.DeathJack.persistance.entity.PlayerEntity;

import java.sql.ResultSet;

public class PlayerMapper {
    public static PlayerEntity toPlayerEntity (ResultSet resultSet) {
        try {
            PlayerEntity playerEntity = new PlayerEntity();

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
            Player player = new Player();

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

    public static Player toPlayer (CreatePlayer createPlayer) {
        try {
            Player player = new Player();

            player.setId(0);
            player.setId_score(0);
            player.setName(createPlayer.getName());
            player.setPassword(createPlayer.getPassword());
            player.setBot(false);
            return player;
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }

    }

    public static Player toPlayer (int id, UpdatePlayer updatePlayer) {
        try {
            Player player = new Player();

            player.setId(id);
            player.setId_score(0);
            player.setName(updatePlayer.getName());
            player.setPassword(updatePlayer.getPassword());
            player.setBot(false);
            return player;
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }

    }

    public static PlayerDetailWeb toPlayerDetailWeb (Player player) {
        try {
            PlayerDetailWeb playerDetailWeb = new PlayerDetailWeb();

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

    public static PlayerListWeb toPlayerListWeb (Player player) {
        try {
            PlayerListWeb playerListWeb = new PlayerListWeb();

            playerListWeb.setId(player.getId());
            playerListWeb.setName(player.getName());
            return playerListWeb;
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }
}
