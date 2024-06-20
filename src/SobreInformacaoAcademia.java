import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SobreInformacaoAcademia extends JFrame {

    public SobreInformacaoAcademia() {
        // Configurar a janela principal
        setTitle("Sobre a Academia");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criar o painel principal
        JPanel panel = new JPanel(new BorderLayout());

        // Área de texto com a descrição da academia
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setText("Bem-vindo ao Sistema de Academia!\n\n"
                        + "Nossa academia oferece uma variedade de programas de fitness, "
                        + "incluindo treinamento de força, aulas de grupo e treinamento personalizado. "
                        + "Estamos comprometidos em ajudar você a alcançar seus objetivos de saúde e bem-estar.\n\n"
                        + "Visite-nos e descubra como podemos transformar sua jornada fitness!");

        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Botão "Home"
        JButton homeButton = new JButton("Home");
        panel.add(homeButton, BorderLayout.SOUTH);

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
        // Criar e exibir a janela de Sobre a Academia
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SobreInformacaoAcademia().setVisible(true);
            }
        });
    }
}
