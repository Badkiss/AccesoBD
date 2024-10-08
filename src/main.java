import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class main {
    public static void main(String[] args) throws SQLException, IOException {
       MiConector miConector = new MiConector();
       Connection con = miConector.getConnection();

        String sql ="SELECT idEmpleado , nombre , apellidos , email , fechaNac , cargo from EMPLEADO";
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        File file = new File("empleados.txt");
        FileWriter fileWriter= new FileWriter(file);
        try(BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
            while (resultSet.next()) {
                bufferedWriter.write(resultSet.getInt("idEmpleado")+" "+resultSet.getString("nombre")+" "+resultSet.getString("apellidos")+" "+resultSet.getString("email")+" "+resultSet.getString("fechaNac")+" "+resultSet.getString("cargo")+"\n");
            }
        }



    }
}
