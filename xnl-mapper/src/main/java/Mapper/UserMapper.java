package Mapper;

import entity.User;

import java.util.List;

public interface UserMapper {
    void addUser(User user);
    List<User> findAll();
}
