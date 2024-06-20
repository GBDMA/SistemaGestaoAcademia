import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualizacaoEdicaoProfessores extends JFrame {
    private JTextField nameField;
    private JTextField ageField;
    private JTextField subjectField;
    private JLabel messageLabel;

    public VisualizacaoEdicaoProfessores() {
        // Configurar a janela principal
        setTitle("Visualização/Edição de Professores");
        setSize(400, 250);
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

        JLabel subjectLabel = new JLabel("Matéria:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(subjectLabel, constraints);

        subjectField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(subjectField, constraints);

        JButton saveButton = new JButton("Salvar");
        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(saveButton, constraints);

        JButton homeButton = new JButton("Home");
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(homeButton, constraints);

        messageLabel = new JLabel();
        constraints.gridx = 1;
        constraints.gridy = 4;
        panel.add(messageLabel, constraints);

        // Adicionar ação ao botão de salvar
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTeacher();
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

    private void saveTeacher() {
        String name = nameField.getText();
        String age = ageField.getText();
        String subject = subjectField.getText();

        if (name.isEmpty() || age.isEmpty() || subject.isEmpty()) {
            messageLabel.setText("Todos os campos são obrigatórios.");
            messageLabel.setForeground(Color.RED);
        } else {
            try {
                int parsedAge = Integer.parseInt(age);
                // Lógica para salvar os dados de edição (por enquanto, apenas imprime no console)
                System.out.println("Nome: " + name);
                System.out.println("Idade: " + parsedAge);
                System.out.println("Matéria: " + subject);

                // Mensagem de sucesso
                messageLabel.setText("Dados atualizados com sucesso!");
                messageLabel.setForeground(Color.GREEN);

                // Limpa os campos após a atualização bem-sucedida
                nameField.setText("");
                ageField.setText("");
                subjectField.setText("");
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
                new VisualizacaoEdicaoProfessores().setVisible(true);
            }
        });
    }
}
