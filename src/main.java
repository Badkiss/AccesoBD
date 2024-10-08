import java.sql.*;

public class main {
    public static void main(String[] args) throws SQLException {
       MiConector miConector = new MiConector();
       Connection con = miConector.getConnection();

        String sql ="SELECT idEmpleado , nombre , apellidos , email , fechaNac , cargo from EMPLEADO";
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println(resultSet.getInt("idEmpleado")+" "+resultSet.getString("nombre")+" "+resultSet.getString("apellidos")+" "+resultSet.getString("email")+" "+resultSet.getString("fechaNac")+" "+resultSet.getString("cargo"));
        }

    }
}
