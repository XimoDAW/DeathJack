package com.deathjack.DeathJack.domain.service;

import com.deathjack.DeathJack.domain.entity.Object;

import java.util.List;
import java.util.Optional;

public interface ObjectService {
    public List<Object> getAllObjects();
    public Optional<Object> getObjectById(int id);
}
