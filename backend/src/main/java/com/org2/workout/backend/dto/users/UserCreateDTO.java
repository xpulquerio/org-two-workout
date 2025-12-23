package com.org2.workout.backend.dto.users;

import lombok.ToString;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDTO {

    private String firstName;
    private String lastName;
    private String username;
    private String email;

    @ToString.Exclude
    private String password;
}
