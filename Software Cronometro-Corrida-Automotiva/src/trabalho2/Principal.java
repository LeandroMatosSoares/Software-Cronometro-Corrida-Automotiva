package trabalho2_recuperacao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Principal
{
	public static void main(String[] args)
	{
		Arquivo arquivo = new Arquivo();
		
		arquivo.lerPilotos();
		try{
		FileWriter arq = new FileWriter("resultado.txt");
	    PrintWriter gravador = new PrintWriter(arq);

	    gravador.println(arquivo.melhorTempoEVoltas());
	    gravador.println(arquivo.melhorTempoPorPiloto());
	    gravador.println(arquivo.piorTempoPorPiloto());
	    gravador.println(arquivo.mediaTempoPorPiloto());

	    arq.close();
	    System.out.println("O arquivo de resultados foi salvo como resultado.txt");
		} catch (IOException e)
		{
			System.err.printf("Erro ao abrir o arquivo: %s", e.getMessage());
		}
	}
}