package shop.mtcoding.blog.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class UserJPARepositoryTest {

    @Autowired
    private UserJPARepository userJPARepository;

    @Test
    public void findByUsernameAndPassword_test() {
        // given
        String username = "username";
        String password = "1234";

        // when
        userJPARepository.findByUsernameAndPassword(username, password);

        // then
    }

    @Test
    public void save_test() {
        // given
        User user = User.builder()
                .username("username")
                .password("1234")
                .email("email@test.com")
                .build();

        // when
        userJPARepository.save(user);

        // then
    }

    @Test
    public void findById_test() {
        // given
        int id = 1;

        // when
        Optional<User> userOptional = userJPARepository.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            System.out.println("findById_test : " + user.getUsername());
        }

        // then
    }
}
