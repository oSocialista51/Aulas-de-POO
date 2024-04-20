package br.unisal.gui;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class frmProduto extends JFrame implements ActionListener {
    // Passo 1: Declarar os objetos
    JLabel lbCodigo, lbDescricao, lbUnidadeMedida, lbLargura, lbComprimento, lbSituacao, lbLocalizacao;
    JTextField txtCodigo, txtDescricao, txtLargura, txtComprimento, txtLocalizacao;
    JComboBox<String> cbxUnidadeMedida;
    JComboBox<Situacao> cbxSituacao;
    JPanel pnCampos, pnBotoes;
    JButton btnInclui, btnExclui, btnAltera, btnPesquisa, btnLimpa;
    List<Produto> bdProduto = new ArrayList<Produto>();
    int codigoPesquisa;

    public frmProduto() {
        super("Cadastro de Produto");
        setSize(485, 250);
        setLayout(new BorderLayout());

        // Passo 2: Construir os objetos
        lbCodigo = new JLabel(" Código ");
        lbDescricao = new JLabel(" Descrição ");
        lbUnidadeMedida = new JLabel(" Unidade de Medida ");
        lbLargura = new JLabel(" Largura ");
        lbComprimento = new JLabel(" Comprimento ");
        lbSituacao = new JLabel(" Situação ");
        lbLocalizacao = new JLabel(" Localização ");

        txtCodigo = new JTextField();
        txtDescricao = new JTextField();
        txtLargura = new JTextField();
        txtComprimento = new JTextField();
        txtLocalizacao = new JTextField();
        cbxUnidadeMedida = new JComboBox<String>(UnidadeMedida.getUnidades());
        cbxSituacao = new JComboBox<Situacao>(Situacao.values());

        btnInclui = new JButton("Incluir");
        btnAltera = new JButton("Alterar");
        btnExclui = new JButton("Excluir");
        btnPesquisa = new JButton("Pesquisar");
        btnLimpa = new JButton("Limpar");

        pnCampos = new JPanel(new GridLayout(7, 2));
        pnBotoes = new JPanel(new GridLayout(1, 5)); // Adicionando um botão extra para Limpar

        // Passo 3: Adicionar os campos ao Frame
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
        pnBotoes.add(btnLimpa);

        add(pnBotoes, BorderLayout.SOUTH);

        // Passo 4: Incluir os elementos no Listener de Ações
        btnInclui.addActionListener(this);
        btnAltera.addActionListener(this);
        btnExclui.addActionListener(this);
        btnPesquisa.addActionListener(this);
        btnLimpa.addActionListener(this);

        // Desabilitar botões Alterar e Excluir no início
        btnAltera.setEnabled(false);
        btnExclui.setEnabled(false);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInclui) {
            Produto p = instanciar();
            if (p != null) {
                bdProduto.add(p);
                btnAltera.setEnabled(true); 
                btnExclui.setEnabled(true); 
            }
        } else if (e.getSource() == btnAltera) {
        	for (Produto p : bdProduto) {
        		if (p.getCodigo() == p.getCodigo()) {
                   Produto objeto = instanciar();
                    if (objeto != null) {
                    		p = objeto;                     
                    }
        		}
        	}
            
            try {
                codigoPesquisa = Integer.parseInt(txtCodigo.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Código de produto inválido", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Procurar o produto na lista pelo código
            Produto produtoEncontrado = null;
            for (Produto p : bdProduto) {
                if (p.getCodigo() == codigoPesquisa) {
                    produtoEncontrado = p;
                    break;
                }
            }

            // Verificar se o produto foi encontrado
            if (produtoEncontrado != null) {
                // Atualizar os dados do produto com os novos valores dos campos de texto
                Produto objeto = instanciar();
                if (objeto != null) {
                    produtoEncontrado.setDescricao(objeto.getDescricao());
                    produtoEncontrado.setUn(objeto.getUn());
                    produtoEncontrado.setLargura(objeto.getLargura());
                    produtoEncontrado.setComprimento(objeto.getComprimento());
                    produtoEncontrado.setSituacao(objeto.getSituacao());
                    produtoEncontrado.setLocalizacao(objeto.getLocalizacao());
                    JOptionPane.showMessageDialog(null, "Produto alterado com sucesso", "Alteração", JOptionPane.INFORMATION_MESSAGE);
                	}
            } 	else 	{
            		JOptionPane.showMessageDialog(null, "Produto não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
            	}
            
        	} else if (e.getSource() == btnExclui) {
            // Implementação do botão Exclui        	
            
            try {
                codigoPesquisa = Integer.parseInt(txtCodigo.getText());
            	} catch (NumberFormatException ex) {
            		JOptionPane.showMessageDialog(null, "Código de produto inválido", "Erro", JOptionPane.ERROR_MESSAGE);
            		return;
            	}

            // Procurar o produto na lista pelo código
            Produto produtoEncontrado = null;
            for (Produto p : bdProduto) {
                if (p.getCodigo() == codigoPesquisa) {
                    produtoEncontrado = p;
                    break;
                }
            }

            	// Verificar se o produto foi encontrado
            	if 	(produtoEncontrado !=  null) {
                	// Atualizar a situação do produto para "EXCLUIDO"
                	produtoEncontrado.setSituacao(Situacao.EXCLUIDO);

                	// Limpar todos os campos
                	txtCodigo.setText(null);
                	txtDescricao.setText(null);                
                	txtLargura.setText(null);
                	txtComprimento.setText(null);
                	txtLocalizacao.setText(null);
                	cbxSituacao.setSelectedIndex(0);
                	cbxUnidadeMedida.setSelectedIndex(0);
                	btnExclui.setEnabled(false);
                	btnAltera.setEnabled(false);
            	}
            
        	} else if (e.getSource() == btnPesquisa) {     
        		// Implementação do botão Pesquisa       	
        		try {
        			codigoPesquisa = Integer.parseInt(txtCodigo.getText());
        		} catch (NumberFormatException ex) {
        			JOptionPane.showMessageDialog(null, "Código de produto inválido", "Erro", JOptionPane.ERROR_MESSAGE);
        			return;
        		}

        		// Procurar o produto na lista pelo código
        		Produto produtoEncontrado = null;
        		for (Produto p : bdProduto) {
        			if (p.getCodigo() == codigoPesquisa) {
        				produtoEncontrado = p;
        				btnPesquisa.setBackground(Color.LIGHT_GRAY);
        				break;
        			}
        		}

        		// Verificar se o produto foi encontrado
        		if (produtoEncontrado != null) {
                // Preencher os campos com os dados do produto encontrado
                txtDescricao.setText(produtoEncontrado.getDescricao());
                cbxUnidadeMedida.setSelectedItem(produtoEncontrado.getUn().toString());
                txtLargura.setText(String.valueOf(produtoEncontrado.getLargura()));
                txtComprimento.setText(String.valueOf(produtoEncontrado.getComprimento()));
                cbxSituacao.setSelectedItem(produtoEncontrado.getSituacao().toString());
                txtLocalizacao.setText(produtoEncontrado.getLocalizacao());                     
                // Desabilitar o campo Código e habilitar botões Alterar e Excluir
                txtCodigo.setEnabled(false);
                btnAltera.setEnabled(true); // Ativa botão Altera
                btnExclui.setEnabled(true); // Ativa botão Exclui
                
                	if (!txtDescricao.getText().isEmpty() || cbxUnidadeMedida.getSelectedIndex() != 0 ||
                			!txtLargura.getText().isEmpty() || !txtComprimento.getText().isEmpty() ||
                			cbxSituacao.getSelectedIndex() != 0 || !txtLocalizacao.getText().isEmpty()) {
                		// Limpar os campos
                		txtDescricao.setText(null);
                		cbxUnidadeMedida.setSelectedIndex(0);
                		txtLargura.setText(null);
                		txtComprimento.setText(null);
                		cbxSituacao.setSelectedIndex(0);
                		txtLocalizacao.setText(null);
                	}
                
        		}
            
        	}else if (e.getSource() == btnLimpa) {
        			// Limpa todos os campos e habilita o campo Código com o foco de digitação
        			btnPesquisa.setBackground(null);
        			txtCodigo.setEnabled(true);
        			txtCodigo.requestFocus();
        			txtCodigo.setText(null);
        			txtDescricao.setText(null);
        			txtLargura.setText(null);
        			txtComprimento.setText(null);
        			txtLocalizacao.setText(null);
        			cbxUnidadeMedida.setSelectedIndex(0);
        			// Resetar seleção dos JComboBox para o primeiro item
        			cbxSituacao.setSelectedIndex(0);
        			btnAltera.setEnabled(false); // Desativa botão Altera
        			btnExclui.setEnabled(false); // Desativa botão Exclui
        			btnInclui.setEnabled(true); // Ativa botão Inclui
        		}            
        System.out.println(bdProduto);
    }
    private Produto instanciar() {
        Produto p = new Produto();
        try {
            p.setCodigo(Integer.parseInt(txtCodigo.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Código do Produto Inválido", "Validação", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        p.setDescricao(txtDescricao.getText());
        p.setUn(UnidadeMedida.values()[cbxUnidadeMedida.getSelectedIndex()]);
        try {
            p.setLargura(Integer.parseInt(txtLargura.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Largura do Produto Inválida", "Validação", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        try {
            p.setComprimento(Integer.parseInt(txtComprimento.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Comprimento do Produto Inválido", "Validação", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        p.setSituacao(Situacao.values()[cbxSituacao.getSelectedIndex()]);
        p.setLocalizacao(txtLocalizacao.getText());
        return p;
    }
    
    public static void main(String[] args) {
        frmProduto frm = new frmProduto();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


