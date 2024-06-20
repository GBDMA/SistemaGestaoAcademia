import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RelatorioFinanceiro extends JFrame {

    private JTextArea reportTextArea;

    public RelatorioFinanceiro() {
        // Configurar a janela principal
        setTitle("Relatório Financeiro");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criar o painel principal
        JPanel panel = new JPanel(new BorderLayout());

        // Área de texto para exibir o relatório financeiro (simulando dados)
        reportTextArea = new JTextArea();
        reportTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reportTextArea);
        panel.add(scrollPane, BorderLayout.CENTER);

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

        // Simular a adição de dados de relatório financeiro
        generateSampleReport();
    }

    // Método para gerar um relatório financeiro de exemplo
    private void generateSampleReport() {
        String report = "Relatório Financeiro\n";
        report += "-------------------\n";
        report += "Receita: R$ 10,000.00\n";
        report += "Despesas: R$ 7,500.00\n";
        report += "Lucro: R$ 2,500.00\n";
        reportTextArea.setText(report);
    }

    public static void main(String[] args) {
        // Criar e exibir a janela de Relatório Financeiro
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RelatorioFinanceiro().setVisible(true);
            }
        });
    }
}
