package pjAula11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EscreveArquivo {
	public static void main (String[] args) {
		String texto = "A nível organizacional, a hegemonia do ambiente político causa impacto indireto na reavaliação do processo de comunicação como um todo." + "\nAinda assim, existem dúvidas a respeito de como a mobilidade dos capitais internacionais pode nos levar a considerar a reestruturação de alternativas às soluções ortodoxas." + "\nAinda assim, existem dúvidas a respeito de como a percepção das dificuldades faz parte de um processo de gerenciamento da gestão inovadora da qual fazemos parte.";
		
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
