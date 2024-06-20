import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class NossoEspaco extends JFrame {

    public NossoEspaco() {
        setTitle("Nosso Espaço");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Painel principal com BorderLayout
        JPanel panel = new JPanel(new BorderLayout(10, 10));

        // Adicionar primeira imagem centralizada
        ImageIcon imageIcon1 = createImageIcon("imagem1.jpg");
        if (imageIcon1 != null) {
            JLabel label1 = new JLabel(imageIcon1);
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(label1, BorderLayout.CENTER);
        } else {
            System.err.println("Imagem 1 não encontrada!");
        }

        // Botão "Home"
        JButton homeButton = new JButton("Home");
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ao clicar no botão "Home", voltar para a TelaHome
                dispose(); // Fecha a tela atual
                new TelaHome(); // Abre a tela principal novamente
            }
        });

        // Adicionar o botão "Home" ao topo do painel principal
        panel.add(homeButton, BorderLayout.NORTH);

        // Adicionar o painel principal à janela
        add(panel);

        setVisible(true);
    }

    private ImageIcon createImageIcon(String path) {
        try {
            File file = new File(path);
            if (file.exists()) {
                return new ImageIcon(file.getPath());
            } else {
                System.err.println("Arquivo não encontrado: " + path);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        // Criar e exibir a janela NossoEspaco
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NossoEspaco();
            }
        });
    }
}
