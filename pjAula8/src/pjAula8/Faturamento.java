package pjAula8;

public class Faturamento {
	public static void main(String[] args) {
		/*System.out.println("Atualmente NotaFiscal.sequencia " + NotaFiscal.sequencia);
		
		NotaFiscal notaA = new NotaFiscal();
		System.out.println("N�mero da Nota " + notaA.getNumero());
		
		for(int i=0; i<1000; i++) {
			new NotaFiscal();
		}
		
		System.out.println("Atualmente NotaFiscal.sequencia " + NotaFiscal.sequencia);*/
	
		NotaFiscal entrada = new NotaFiscal();
		entrada.setFornecedor("Livraria �tica");
		entrada.setTotal(634);
		NotaFiscal.cambio = 5.450;
		
		NotaFiscal saida = new NotaFiscal();
		saida.setFornecedor("UNISAL");
		saida.setTotal(120);
		saida.cambio = 2.175;
		
		System.out.println("Entrada " + " n�mero " + entrada.getNumero() + " total " + entrada.getTotal() * entrada.cambio);
		System.out.println("Sa�da " + " n�mero " + saida.getNumero() + " total " + saida.getTotal() * saida.cambio);
			
	}
}
