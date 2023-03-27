import java.sql.Connection;
import java.sql.PreparedStatement;

public class MariaDBInsert {

    public static void insertData(String name, String nasc, String rg, char sexo, String fone, String estCivil, String endereco, String cidade, String estado) {
        Connection conn = MariaDBConnection.getConnection();
        String sql = "INSERT INTO paciente(nome, dt_nasc, rg, sexo, fone, est_civil, endereco, cidade, estado) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, nasc);
            pstmt.setString(3, rg);
            pstmt.setString(4, String.valueOf(sexo));
            pstmt.setString(5, fone);
            pstmt.setString(6, estCivil);
            pstmt.setString(7, endereco);
            pstmt.setString(8, cidade);
            pstmt.setString(9, estado);

            pstmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
