package sqli;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.UUID;

public class SQLTest18 {

  public void sqlTest18(String ip) {
    try {
      String sql =
          "INSERT INTO banned_ip(id, ip) VALUE('"
              + UUID.randomUUID().toString()
              + "','"
              + "?"
              + "')";
      PreparedStatement wssPreparedStatement = getJDBCConnection().prepareStatement(sql);
      // Setting the query parameters
      wssPreparedStatement.setString(1, ip);
      wssPreparedStatement.execute();
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    System.out.print("sdfdsf");
  }

  Connection getJDBCConnection() {
    return null;
  }
}
