package wrpullins.roys.rants.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import wrpullins.roys.rants.dbo.User;
public interface UserRepository extends JpaRepository<User, Long> {
	
}