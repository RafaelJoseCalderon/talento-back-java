package org.talento.java.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.talento.java.dtos.user.UserReq;
import org.talento.java.dtos.user.UserRes;
import org.talento.java.services.UserService;

@RestController @RequestMapping("api/users")
class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/login")
    public ResponseEntity<UserRes> login(
        @RequestBody UserReq user
    ) {
        var response = this.userService.findUser(user);
        return ResponseEntity.ok(response);
    }
}