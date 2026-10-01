package com.example.TableBook.service;

import com.example.TableBook.dto.RegisterRequest;
import com.example.TableBook.dto.UserResponse;

public interface AuthService {
    UserResponse register(RegisterRequest request);
}
