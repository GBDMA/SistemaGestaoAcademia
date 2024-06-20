import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelaHome extends JFrame {

    public TelaHome() {
        setTitle("Tela Home");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criar o painel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(8, 2, 10, 10));

        // Adicionar os botões ao painel principal
        addButton(mainPanel, "Cadastro de Usuário", e -> abrirTelaCadastroUsuario());
        addButton(mainPanel, "Nosso Espaço", e -> abrirTelaPrincipal());
        addButton(mainPanel, "Cadastro de Aluno", e -> abrirTelaCadastroAluno());
        addButton(mainPanel, "Visualização/Edição de Aluno", e -> abrirTelaVisualizacaoEdicaoAluno());
        addButton(mainPanel, "Cadastro de Funcionários", e -> abrirTelaCadastroFuncionario());
        addButton(mainPanel, "Visualização/Edição de Funcionários", e -> abrirTelaVisualizacaoEdicaoFuncionario());
        addButton(mainPanel, "Cadastro de Professores", e -> abrirTelaCadastroProfessor());
        addButton(mainPanel, "Visualização/Edição de Professores", e -> abrirTelaVisualizacaoEdicaoProfessor());
        addButton(mainPanel, "Gerenciamento de Aulas", e -> abrirTelaGerenciamentoAulas());
        addButton(mainPanel, "Gerenciamento de Pagamentos", e -> abrirTelaGerenciamentoPagamentos());
        addButton(mainPanel, "Relatórios Financeiros", e -> abrirTelaRelatoriosFinanceiros());
        addButton(mainPanel, "Gerenciamento de Equipamentos", e -> abrirTelaGerenciamentoEquipamentos());
        addButton(mainPanel, "Configurações do Sistema", e -> abrirTelaConfiguracoesSistema());
        addButton(mainPanel, "Sobre/Informações da Academia", e -> abrirTelaSobreInformacoes());

        // Adicionar o painel principal ao frame
        add(mainPanel);

        setVisible(true);
    }

    private void addButton(JPanel panel, String text, ActionListener action) {
        JButton button = new JButton(text);
        button.addActionListener(action);
        panel.add(button);
    }

    private void abrirTelaCadastroUsuario() {
        new TelaCadastroUsuario();
        dispose();
    }

    private void abrirTelaPrincipal() {
        new NossoEspaco();
        dispose();
    }

    private void abrirTelaCadastroAluno() {
        new TelaCadastroAluno();
        dispose();
    }

    private void abrirTelaVisualizacaoEdicaoAluno() {
        new VisualizacaoEdicaoAluno();
        dispose();
    }

    private void abrirTelaCadastroFuncionario() {
        new CadastroFuncionarios();
        dispose();
    }

    private void abrirTelaVisualizacaoEdicaoFuncionario() {
        new VisualizacaoEdicaoFuncionarios();
        dispose();
    }

    private void abrirTelaCadastroProfessor() {
        new CadastroProfessores();
        dispose();
    }

    private void abrirTelaVisualizacaoEdicaoProfessor() {
        new VisualizacaoEdicaoProfessores();
        dispose();
    }

    private void abrirTelaGerenciamentoAulas() {
        new GerenciamentoAula();
        dispose();
    }

    private void abrirTelaGerenciamentoPagamentos() {
        new GerenciamentoPagamentos();
        dispose();
    }

    private void abrirTelaRelatoriosFinanceiros() {
        new RelatorioFinanceiro();
        dispose();
    }

    private void abrirTelaGerenciamentoEquipamentos() {
        new DadosEquipamento();
        dispose();
    }

    private void abrirTelaConfiguracoesSistema() {
        new ConfiguracaoSistema();
        dispose();
    }

    private void abrirTelaSobreInformacoes() {
        new SobreInformacaoAcademia();
        dispose();
    }

    public static void main(String[] args) {
        // Criar e exibir a janela TelaHome
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaHome();
            }
        });
    }
}
