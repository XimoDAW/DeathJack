package com.deathjack.DeathJack.controller;

import com.deathjack.DeathJack.controller.entity.CreatePlayer;
import com.deathjack.DeathJack.controller.entity.PlayerDetailWeb;
import com.deathjack.DeathJack.controller.entity.PlayerListWeb;
import com.deathjack.DeathJack.controller.entity.UpdatePlayer;
import com.deathjack.DeathJack.domain.entity.Player;
import com.deathjack.DeathJack.domain.service.PlayerService;
import com.deathjack.DeathJack.domain.service.impl.PlayerServiceImpl;
import com.deathjack.DeathJack.http_response.Response;
import com.deathjack.DeathJack.mapper.PlayerMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlayerController {
    PlayerService playerService = new PlayerServiceImpl();

    @GetMapping("/deathjack/players")
    public Response getAllPlayers() {
        List<Player> playerList = playerService.getAllPlayers();
        List <PlayerListWeb> playerListWebList = new ArrayList<>();
        playerList.stream().map(player -> {
                    return playerListWebList.add(PlayerMapper.toPlayerListWeb(player));
                }
        ).toList();

        return new Response(playerListWebList);
    }

    @GetMapping("/deathjack/player/{id}")
    public Response getPlayerById(@PathVariable("id") int id) {
        Player player = playerService.getPlayerById(id).get();
        PlayerDetailWeb playerDetailWeb = PlayerMapper.toPlayerDetailWeb(player);
        return new Response(playerDetailWeb);
    }

    @PostMapping("/deathjack/player")
    public int createPlayer(@RequestBody CreatePlayer createPlayer) {
        Player player = PlayerMapper.toPlayer(createPlayer);
        return playerService.createPlayer(player.getName(), player.getPassword());
    }

    @PutMapping("/deathjack/player/{id}")
    public int updatePlayer(@PathVariable("id") int id, @RequestBody UpdatePlayer updatePlayer) {
        Player player = PlayerMapper.toPlayer(id, updatePlayer);
        return playerService.updatePlayer(id, player.getName(), player.getPassword());
    }

    @DeleteMapping("/deathjack/player/{id}")
    public int deletePlayer(@PathVariable("id") int id) {
        return playerService.deletePlayer(id);
    }
}
