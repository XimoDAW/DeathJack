package com.deathjack.DeathJack.controller;

import com.deathjack.DeathJack.controller.entity.ObjectDetailWeb;
import com.deathjack.DeathJack.domain.entity.Object;
import com.deathjack.DeathJack.domain.service.ObjectService;
import com.deathjack.DeathJack.domain.service.impl.ObjectServiceImpl;
import com.deathjack.DeathJack.http_response.Response;
import com.deathjack.DeathJack.mapper.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ObjectController {
    ObjectService objectService = new ObjectServiceImpl();

    @GetMapping("/deathjack/objects")
    public Response getAllObjects () {
        List<Object> objectList = objectService.getAllObjects();
        List<ObjectDetailWeb> objectDetailWebList = new ArrayList<>();

        objectList.stream().map(object -> {
            return objectDetailWebList.add(ObjectMapper.toObjectDetailWeb(object));
        }).toList();
        return new Response(objectDetailWebList);
    }
}
