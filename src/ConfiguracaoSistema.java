import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfiguracaoSistema extends JFrame {

    public ConfiguracaoSistema() {
        // Configurar a janela principal
        setTitle("Configurações do Sistema");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criar o painel principal
        JPanel panel = new JPanel(new BorderLayout());

        // Adicionar alguns componentes de configuração (simulados)
        JTextArea configTextArea = new JTextArea("Configurações do Sistema:\n\n- Opção 1\n- Opção 2\n- Opção 3\n...");
        configTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(configTextArea);
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
    }

    public static void main(String[] args) {
        // Criar e exibir a janela de Configurações do Sistema
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConfiguracaoSistema().setVisible(true);
            }
        });
    }
}
