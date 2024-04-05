package shop.mtcoding.blog.board;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class BoardJPARepositoryTest {

    @Autowired
    private BoardJPARepository boardJPARepository;

    @Autowired
    private EntityManager em;

    @Test
    public void findById_test() {
        // given
        int id = 1;

        // when
        Optional<Board> boardOptional = boardJPARepository.findById(id);

        if (boardOptional.isPresent()) {
            Board board = boardOptional.get();
            System.out.println("findById_test : " + board.getTitle());
        }

        // then
    }

    @Test
    public void findByIdJoinUser_test() {
        // given
        int id = 1;

        // when
        Optional<Board> boardOptional = boardJPARepository.findByIdJoinUser(id);

        // then
        if (boardOptional.isPresent()) {
            Board board = boardOptional.get();
            System.out.println("findByIdJoinUser_test : " + board.getTitle());
            System.out.println("findByIdJoinUser_test : " + board.getUser().getUsername());
        }
    }
}
