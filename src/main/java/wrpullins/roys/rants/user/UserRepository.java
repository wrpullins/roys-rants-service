package wrpullins.roys.rants.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDbo, Long> {
    Optional<UserDbo> findDistinctByUsernameAndPassword(final String name, final String password);

}