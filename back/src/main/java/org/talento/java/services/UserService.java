package org.talento.java.services;

import org.springframework.stereotype.Service;
import org.talento.java.dtos.user.UserReq;
import org.talento.java.dtos.user.UserRes;
import org.talento.java.exceptions.NonExistentUserException;
import org.talento.java.mappers.UserMapper;
import org.talento.java.models.User;
import org.talento.java.repositories.UserRepo;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final UserMapper mapper;

    public UserService(UserRepo userRepo, UserMapper mapper) {
        this.userRepo = userRepo;
        this.mapper = mapper;
    }

    public UserRes findUser(UserReq userDto) {
        String username = userDto.username();
        String password = userDto.password();
        User user = this.userRepo.findByUsernameAndPassword(username, password)
            .orElseThrow(NonExistentUserException::new);

        return this.mapper.toDto(user);
    }
}
