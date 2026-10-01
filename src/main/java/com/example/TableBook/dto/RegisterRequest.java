package com.example.TableBook.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    @Size(min = 3, max = 20)
    @NotBlank
    String username;
    @Email
    @NotBlank
    String email;
    @Size(min = 5, max = 25)
    @NotBlank
    String password;
}
