package com.example.blogging.blogging.트랜잭션추상화;

import com.example.blogging.blogging.스프링.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void saveAndIncreasePosting(Post post, User user) throws SQLException {
        // 게시글 저장
        String savePostSql = "INSERT INTO posts (title, content) VALUES (?, ?)";
        jdbcTemplate.update(savePostSql, post.getTitle(), post.getContent());

        // 포스팅 수 증가
        String postingCountSql = "UPDATE users SET posting_count = posting_count + 1";
        jdbcTemplate.update(postingCountSql);
    }
}
