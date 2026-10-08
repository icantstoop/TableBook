package com.example.TableBook.service;

import com.example.TableBook.dto.RegisterRequest;
import com.example.TableBook.dto.UserResponse;
import com.example.TableBook.entity.Role;
import com.example.TableBook.entity.User;
import com.example.TableBook.exception.UserAlreadyExistsException;
import com.example.TableBook.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Override
    public UserResponse register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new UserAlreadyExistsException("Username already: " + request.getUsername());
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException("Email already: " + request.getEmail());
        }

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword()) // пароль шифровать не буду, т.к. проект для себя
                .role(Role.CLIENT)
                .build();

        User savedUser = userRepository.save(user);
        return mapToResponse(savedUser);

    }

    private UserResponse mapToResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

}
