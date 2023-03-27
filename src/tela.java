import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class tela extends JFrame {
    private JPanel mainPanel;
    private JTextField InputNome;
    private JLabel LabelInput;
    private JButton logInButton;
    private JTextField InputRG;
    private JTextField InputFone;
    private JTextField InputEstCivil;
    private JTextField InputEnd;
    private JTextField InputCidade;
    private JTextField InputEstado;
    private JTextField InputNasc;
    private JRadioButton masculinoRadioButton;
    private JRadioButton femininoRadioButton;
    private JRadioButton outroRadioButton;
    private ButtonGroup EscolherSexo;

    public tela(String titulo){
        super(titulo);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();


        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = InputNome.getText();
                String nasc = InputNasc.getText();
                String rg = InputRG.getText();

                char sexo;
                if (masculinoRadioButton.isSelected()) {
                    sexo = 'M';
                } else if (femininoRadioButton.isSelected()) {
                    sexo = 'F';
                } else if (outroRadioButton.isSelected()) {
                    sexo = 'O';
                } else {
                    sexo = 'O';
                }

                String fone = InputFone.getText();
                String estCivi = InputEstCivil.getText();
                String endereco = InputEnd.getText();
                String cidade = InputCidade.getText();
                String estado = InputEstado.getText();

                MariaDBInsert.insertData(nome, nasc, rg, sexo, fone, estCivi, endereco, cidade, estado);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new tela("Adicionar Paciente");
        frame.setVisible(true);
    }
}
