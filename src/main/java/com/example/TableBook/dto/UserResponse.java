package com.example.TableBook.dto;

import com.example.TableBook.entity.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserResponse {
    Long id;
    String username;
    String email;
    Role role;
}
