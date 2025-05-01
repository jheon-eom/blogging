package com.example.blogging.blogging.스프링;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public interface StatementStrategy {

    PreparedStatement makePreparedStatement(Connection c);
}
