package pl.fiewicz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.fiewicz.model.User;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

Optional<User> findByLogin(String login);

}
