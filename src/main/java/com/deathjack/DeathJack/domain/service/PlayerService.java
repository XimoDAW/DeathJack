package com.deathjack.DeathJack.domain.service;

import com.deathjack.DeathJack.domain.entity.Player;

import java.sql.Connection;
import java.util.Optional;

public interface PlayerService {
    public Optional <Player> getPlayerById(int id);
}