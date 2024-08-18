package com.deathjack.DeathJack.domain.repository;

import com.deathjack.DeathJack.domain.entity.Object;

import java.util.List;
import java.util.Optional;

public interface ObjectRepository {
    public List<Object> getAllObjects ();
    public Optional<Object> getObjectById(int id);
}
