package com.deathjack.DeathJack.persistance.repositoryImpl;

import com.deathjack.DeathJack.ddbb.DBUtil;
import com.deathjack.DeathJack.domain.entity.Object;
import com.deathjack.DeathJack.domain.repository.ObjectRepository;
import com.deathjack.DeathJack.mapper.ObjectMapper;
import com.deathjack.DeathJack.persistance.dao.ObjectDAO;
import com.deathjack.DeathJack.persistance.entity.ObjectEntity;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ObjectRepositoryImpl implements ObjectRepository {
    ObjectDAO objectDAO = new ObjectDAO();
    @Override
    public List<Object> getAllObjects() {
        try (Connection connection = DBUtil.open(true)){
            List<ObjectEntity> objectEntityList = objectDAO.getAllObjects(connection);
            List<Object> objectList = new ArrayList<>();

            objectEntityList.stream().map(
                    objectEntity -> {
                        return objectList.add(ObjectMapper.toObject(objectEntity));
                    }
            ).toList();

            return objectList;
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }
}
