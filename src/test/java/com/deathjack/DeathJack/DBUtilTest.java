package com.deathjack.DeathJack;

import com.deathjack.DeathJack.ddbb.DBUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DBUtilTest {

    Connection connection = DBUtil.open(true);
    @Test
    public void getConnection () {
        assertEquals(org.mariadb.jdbc.Connection.class, DBUtil.open(true).getClass(), "Conexion fallida");
    }

    @Test
    public void select () throws SQLException {
        String sql = "Select * from cards where id = ?";
        ResultSet resultSet = DBUtil.select(connection, sql, List.of(1));
        resultSet.next();
        assertAll(
                () -> assertEquals(1, resultSet.getInt("id"), "Id incorrecto"),
                () -> assertEquals("sA", resultSet.getString("card"), "El nombre de la carta es incorrecto")
        );
        connection.close();
    }

    @Test
    public void insert () throws SQLException {
        String sql = "INSERT INTO player (name, password, bot) VALUES (?, ?, ?)";
        int result = DBUtil.insert(connection, sql, List.of("Juan", "Juan", false));
        String sql2 = "SELECT id FROM player ORDER BY id DESC LIMIT 1";
        ResultSet resultSet = DBUtil.select(connection, sql2, null);
        resultSet.next();
        int id = resultSet.getInt("id");
        String sql3 = "UPDATE player SET id_score = " + id + " WHERE id = ?";
        int result2 = DBUtil.update(connection, sql3, List.of(id));
    }
}
