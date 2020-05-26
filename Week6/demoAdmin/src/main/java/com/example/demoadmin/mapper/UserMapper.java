package com.example.demoadmin.mapper;

import com.example.demoadmin.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setUser_id(resultSet.getString("user_id"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }
}
