import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GerenciamentoEquipamentos extends JFrame {
    private JTextArea equipmentTextArea;
    private JTextField equipmentField;
    private List<String> equipmentList;

    public GerenciamentoEquipamentos() {
        // Configurar a janela principal
        setTitle("Gerenciamento de Equipamentos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializar a lista de equipamentos
        equipmentList = new ArrayList<>();

        // Criar o painel principal
        JPanel panel = new JPanel(new BorderLayout());

        // Text area para exibir os equipamentos
        equipmentTextArea = new JTextArea();
        equipmentTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(equipmentTextArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Painel para adicionar novo equipamento
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel equipmentLabel = new JLabel("Novo Equipamento:");
        equipmentField = new JTextField(20);
        JButton addButton = new JButton("Adicionar");

        inputPanel.add(equipmentLabel);
        inputPanel.add(equipmentField);
        inputPanel.add(addButton);

        panel.add(inputPanel, BorderLayout.SOUTH);

        // Adicionar ação ao botão "Adicionar"
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String equipment = equipmentField.getText();
                if (!equipment.isEmpty()) {
                    addEquipment(equipment);
                    equipmentField.setText("");
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

    // Método para adicionar um novo equipamento na JTextArea e na lista
    private void addEquipment(String equipment) {
        equipmentList.add(equipment);
        updateEquipmentTextArea();
    }

    // Método para atualizar a JTextArea com os equipamentos da lista
    private void updateEquipmentTextArea() {
        equipmentTextArea.setText("");
        for (String equipment : equipmentList) {
            equipmentTextArea.append(equipment + "\n");
        }
    }

    public static void main(String[] args) {
        // Criar e exibir a janela de Gerenciamento de Equipamentos
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GerenciamentoEquipamentos().setVisible(true);
            }
        });
    }
}
