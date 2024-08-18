package com.deathjack.DeathJack.domain.service;

import com.deathjack.DeathJack.domain.entity.Player;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public interface PlayerService {
    public Optional <Player> getPlayerById(int id);
    public List<Player> getAllPlayers();
    public int createPlayer(String name, String password);
    public int updatePlayer(int id, String name, String password);
}
