package com.deathjack.DeathJack.persistance.repositoryImpl;

import com.deathjack.DeathJack.ddbb.DBUtil;
import com.deathjack.DeathJack.domain.entity.Player;
import com.deathjack.DeathJack.domain.repository.PlayerRepository;
import com.deathjack.DeathJack.mapper.PlayerMapper;
import com.deathjack.DeathJack.persistance.dao.PlayerDAO;
import com.deathjack.DeathJack.persistance.entity.PlayerEntity;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PlayerRepositoryImpl implements PlayerRepository {
    PlayerDAO playerDAO = new PlayerDAO();

    @Override
    public Optional<Player> getPlayerById(int id) {
        try (Connection connection = DBUtil.open(true)){
            Player player = PlayerMapper.toPlayer(playerDAO.getPlayerById(connection, id).get());
            return Optional.of(player);
        } catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }

    @Override
    public List<Player> getAllPlayers() {
        try (Connection connection = DBUtil.open(true)){
            List<Player> playerList = new ArrayList<>();
            List<PlayerEntity> playerEntityList = playerDAO.getAllPlayers(connection);

            playerEntityList.stream().map(player -> {
                    return playerList.add(PlayerMapper.toPlayer(player));
                }
            ).toList();

            return playerList;

        }catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }
}
