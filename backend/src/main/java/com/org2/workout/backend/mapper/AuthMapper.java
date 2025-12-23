package com.org2.workout.backend.mapper;

import com.org2.workout.backend.dto.auth.AuthResponseDTO;
import com.org2.workout.backend.model.User;

public class AuthMapper {

    private AuthMapper() {
        // Construtor vazio
    }

    public static AuthResponseDTO toAuthResponse(User user, String token) {
        if (user == null || token == null)
            return null;

        AuthResponseDTO dto = new AuthResponseDTO();

        dto.setUserId(user.getId());
        dto.setToken(token);

        return dto;
    }
}
