package com.deathjack.DeathJack.domain.service.impl;

import com.deathjack.DeathJack.domain.entity.Player;
import com.deathjack.DeathJack.domain.repository.PlayerRepository;
import com.deathjack.DeathJack.domain.service.PlayerService;
import com.deathjack.DeathJack.persistance.repositoryImpl.PlayerRepositoryImpl;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {
    PlayerRepository playerRepository = new PlayerRepositoryImpl();

    @Override
    public Optional<Player> getPlayerById(int id) {
        return Optional.of(playerRepository.getPlayerById(id).get());
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.getAllPlayers();
    }

    @Override
    public int createPlayer(String name, String password) {
        return playerRepository.createPlayer(name, password);
    }

    @Override
    public int updatePlayer(int id, String name, String password) {
        return playerRepository.updatePlayer(id, name, password);
    }
}