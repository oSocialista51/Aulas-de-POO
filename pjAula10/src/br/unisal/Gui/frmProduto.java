package br.unisal.Gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.unisal.Modelagem.Situacao;
import br.unisal.Modelagem.UnidadeMedida;

public class frmProduto extends JFrame implements ActionListener{
	
	JLabel lbCodigo, lbDescricao, lbUnidadeMedida, lbLargura, lbComprimento, lbSituacao, lbLocalizacao;
	JTextField txtCodigo, txtDescricao, txtLargura, txtComprimento, txtLocalizacao;
	JComboBox cbxUnidadeMedida, cbxSituacao;
	JPanel pnCampos, pnBotoes;
	JButton btnInclui, btnExclui, btnAltera, btnPesquisa;
	
	public frmProduto() {
		super("Cadastro de Produto");
		setSize(300, 200);
		setLayout(new BorderLayout());
		
		//2 Passo contruir os objetos
		lbCodigo = new JLabel("Código");
		lbDescricao = new JLabel("Descrição");
		lbUnidadeMedida = new JLabel("Un. Medida");
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
		
		pnCampos = new JPanel(new GridLayout(7,2));
		pnBotoes = new JPanel(new GridLayout(1,4));
		
		//3 Passo adicionar os campos ao frame
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
		pnCampos.add(btnExclui);
		pnCampos.add(btnPesquisa);
		
		add(pnBotoes, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
	
