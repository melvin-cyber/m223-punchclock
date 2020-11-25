package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.ApplicationUser;
import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.repository.ApplicationUserRepository;
import ch.zli.m223.punchclock.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private ApplicationUserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(ApplicationUserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    // Erstellt einen neuen Benutzer
    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void signUp(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    // Gibt alle Benutzer zurück
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ApplicationUser> getAllUsers() {
        return userRepository.findAll();
    }

    // Gibt einen einzelnen Benutzer anhand seines Benutzernamens zurück
    @GetMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    public ApplicationUser getUser(@PathVariable String username) {
        return userRepository.findByUsername(username);
    }

    // Ändert einen bestehenden Nutzer
    // gibt den geänderten Nutzereintrag zurück
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ApplicationUser updateUser(@Valid @RequestBody ApplicationUser user) {
        return userRepository.saveAndFlush(user);
    }

    // Löscht einen Nutzer anhand seiner id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
