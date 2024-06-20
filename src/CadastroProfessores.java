import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroProfessores extends JFrame {
    private JTextField nomeField;
    private JTextField idadeField;
    private JTextField disciplinaField;
    private JTextField departamentoField;
    private JLabel mensagemLabel;

    public CadastroProfessores() {
        // Configurar a janela principal
        setTitle("Cadastro de Professores");
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
        JLabel nomeLabel = new JLabel("Nome:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(nomeLabel, constraints);

        nomeField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(nomeField, constraints);

        JLabel idadeLabel = new JLabel("Idade:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(idadeLabel, constraints);

        idadeField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(idadeField, constraints);

        JLabel disciplinaLabel = new JLabel("Disciplina:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(disciplinaLabel, constraints);

        disciplinaField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(disciplinaField, constraints);

        JLabel departamentoLabel = new JLabel("Departamento:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(departamentoLabel, constraints);

        departamentoField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(departamentoField, constraints);

        JButton cadastrarButton = new JButton("Cadastrar");
        constraints.gridx = 1;
        constraints.gridy = 4;
        panel.add(cadastrarButton, constraints);

        mensagemLabel = new JLabel();
        constraints.gridx = 1;
        constraints.gridy = 5;
        panel.add(mensagemLabel, constraints);

        // Botão "Home"
        JButton homeButton = new JButton("Home");
        constraints.gridx = 1;
        constraints.gridy = 6;
        panel.add(homeButton, constraints);

        // Adicionar ação ao botão "Cadastrar"
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarProfessor();
            }
        });

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

    private void cadastrarProfessor() {
        String nome = nomeField.getText();
        String idade = idadeField.getText();
        String disciplina = disciplinaField.getText();
        String departamento = departamentoField.getText();

        if (nome.isEmpty() || idade.isEmpty() || disciplina.isEmpty() || departamento.isEmpty()) {
            mensagemLabel.setText("Todos os campos são obrigatórios.");
            mensagemLabel.setForeground(Color.RED);
        } else {
            try {
                int parsedIdade = Integer.parseInt(idade);
                // Lógica para salvar os dados de cadastro (por enquanto, apenas imprime no console)
                System.out.println("Nome: " + nome);
                System.out.println("Idade: " + parsedIdade);
                System.out.println("Disciplina: " + disciplina);
                System.out.println("Departamento: " + departamento);

                // Mensagem de sucesso
                mensagemLabel.setText("Cadastro realizado com sucesso!");
                mensagemLabel.setForeground(Color.GREEN);

                // Limpar os campos após o registro bem-sucedido
                nomeField.setText("");
                idadeField.setText("");
                disciplinaField.setText("");
                departamentoField.setText("");
            } catch (NumberFormatException ex) {
                mensagemLabel.setText("Idade deve ser um número.");
                mensagemLabel.setForeground(Color.RED);
            }
        }
    }

    public static void main(String[] args) {
        // Criar e exibir a janela de Cadastro de Professores
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CadastroProfessores().setVisible(true);
            }
        });
    }
}
