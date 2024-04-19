package br.unisal.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.unisal.modelagem.Produto;
import br.unisal.modelagem.Situacao;
import br.unisal.modelagem.UnidadeMedida;

public class frmProduto extends JFrame implements ActionListener{
    
    JLabel lbCodigo, lbDescricao, lbUnidadeMedida, lbLargura, lbComprimento, lbSituacao, lbLocalizacao;
    JTextField txtCodigo, txtDescricao, txtLargura, txtComprimento, txtLocalizacao;
    JComboBox<String> cbxUnidadeMedida;
    JComboBox<Situacao> cbxSituacao;
    JPanel pnCampos, pnBotoes;
    JButton btnInclui, btnExclui, btnAltera, btnPesquisa, btnLimpar;
    List<Produto> bdProduto= new ArrayList<Produto>();
    Produto produtoAtual; // Variável para manter o produto atualmente exibido na pesquisa

    public frmProduto() {
        super("Cadastro de Produto");
        setSize(485, 250);
        setLayout(new BorderLayout());

        // Passo 2: construir os objetos
        lbCodigo = new JLabel("Código");
        lbDescricao = new JLabel("Descrição");
        lbUnidadeMedida = new JLabel("Unidade Medida");
        lbLargura = new JLabel("Largura");
        lbComprimento = new JLabel("Comprimento");
        lbSituacao = new JLabel("Situação");
        lbLocalizacao = new JLabel("Localização");

        txtCodigo = new JTextField();
        txtDescricao = new JTextField();
        txtLargura = new JTextField();
        txtComprimento = new JTextField();
        txtLocalizacao = new JTextField();
        cbxSituacao = new JComboBox<Situacao>(Situacao.values());
        cbxUnidadeMedida = new JComboBox<String>(UnidadeMedida.getUnidades());

        btnInclui = new JButton("Incluir");
        btnAltera = new JButton("Alterar");
        btnExclui = new JButton("Excluir");
        btnPesquisa = new JButton("Pesquisa");
        btnLimpar = new JButton("Limpar");

        pnCampos = new JPanel(new GridLayout(7, 2));
        pnBotoes = new JPanel(new GridLayout(1, 5));

        // Passo 3: adicionar os campos ao frame
        pnCampos.add(lbCodigo);
        pnCampos.add(txtCodigo);
        pnCampos.add(lbDescricao);
        pnCampos.add(txtDescricao);
        pnCampos.add(lbUnidadeMedida);
        pnCampos.add(cbxUnidadeMedida);
        pnCampos.add(lbLargura);
        pnCampos.add(txtLargura);
        pnCampos.add(lbComprimento);
        pnCampos.add(txtComprimento);
        pnCampos.add(lbSituacao);
        pnCampos.add(cbxSituacao);
        pnCampos.add(lbLocalizacao);
        pnCampos.add(txtLocalizacao);

        add(pnCampos, BorderLayout.CENTER);

        pnBotoes.add(btnInclui);
        pnBotoes.add(btnAltera);
        pnBotoes.add(btnExclui);
        pnBotoes.add(btnPesquisa);
        pnBotoes.add(btnLimpar);

        add(pnBotoes, BorderLayout.SOUTH);

        // Passo 4: incluir os elementos no Listener de Ações
        btnInclui.addActionListener(this);
        btnAltera.addActionListener(this);
        btnExclui.addActionListener(this);
        btnPesquisa.addActionListener(this);
        btnLimpar.addActionListener(this);
        btnAltera.setEnabled(false);
    	btnExclui.setEnabled(false);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPesquisa) {
            // Se o campo de código estiver desativado, significa que já há uma pesquisa carregada, então limpamos o formulário e ativamos o campo de código novamente
            if (!txtCodigo.isEnabled()) {
            	limparCampos();
            }
            pesquisarProduto();
        } else if (e.getSource() == btnInclui) {
            Produto p = instanciar();
            if (p != null) {
                bdProduto.add(p);
                JOptionPane.showMessageDialog(this, "Produto incluído com sucesso!");
            }
        } else if (e.getSource() == btnAltera) {
            if (produtoAtual != null) {
                // Implemente aqui a lógica para alterar o produto atual
                JOptionPane.showMessageDialog(this, "Produto alterado com sucesso!");
            } else {
            	 btnAltera.setEnabled(false);
                JOptionPane.showMessageDialog(this, "Nenhum produto selecionado para alteração!");
            }
        } else if (e.getSource() == btnExclui) {
            if (produtoAtual != null) {
                // Modificar o produto para situação EXCLUIDO
                produtoAtual.setSituacao(Situacao.EXCLUIDO);
                btnExclui.setEnabled(false); // Desativar botão Excluir se já estiver excluído
                JOptionPane.showMessageDialog(this, "Produto excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum produto selecionado para exclusão!");
            }
        } else if (e.getSource() == btnLimpar) {
            // Limpar todos os campos e voltar ao estado inicial
            limparCampos();
            txtCodigo.requestFocusInWindow(); // Posicionar foco de digitação no campo de código
        }
    }

    private Produto instanciar() {
        Produto p = new Produto();
        try {
            p.setCodigo(Integer.parseInt(txtCodigo.getText()));
            p.setDescricao(txtDescricao.getText());
            p.setUn(UnidadeMedida.values()[cbxUnidadeMedida.getSelectedIndex()]);
            p.setLargura(Double.parseDouble(txtLargura.getText()));
            p.setComprimento(Double.parseDouble(txtComprimento.getText()));
            p.setSituacao(Situacao.values()[cbxSituacao.getSelectedIndex()]);
            p.setLocalizacao(txtLocalizacao.getText());
            return p;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha os campos corretamente.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private void pesquisarProduto() {
        try {
            int codigo = Integer.parseInt(txtCodigo.getText());
            Produto produtoEncontrado = null;

            for (Produto p : bdProduto) {
                if (p.getCodigo() == codigo) {
                    produtoEncontrado = p;
                    break;
                }
            }

            if (produtoEncontrado != null) {
                txtCodigo.setEnabled(false); // Desativar campo de código
                produtoAtual = produtoEncontrado;
                btnExclui.setEnabled(produtoAtual.getSituacao() != Situacao.EXCLUIDO); // Habilitar ou desabilitar botão Excluir
                btnAltera.setEnabled(true); // Habilitar botão Alterar
            } else {
                txtCodigo.setEnabled(true); // Ativar campo de código se nenhum produto for encontrado
                produtoAtual = null;
                JOptionPane.showMessageDialog(this, "Produto não localizado.");
                btnExclui.setEnabled(false); // Desabilitar botão Excluir
                btnAltera.setEnabled(false); // Desabilitar botão Alterar
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um código válido.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparCampos() {
        txtCodigo.setText(null);
        txtDescricao.setText(null);
        txtLargura.setText(null);
        txtComprimento.setText(null);
        txtLocalizacao.setText(null);
        txtCodigo.setEnabled(true); // Ativar campo de código
        btnExclui.setEnabled(false); // Desativar botão Excluir
        produtoAtual = null;
        // Resetar seleção dos JComboBox para o primeiro item
        cbxUnidadeMedida.setSelectedIndex(0);
        cbxSituacao.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        frmProduto frm = new frmProduto();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
