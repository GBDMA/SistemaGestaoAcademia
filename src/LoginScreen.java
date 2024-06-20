import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {

    // Componentes da interface
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginScreen() {
        // Configurações da janela
        setTitle("Tela de Login");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Adicionar a imagem
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        ImageIcon icon = new ImageIcon("logo.png");
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(newImg));
        panel.add(imageLabel, gbc);

        // Adicionar o título
        gbc.gridy = 1;
        JLabel titleLabel = new JLabel("Bem vindo ao sistema de gestão de academia", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(titleLabel, gbc);

        // Adicionar instruções
        gbc.gridy = 2;
        JLabel instructionLabel = new JLabel("Coloque seu email e senha para entrar:", SwingConstants.CENTER);
        instructionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(instructionLabel, gbc);

        // Adicionar campo de email
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(new JLabel("Nome de Usuário:"), gbc);

        gbc.gridx = 1;
        usernameField = new JTextField(20);
        panel.add(usernameField, gbc);

        // Adicionar campo de senha
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Senha:"), gbc);

        gbc.gridx = 1;
        passwordField = new JPasswordField(20);
        panel.add(passwordField, gbc);

        // Adicionar botão de login
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        loginButton = new JButton("Entrar");
        loginButton.addActionListener(new LoginButtonListener());
        panel.add(loginButton, gbc);

        // Adicionar painel principal à janela
        add(panel);
    }

    private class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Ao clicar no botão "Entrar", abre a TelaHome
            new TelaHome();
            dispose(); // Fecha a tela de login
        }
    }

    public static void main(String[] args) {
        // Cria e exibe a tela de login
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }
}
