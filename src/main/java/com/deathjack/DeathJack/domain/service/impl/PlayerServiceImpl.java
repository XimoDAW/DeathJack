package com.deathjack.DeathJack.domain.service.impl;

import com.deathjack.DeathJack.domain.entity.Player;
import com.deathjack.DeathJack.domain.repository.PlayerRepository;
import com.deathjack.DeathJack.domain.service.PlayerService;
import com.deathjack.DeathJack.http_error.DuplicateObjectException;
import com.deathjack.DeathJack.http_error.PlayerSignUpException;
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
        Optional <Player> player = Optional.of(playerRepository.getPlayerById(id).get());
        return Optional.of(playerRepository.getPlayerById(id).get());
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.getAllPlayers();
    }

    @Override
    public int createPlayer(String name, String password) {
        try {
            boolean isSignUp = false;
            List<Player> players = getAllPlayers();
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).getName().equals(name)) {
                    isSignUp = true;
                    i = players.size();
                }
            }

            if (isSignUp) {
                throw new PlayerSignUpException("El jugador ya esta registrado");
            }

            return playerRepository.createPlayer(name, password);
        }catch (PlayerSignUpException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int updatePlayer(int id, String name, String password) {
        return playerRepository.updatePlayer(id, name, password);
    }

    @Override
    public int deletePlayer(int id) {
        return playerRepository.deletePlayer(id);
    }
}
