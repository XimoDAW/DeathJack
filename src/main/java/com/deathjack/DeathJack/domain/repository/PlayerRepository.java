package com.deathjack.DeathJack.domain.repository;

import com.deathjack.DeathJack.domain.entity.Player;
import com.deathjack.DeathJack.persistance.entity.PlayerEntity;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public interface PlayerRepository {
    public Optional<Player> getPlayerById(int id);
    public List<Player> getAllPlayers();
}
