package wrpullins.roys.rants.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> findUserOnLogin(final String username, final String password){
        return userRepository.findDistinctByUsernameAndPassword(username, password);
    }

}
