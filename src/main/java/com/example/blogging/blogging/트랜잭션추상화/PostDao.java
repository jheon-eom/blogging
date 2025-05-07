package com.example.blogging.blogging.트랜잭션추상화;

import com.example.blogging.blogging.스프링.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostDao {

    private JdbcTemplate jdbcTemplate;

    public void save(Post post) {
        String sql = "INSERT INTO posts (title, content) VALUES (?, ?)";
        jdbcTemplate.update(sql, post.getTitle(), post.getContent());
    }

    public void saveAndIncreasePosting(Post post, User user) throws SQLException {
//        Connection c = dataSource.getConnection(); // DataSource로부터 커넥션을 획득
//        c.setAutoCommit(false); // 자동 커밋 모드를 끔으로써 트랜잭션 시작
//        try {
//            // 게시글 저장
//            PreparedStatement pstmt = c.prepareStatement("INSERT INTO posts (title, content) VALUES (?, ?)");
//            pstmt.setString(1, post.getTitle());
//            pstmt.setString(2, post.getContent());
//            pstmt.executeUpdate();
//            // 게시글 작성자 ID를 설정
//            c.prepareStatement("UPDATE users SET posting_count = posting_count + 1");
//            pstmt.executeUpdate();
//        } catch (Exception e) {
//            c.rollback(); // 예외 발생 시 롤백
//            throw e; // 예외를 다시 던져서 호출자에게 알림
//        } finally {
//            c.setAutoCommit(true); // 자동 커밋 모드를 원래대로 돌림
//            c.close(); // 커넥션 닫기
//        }
    }
}
