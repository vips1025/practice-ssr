package shop.mtcoding.blog.board;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@Import(BoardRepository.class)
@DataJpaTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private EntityManager em;

    @Test
    public void updateById_test() {
        // given
        int id = 1;
        String title = "title1";
        String content = "content1";

        // when
        boardRepository.updateById(id, title, content);
        em.flush(); // 실제 코드는 작성할 필요가 없다. 이유는? 트랜잭션 종료될꺼니까!!
        // then
    }

    @Test
    public void deleteById_test() {
        // given
        int id = 1;

        // when
        boardRepository.deleteById(id); // delete query 발동함

        // then
        System.out.println("deleteById_test : " + boardRepository.findAll().size());
    }

    @Test
    public void findAll_lazyloading_test() { // default_batch_fetch_size : 10
        List<Board> boardList = boardRepository.findAll();
        boardList.forEach(board -> {
            System.out.println(board.getUser().getUsername()); // lazy loading
        });
    }

    @Test
    public void findAll_test() {
        List<Board> boardList = boardRepository.findAll();
    }

    @Test
    public void findByIdJoinUser_test() {
        int id = 1;

        boardRepository.findByIdJoinUser(id);
    }

    @Test
    public void findById_test() {
        int id = 1;
        Board board = boardRepository.findById(id);
        System.out.println(board.getUser().getId());
        System.out.println(board.getUser().getUsername());
    }
}
