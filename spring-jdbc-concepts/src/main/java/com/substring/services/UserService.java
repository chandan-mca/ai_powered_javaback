package com.substring.services;

import com.substring.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // user related business logics

    //user save:
    public void saveUser(User user) {

        //logic that save user:db
        //JdbcTemplate
        //JdbcClient
        String query = "insert into users(name,phone) values(?,?)";
        int update = jdbcTemplate.update(
                query,
                user.getName(),
                user.getPhone()
        );


        System.out.println("number of rows effect " + update);
        System.out.println("user saved success !!");


    }

    public List<User> getUsers() {

        String query = "select * from users";
//        id,name,phone
//        id,name,phone

//        row---> user object===> conversion==> RowMapper
        return jdbcTemplate.query(query, (rs, num) -> {
            return new User(rs.getInt("id"), rs.getString("name"), rs.getString("phone"));
        });
    }


}
