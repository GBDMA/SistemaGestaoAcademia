import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GerenciamentoAula extends JFrame {
    private JTextArea classesTextArea;
    private JTextField classField;
    private JLabel messageLabel;

    public GerenciamentoAula() {
        // Configurar a janela principal
        setTitle("Gerenciamento de Aulas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criar o painel principal
        JPanel panel = new JPanel(new BorderLayout());

        // Text area para exibir as aulas (simulando dados de aulas)
        classesTextArea = new JTextArea();
        classesTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(classesTextArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Painel para adicionar nova aula
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel classLabel = new JLabel("Nova Aula:");
        classField = new JTextField(20);
        JButton addButton = new JButton("Adicionar");
        messageLabel = new JLabel();

        inputPanel.add(classLabel);
        inputPanel.add(classField);
        inputPanel.add(addButton);

        panel.add(inputPanel, BorderLayout.SOUTH);
        panel.add(messageLabel, BorderLayout.NORTH);

        // Adicionar ação ao botão "Adicionar"
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String className = classField.getText();
                if (!className.isEmpty()) {
                    addClass(className);
                    classField.setText("");
                    messageLabel.setText("Aula adicionada com sucesso!");
                    messageLabel.setForeground(Color.GREEN);
                } else {
                    messageLabel.setText("O campo de aula não pode estar vazio.");
                    messageLabel.setForeground(Color.RED);
                }
            }
        });

        // Botão "Home"
        JButton homeButton = new JButton("Home");
        panel.add(homeButton, BorderLayout.NORTH);

        // Adicionar ação ao botão "Home"
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaHome();
                dispose(); // Fechar a janela atual
            }
        });

        // Adicionar o painel à janela
        add(panel);
        setVisible(true);
    }

    // Método para adicionar uma nova aula na JTextArea
    private void addClass(String className) {
        classesTextArea.append(className + "\n");
    }

    public static void main(String[] args) {
        // Criar e exibir a janela de Gerenciamento de Aulas
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GerenciamentoAula().setVisible(true);
            }
        });
    }
}
