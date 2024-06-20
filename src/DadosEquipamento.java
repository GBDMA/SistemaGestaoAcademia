import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DadosEquipamento extends JFrame {
    private JTextField nomeEquipamentoField;
    private JTextField tipoEquipamentoField;
    private JTextField quantidadeField;
    private JLabel messageLabel;

    public DadosEquipamento() {
        // Configurar a janela principal
        setTitle("Dados de Equipamento");
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
        JLabel nomeEquipamentoLabel = new JLabel("Nome do Equipamento:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(nomeEquipamentoLabel, constraints);

        nomeEquipamentoField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(nomeEquipamentoField, constraints);

        JLabel tipoEquipamentoLabel = new JLabel("Tipo do Equipamento:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(tipoEquipamentoLabel, constraints);

        tipoEquipamentoField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(tipoEquipamentoField, constraints);

        JLabel quantidadeLabel = new JLabel("Quantidade:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(quantidadeLabel, constraints);

        quantidadeField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(quantidadeField, constraints);

        JButton homeButton = new JButton("Home");
        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(homeButton, constraints);

        messageLabel = new JLabel();
        constraints.gridx = 1;
        constraints.gridy = 4;
        panel.add(messageLabel, constraints);

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

    public static void main(String[] args) {
        // Criar e exibir a janela
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DadosEquipamento().setVisible(true);
            }
        });
    }
}
