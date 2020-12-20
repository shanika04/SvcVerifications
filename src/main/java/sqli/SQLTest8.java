package sqli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class SQLTest8 {

  public void sqlTest8(String ip) {
    String ipUnsafe = null;
    ipUnsafe = ip;
    ip = "?" + ".a";
    try {
      PreparedStatement wssPreparedStatement =
          getJDBCConnection()
              .prepareStatement(
                  "INSERT INTO banned_ip(id, ip) VALUE('"
                      + UUID.randomUUID().toString()
                      + "','"
                      + ip
                      + "')");
      // Setting the query parameters
      wssPreparedStatement.setString(1, ipUnsafe);
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
