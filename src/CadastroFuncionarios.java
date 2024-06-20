import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroFuncionarios extends JFrame {
    private JTextField nameField;
    private JTextField ageField;
    private JTextField departmentField;
    private JTextField positionField;
    private JLabel messageLabel;

    public CadastroFuncionarios() {
        // Configurar a janela principal
        setTitle("Cadastro de Funcionário");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criar o painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);

        // Adicionar componentes
        JLabel nameLabel = new JLabel("Nome:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(nameLabel, constraints);

        nameField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(nameField, constraints);

        JLabel ageLabel = new JLabel("Idade:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(ageLabel, constraints);

        ageField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(ageField, constraints);

        JLabel departmentLabel = new JLabel("Departamento:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(departmentLabel, constraints);

        departmentField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(departmentField, constraints);

        JLabel positionLabel = new JLabel("Cargo:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(positionLabel, constraints);

        positionField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(positionField, constraints);

        JButton registerButton = new JButton("Cadastrar");
        constraints.gridx = 1;
        constraints.gridy = 4;
        panel.add(registerButton, constraints);

        JButton homeButton = new JButton("Home");
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(homeButton, constraints);

        messageLabel = new JLabel();
        constraints.gridx = 1;
        constraints.gridy = 5;
        panel.add(messageLabel, constraints);

        // Adicionar ação ao botão de cadastro
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerEmployee();
            }
        });

        // Adicionar ação ao botão de voltar para Home
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaHome();
                dispose();
            }
        });

        // Adicionar o painel à janela
        add(panel);
        setVisible(true);
    }

    private void registerEmployee() {
        String name = nameField.getText();
        String age = ageField.getText();
        String department = departmentField.getText();
        String position = positionField.getText();

        if (name.isEmpty() || age.isEmpty() || department.isEmpty() || position.isEmpty()) {
            messageLabel.setText("Todos os campos são obrigatórios.");
            messageLabel.setForeground(Color.RED);
        } else {
            try {
                int parsedAge = Integer.parseInt(age);
                // Lógica para salvar os dados de cadastro (por enquanto, apenas imprime no console)
                System.out.println("Nome: " + name);
                System.out.println("Idade: " + parsedAge);
                System.out.println("Departamento: " + department);
                System.out.println("Cargo: " + position);

                // Mensagem de sucesso
                messageLabel.setText("Cadastro realizado com sucesso!");
                messageLabel.setForeground(Color.GREEN);

                // Limpa os campos após o registro bem-sucedido
                nameField.setText("");
                ageField.setText("");
                departmentField.setText("");
                positionField.setText("");
            } catch (NumberFormatException ex) {
                messageLabel.setText("Idade deve ser um número.");
                messageLabel.setForeground(Color.RED);
            }
        }
    }

    public static void main(String[] args) {
        // Criar e exibir a janela
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CadastroFuncionarios().setVisible(true);
            }
        });
    }
}
