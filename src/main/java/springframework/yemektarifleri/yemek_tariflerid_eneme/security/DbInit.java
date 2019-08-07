package springframework.yemektarifleri.yemek_tariflerid_eneme.security;


import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DbInit implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        userRepository.deleteAll();

        User cryptolog = new User();
        cryptolog.setUserName("cryptolog");
        cryptolog.setPassword(passwordEncoder.encode("admin123"));
        cryptolog.setRoles("ADMIN");
        cryptolog.setActive(1);

        userRepository.save(cryptolog);
    }
}
