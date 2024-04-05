package shop.mtcoding.blog.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJPARepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    Optional<User> findByUsername(@Param("username") String username);
}
