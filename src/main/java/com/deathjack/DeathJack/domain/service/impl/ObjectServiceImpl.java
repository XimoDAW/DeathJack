package com.deathjack.DeathJack.domain.service.impl;

import com.deathjack.DeathJack.domain.entity.Object;
import com.deathjack.DeathJack.domain.repository.ObjectRepository;
import com.deathjack.DeathJack.domain.service.ObjectService;
import com.deathjack.DeathJack.persistance.repositoryImpl.ObjectRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectServiceImpl implements ObjectService {
    ObjectRepository objectRepository = new ObjectRepositoryImpl();
    @Override
    public List<Object> getAllObjects() {
        return objectRepository.getAllObjects();
    }
}
