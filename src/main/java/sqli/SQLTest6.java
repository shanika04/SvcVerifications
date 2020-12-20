package sqli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class SQLTest6 {

  public void sqlTest6(String ip) {
    try {
      PreparedStatement wssPreparedStatement =
          getJDBCConnection()
              .prepareStatement(
                  "INSERT INTO banned_ip(id, ip) VALUE('"
                      + UUID.randomUUID().toString()
                      + "','"
                      + "?"
                      + "')");
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
