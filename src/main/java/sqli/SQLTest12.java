package sqli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class SQLTest12 {

  public void sqlTest12(String ip) {
    String ipUnsafe = null;
    ipUnsafe = ip;
    ip = "?" + ".a";
    ip = ip + ".b";
    try {
      String sql =
          "INSERT INTO banned_ip(id, ip) VALUE('"
              + UUID.randomUUID().toString()
              + "','"
              + ip
              + "')";
      PreparedStatement statement = getJDBCConnection().prepareStatement(sql);
      // Setting the query parameters
      statement.setString(1, ipUnsafe);
      statement.execute();
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    System.out.print("sdfdsf");
  }

  Connection getJDBCConnection() {
    return null;
  }
}
