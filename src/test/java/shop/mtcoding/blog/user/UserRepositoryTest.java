package shop.mtcoding.blog.user;

import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpSession;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@Import(UserRepository.class) // IoC 등록코드
@DataJpaTest // Datasource(connection pool), EntityManager
public class UserRepositoryTest {

    @Autowired // DI
    private UserRepository userRepository;

    @Autowired
    private EntityManager em;

    @Test
    public void updateById_test() {
        // given
        int id = 1;
        String password = "9999";
        String email = "ssar@gmail.com";

        // when
        userRepository.updateById(id, password, email);
        em.flush();

        // then
    }

    @Test
    public void findById_test() {
        // given
        int id = 1;

        // when
        userRepository.findById(id);

        // then
    }

    @Test
    public void findByUsername_test() {
        // given
        String username = "ssar";
        String password = "1234";

        // when
        User user = userRepository.findByUsernameAndPassword(username, password);

        // then
        Assertions.assertThat(user.getUsername()).isEqualTo("ssar");
    }
}
