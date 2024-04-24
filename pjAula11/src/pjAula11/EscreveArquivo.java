package pjAula11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EscreveArquivo {
	public static void main (String[] args) {
		String texto = "A n�vel organizacional, a hegemonia do ambiente pol�tico causa impacto indireto na reavalia��o do processo de comunica��o como um todo." + "\nAinda assim, existem d�vidas a respeito de como a mobilidade dos capitais internacionais pode nos levar a considerar a reestrutura��o de alternativas �s solu��es ortodoxas." + "\nAinda assim, existem d�vidas a respeito de como a percep��o das dificuldades faz parte de um processo de gerenciamento da gest�o inovadora da qual fazemos parte.";
		
		String nome_arq = "memoria.txt";
		File tstArquivo = new File(nome_arq);
		if(!tstArquivo.exists()) {
			try {
				tstArquivo.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//Estruturpara escrita
		try {
			FileWriter arquivoSaida = new FileWriter(nome_arq);
			BufferedWriter buffer = new BufferedWriter(arquivoSaida);
			buffer.write(texto);
			buffer.close();
		}catch (IOException e) {
			System.err.println("Erro ao abrir o arquivo.");
		}
		
		//Estrutura para leitura
		try {
			FileReader arquivoLeitura = new FileReader(nome_arq);
			BufferedReader buffer = new BufferedReader(arquivoLeitura);
			String saida = buffer.readLine();
			while(saida != null) {
				System.out.println(saida);
				saida = buffer.readLine();
			}
		} catch (IOException e) {
			System.out.println("Erro ao ler arquivo");
		}
		
	}
	
}
