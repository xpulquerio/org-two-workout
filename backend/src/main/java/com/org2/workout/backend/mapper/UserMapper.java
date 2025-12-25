package com.org2.workout.backend.mapper;

import com.org2.workout.backend.dto.users.UserCreateDTO;
import com.org2.workout.backend.dto.users.UserUpdateDTO;
import com.org2.workout.backend.dto.users.UserDTO;
import com.org2.workout.backend.model.User;

public class UserMapper {

    private UserMapper() {
        // Construtor vazio
    }

    public static UserDTO toDTO(User user) {

        if (user == null)
            return null;

        UserDTO dto = new UserDTO();

        dto.setId(user.getId());
        dto.setFullName(user.getFirstName() + " " + user.getLastName());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());

        return dto;
    }

    public static User toEntity(UserCreateDTO dto) {
        if (dto == null)
            return null;

        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }

    public static void updateEntity(User user, UserUpdateDTO dto) {
        if (dto == null || user == null)
            return;

        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
    }
}
