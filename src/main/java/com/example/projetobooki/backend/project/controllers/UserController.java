package com.example.projetobooki.backend.project.controllers;

import com.example.projetobooki.backend.project.domain.User;
import com.example.projetobooki.backend.project.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get-user-details")
    public ResponseEntity<User> execute(@RequestParam String idUsuario) throws
                                                                        ExecutionException,
                                                                        InterruptedException {

        return ResponseEntity.ok().body(userService.getUserDetails(idUsuario));
    }
}