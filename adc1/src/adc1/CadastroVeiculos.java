package adc1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

	public class CadastroVeiculos extends JFrame implements ActionListener {
		JButton btCadastrar, btLimpar, btAlterar, btExcluir,btPesquisar,btSair;
		JTextField txtPlaca, txtModelo, txtAnoFabricacao, txtValor, txtDataCompra;
		JLabel lbPlaca, lbFabricante, lbModelo, lbAnoFabricacao, lbValor, lbDataCompra;
		JComboBox selectFabricante;
		JPanel pnCampos, pnBotoes, pnGrid;

	int indexdovetor = 0;

		Veiculo[] vetores = new Veiculo[10];


	public CadastroVeiculos() {
		super("Controle de veiculos - Cadastro de Frota");
		setSize(585, 220);
		setLayout(new BorderLayout());

		btCadastrar = new JButton("Cadastrar");
		btAlterar = new JButton("Alterar");
		btExcluir = new JButton("Excluir");
		btPesquisar = new JButton("Pesquisar");
		btLimpar = new JButton("Limpar");
		btSair = new JButton("Sair");

String marca[] = { null, "Hyundai", "Ford", "Honda", "Chevrolet", "Renault",

"Peugeot", "Volksvagen", "Fiat", "Mercedes", "BMW", "Ferrari", "Audi"};


	txtPlaca = new JTextField(10);
	txtModelo = new JTextField(10);
	selectFabricante = new JComboBox(marca);
	txtAnoFabricacao = new JTextField(10);
	txtValor = new JTextField(10);
	txtDataCompra = new JTextField(10);

	lbPlaca = new JLabel(" Placa:");
	lbFabricante = new JLabel(" Fabricante:");
	lbModelo = new JLabel(" Modelo:");
	lbAnoFabricacao = new JLabel(" Ano de Fabricação:");
	lbDataCompra = new JLabel(" Data da Compra:");
	lbValor = new JLabel(" Valor:");

	pnCampos = new JPanel(new GridLayout(3,3));
	pnBotoes = new JPanel(new FlowLayout());

	pnCampos.add(lbPlaca);
	pnCampos.add(txtPlaca);
	pnCampos.add(lbFabricante);
	pnCampos.add(selectFabricante);
	pnCampos.add(lbModelo);
	pnCampos.add(txtModelo);
	pnCampos.add(lbAnoFabricacao);
	pnCampos.add(txtAnoFabricacao);
	pnCampos.add(lbDataCompra);
	pnCampos.add(txtDataCompra);
	pnCampos.add(lbValor);
	pnCampos.add(txtValor);

	pnBotoes.add(btCadastrar);
	pnBotoes.add(btAlterar);
	pnBotoes.add(btExcluir);
	pnBotoes.add(btPesquisar);
	pnBotoes.add(btLimpar);
	pnBotoes.add(btSair);

	btCadastrar.addActionListener(this);
	btAlterar.addActionListener(this);
	btExcluir.addActionListener(this);
	btPesquisar.addActionListener(this);
	btLimpar.addActionListener(this);
	btSair.addActionListener(this);

	add(pnCampos, BorderLayout.NORTH);
	add(pnBotoes, BorderLayout.SOUTH);

	setVisible(true);

}

public static void main(String[] args) {
	CadastroVeiculos form = new CadastroVeiculos();
	form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

@Override
public void actionPerformed(ActionEvent ev) {
	Object evento = ev.getSource();
	if(evento == btSair) {
		System.exit(1);
}
	
	if(evento == btCadastrar) {
		cadastrar();
	}

	if(evento == btPesquisar) {
		pesquisar();
	}

	if(evento == btAlterar) {
		alterar();
	}

	if(evento == btLimpar) {
		limpar();
	}

	if(evento == btExcluir) {
		excluir();
	}
}

public void cadastrar() {
	vetores[indexdovetor] = new Veiculo(txtPlaca.getText(), txtModelo.getText(),
			Integer.parseInt(txtAnoFabricacao.getText()), String.valueOf(txtValor.getText()), String.valueOf(selectFabricante.getSelectedItem()),
			String.valueOf(txtDataCompra.getText()));
	limpar();

	indexdovetor++;

	JOptionPane.showMessageDialog(null, "Veículo cadastrado!");

}

private void pesquisar() {
	String placaDigitada = txtPlaca.getText();
	boolean veiculoEncontrado = false;

	for (Veiculo veiculo : vetores) {
		if(veiculo != null) {
			if (veiculo.getPlaca().equalsIgnoreCase(placaDigitada)) {
				
				veiculoEncontrado = true;

				txtPlaca.setText(veiculo.getPlaca());
				txtModelo.setText(veiculo.getModelo());
				txtAnoFabricacao.setText(String.valueOf(veiculo.getAnoFabricacao()));
				txtValor.setText(String.valueOf(veiculo.getValor()));
				selectFabricante.setSelectedItem(veiculo.getFabricante());
				txtDataCompra.setText(veiculo.getDataCompra());
					
				break;

			}
		}
	}


	if (!veiculoEncontrado) {
		JOptionPane.showMessageDialog( null, "Veículo não encontrado!");
	}

	btPesquisar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			pesquisar();
		}

	});

}

public void alterar() {
	String placaDigitada = txtPlaca.getText();
	for (Veiculo veiculo : vetores) {
		if(veiculo != null) {
			if (veiculo.getPlaca().equalsIgnoreCase(placaDigitada)) {

				veiculo.setModelo(txtModelo.getText());
				veiculo.setAnoFabricacao(Integer.parseInt(txtAnoFabricacao.getText()));
				veiculo.setValor(String.valueOf(txtValor.getText()));
				veiculo.setFabricante(String.valueOf(selectFabricante.getSelectedItem()));
				veiculo.setDataCompra(String.valueOf(txtDataCompra.getText()));

				break;
				}

		}

	}

}

public void limpar() {
	txtPlaca.setText(null);
	txtModelo.setText(null);
	txtAnoFabricacao.setText(null);
	txtValor.setText(null);
	selectFabricante.setSelectedIndex(0);
	txtDataCompra.setText(null);
}

public void excluir() {
	String placaDigitada = txtPlaca.getText();
	for (Veiculo veiculo : vetores) {
		if(veiculo != null) {
			if (veiculo.getPlaca().equalsIgnoreCase(placaDigitada)) {
				veiculo.setModelo("");
				veiculo.setAnoFabricacao(0);

				veiculo.setValor("");
				veiculo.setFabricante(null);
				veiculo.setDataCompra("");
				
				break;

			}

		}

	}

}

}