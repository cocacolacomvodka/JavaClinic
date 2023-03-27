import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class pacienttable extends JFrame {
    private JTable table;
    private JPanel panel1;

    public pacienttable(String titulo) {
        super(titulo);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();

        try (Connection conn = MariaDBConnection.getConnection()) {
            String sql = "SELECT * FROM paciente";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            String[] columnNames = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnNames[i-1] = metaData.getColumnName(i);
            }

            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
            table = new JTable(tableModel);

            // Popula a tabela com os dados de pacientes
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i-1] = resultSet.getObject(i);
                }
                tableModel.addRow(rowData);
            }
            // Fecha a consulta e a conexão
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Erro ao consultar o banco de dados");
            e.printStackTrace();
        }
        add(table);

    }
    public static void main(String[] args) {
        JFrame frame = new pacienttable("Pacientes");
        frame.setVisible(true);
    }
}