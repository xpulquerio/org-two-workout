package com.org2.workout.backend.dto.auth;

import lombok.Data;

@Data
public class AuthResponseDTO {

    private Long userId;
    private String token;

}
