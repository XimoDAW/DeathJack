package com.deathjack.DeathJack.controller;

import com.deathjack.DeathJack.controller.entity.PlayerDetailWeb;
import com.deathjack.DeathJack.domain.entity.Player;
import com.deathjack.DeathJack.domain.service.PlayerService;
import com.deathjack.DeathJack.domain.service.impl.PlayerServiceImpl;
import com.deathjack.DeathJack.http_response.Response;
import com.deathjack.DeathJack.mapper.PlayerMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PlayerController {
    PlayerService playerService = new PlayerServiceImpl();
    @GetMapping("/deathjack/{id}")
    public Response getPlayerById(@PathVariable("id") int id) {
        Player player = playerService.getPlayerById(1).get();
        PlayerDetailWeb playerDetailWeb = PlayerMapper.toPlayerDetailWeb(player);
        return new Response(playerDetailWeb);
    }
}