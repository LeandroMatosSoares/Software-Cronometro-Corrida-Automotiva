package trabalho2_recuperacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Arquivo
{
	private List<Piloto> listaPilotos;
	private int numeroPilotos;
	private float numeroVoltas;
	
	
	
	public Arquivo()
	{
		this.listaPilotos = new ArrayList<Piloto>();
		this.numeroPilotos = 0;
		this.numeroVoltas = 0;
	}
	
	public void lerPilotos()
	{
		listaPilotos.clear();
		Scanner sc = new Scanner(System.in);
		System.out.println("Informe o nome do arquivo: ");
		
		String nomeDoArquivo = sc.nextLine();
		
		try
		{
			FileReader arq = new FileReader(nomeDoArquivo);
			BufferedReader leitor = new BufferedReader(arq);
			
			setNumeroPilotos(Integer.parseInt(leitor.readLine().split(" ")[1]));
			setNumeroVoltas(Integer.parseInt(leitor.readLine().split(" ")[1]));
			
			for(int i=0; i<numeroPilotos; i++)
			{
				String nome = leitor.readLine();
				Piloto aux = new Piloto(nome);
				for(int j=0; j<numeroVoltas; j++)
				{
					float volta = Float.parseFloat(leitor.readLine());
					aux.addVolta(volta);
				}
				listaPilotos.add(aux);
			}
			arq.close();
			
		} catch(IOException e)
		{
			System.err.printf("Erro ao abrir o arquivo: %s", e.getMessage());
		}
		System.out.println();
	}

	public List<Piloto> getListaPilotos() {
		return listaPilotos;
	}

	public void setListaPilotos(List<Piloto> listaPilotos) {
		this.listaPilotos = listaPilotos;
	}

	public int getNumeroPilotos() {
		return numeroPilotos;
	}

	public void setNumeroPilotos(int numeroPilotos) {
		this.numeroPilotos = numeroPilotos;
	}

	public float getNumeroVoltas() {
		return numeroVoltas;
	}

	public void setNumeroVoltas(float numeroVoltas)
	{
		this.numeroVoltas = numeroVoltas;
	}
	
	
	
	public String melhorTempoEVoltas()
	{
		StringBuilder sb = new StringBuilder();
		float melhorVolta = 0;
		int numeroVolta = 0;
		String melhorPiloto = null;
		for(Piloto piloto:listaPilotos)
		{
			List<Float> voltas = piloto.getVoltas();
			for(int i = 0; i < voltas.size(); i++)
			{
				float auxVolta = voltas.get(i);
				if(auxVolta > melhorVolta)
				{
					melhorVolta = auxVolta;
					numeroVolta = i;
					melhorPiloto = piloto.getNome();
				}
			}
		}

		sb.append("O melhor tempo foi: "+ melhorVolta);
		sb.append("Na volta: "+ numeroVolta);
		sb.append("Do piloto: "+ melhorPiloto);
		return sb.toString();
	}

	public String melhorTempoPorPiloto()
	{
		StringBuilder sb = new StringBuilder();
		for(Piloto piloto:listaPilotos)
		{
			float melhorVolta = 0;
			int numeroVolta = 0;
			List<Float> voltas = piloto.getVoltas();
			for(int i = 0; i < voltas.size(); i++)
			{
				float auxVolta = voltas.get(i);
				if(auxVolta > melhorVolta)
				{
					melhorVolta = auxVolta;
					numeroVolta = i;
				}
			}
			sb.append("O melhor tempo do piloto "+piloto.getNome()+" foi "+melhorVolta+" na volta "+numeroVolta);
		}
		return sb.toString();
	}

	public String piorTempoPorPiloto()
	{
		StringBuilder sb = new StringBuilder();
		for(Piloto piloto:listaPilotos)
		{
			float piorVolta = 1000;
			int numeroVolta = 0;
			List<Float> voltas = piloto.getVoltas();
			for(int i = 0; i < voltas.size(); i++)
			{
				float auxVolta = voltas.get(i);
				if(auxVolta < piorVolta)
				{
					piorVolta = auxVolta;
					numeroVolta = i;
				}
			}
			sb.append("O pior tempo do piloto "+piloto.getNome()+" foi "+piorVolta+" na volta "+numeroVolta);
		}
		return sb.toString();
	}

	public String mediaTempoPorPiloto()
	{
		StringBuilder sb = new StringBuilder();
		for(Piloto piloto:listaPilotos)
		{
			sb.append("A média de tempo das voltas do piloto "+piloto.getNome()+" foi "+piloto.getMedia());
		}

		return sb.toString();
	}
	
	@Override
	public String toString()
	{
		return "Arquivo [listaPilotos=" + listaPilotos + "]";
	}
}