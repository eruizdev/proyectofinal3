package com.example.backend;

import com.example.backend.model.Usuario;
import com.example.backend.repository.AuthRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordMigrator implements CommandLineRunner {

    private final AuthRepository repo;
    private final PasswordEncoder encoder;

    public PasswordMigrator(AuthRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) {
        for (Usuario u : repo.findAll()) {
            String pass = u.getPassword();
            if (!pass.startsWith("$2a$")) {  // si no es hash BCrypt
                u.setPassword(encoder.encode(pass));
                repo.save(u);
            }
        }
    }
}
