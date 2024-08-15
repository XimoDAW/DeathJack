package com.deathjack.DeathJack.domain.service.impl;

import com.deathjack.DeathJack.domain.entity.Player;
import com.deathjack.DeathJack.domain.repository.PlayerRepository;
import com.deathjack.DeathJack.domain.service.PlayerService;
import com.deathjack.DeathJack.persistance.repositoryImpl.PlayerRepositoryImpl;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {
    PlayerRepository playerRepository = new PlayerRepositoryImpl();

    @Override
    public Optional<Player> getPlayerById(int id) {
        return Optional.of(playerRepository.getPlayerById(id).get());
    }
}
