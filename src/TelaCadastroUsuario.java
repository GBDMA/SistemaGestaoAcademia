import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroUsuario extends JFrame {

    // Componentes da interface
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField emailField;
    private JButton cadastrarButton;
    private JButton voltarButton;

    public TelaCadastroUsuario() {
        // Configurações da janela
        setTitle("Cadastro de Usuário");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel para organizar os componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        // Rótulos e campos de texto
        panel.add(new JLabel("Nome de Usuário:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Senha:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        // Botão de cadastro
        cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new CadastrarButtonListener());
        panel.add(cadastrarButton);

        // Botão de voltar para home
        voltarButton = new JButton("Home");
        voltarButton.addActionListener(new VoltarButtonListener());
        panel.add(voltarButton);

        // Adiciona o painel à janela
        add(panel);

        setVisible(true);
    }

    private class CadastrarButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String email = emailField.getText();

            // Aqui você pode adicionar a lógica de cadastro de usuário
            JOptionPane.showMessageDialog(TelaCadastroUsuario.this, "Usuário cadastrado com sucesso!");
        }
    }

    private class VoltarButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Fecha a tela de cadastro de usuário e volta para a TelaHome
            new TelaHome();
            dispose();
        }
    }

    public static void main(String[] args) {
        // Cria e exibe a tela de cadastro de usuário
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaCadastroUsuario().setVisible(true);
            }
        });
    }
}
