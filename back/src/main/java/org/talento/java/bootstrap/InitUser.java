package org.talento.java.bootstrap;

import org.springframework.stereotype.Component;
import org.talento.java.models.User;
import org.talento.java.repositories.UserRepo;

import java.util.ArrayList;
import java.util.List;

@Component(value = "InitUser.beanName")
public class InitUser extends BootstrapBase{
    private final UserRepo usersRepo;

    public InitUser(UserRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    @Override
    public String entityMessage() {
        return "users";
    }

    @Override
    public void load() {
        List<User> users = new ArrayList<>();
        User tempUser;

        // #############################################################################################################
        tempUser = new User();
        tempUser.setUsername("Bonifacio");
        tempUser.setPassword("123");
        tempUser.setRole("admin");
        users.add(tempUser);

        // #############################################################################################################
        tempUser = new User();
        tempUser.setUsername("Clemente");
        tempUser.setPassword("123");
        tempUser.setRole("user");
        users.add(tempUser);

        // #############################################################################################################
        tempUser = new User();
        tempUser.setUsername("Dalmacio");
        tempUser.setPassword("123");
        tempUser.setRole("user");
        users.add(tempUser);

        // #############################################################################################################
        tempUser = new User();
        tempUser.setUsername("Emeterio");
        tempUser.setPassword("123");
        tempUser.setRole("user");
        users.add(tempUser);

        // #############################################################################################################
        tempUser = new User();
        tempUser.setUsername("Taciana");
        tempUser.setPassword("123");
        tempUser.setRole("user");
        users.add(tempUser);

        // #############################################################################################################
        tempUser = new User();
        tempUser.setUsername("Ursula");
        tempUser.setPassword("123");
        tempUser.setRole("user");
        users.add(tempUser);

        // #############################################################################################################
        tempUser = new User();
        tempUser.setUsername("Valentina");
        tempUser.setPassword("123");
        tempUser.setRole("user");
        users.add(tempUser);

        // #############################################################################################################
        tempUser = new User();
        tempUser.setUsername("Zeferina");
        tempUser.setPassword("123");
        tempUser.setRole("user");
        users.add(tempUser);

        // #############################################################################################################
        this.usersRepo.saveAll(users);
    }
}
