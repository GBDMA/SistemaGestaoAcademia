import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GerenciamentoPagamentos extends JFrame {
    private JTextArea paymentsTextArea;
    private JTextField paymentField;

    public GerenciamentoPagamentos() {
        // Configurar a janela principal
        setTitle("Gerenciamento de Pagamentos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criar o painel principal
        JPanel panel = new JPanel(new BorderLayout());

        // Text area para exibir os pagamentos (simulando dados de pagamentos)
        paymentsTextArea = new JTextArea();
        paymentsTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(paymentsTextArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Painel para adicionar novo pagamento
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel paymentLabel = new JLabel("Novo Pagamento:");
        paymentField = new JTextField(20);
        JButton addButton = new JButton("Adicionar");

        inputPanel.add(paymentLabel);
        inputPanel.add(paymentField);
        inputPanel.add(addButton);

        panel.add(inputPanel, BorderLayout.SOUTH);

        // Adicionar ação ao botão "Adicionar"
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String payment = paymentField.getText();
                if (!payment.isEmpty()) {
                    addPayment(payment);
                    paymentField.setText("");
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

    // Método para adicionar um novo pagamento na JTextArea
    private void addPayment(String payment) {
        paymentsTextArea.append(payment + "\n");
    }

    public static void main(String[] args) {
        // Criar e exibir a janela de Gerenciamento de Pagamentos
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GerenciamentoPagamentos().setVisible(true);
            }
        });
    }
}
