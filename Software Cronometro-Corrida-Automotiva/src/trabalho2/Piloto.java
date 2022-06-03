package trabalho2_recuperacao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Piloto
{
	private String nome;
	private List<Float> voltas;
				
	public Piloto(String nome)
	{
		this.nome = nome;
		this.voltas = new ArrayList<Float>();
	}
		
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Float> getVoltas() {
		return voltas;
	}

	public void setVoltas(List<Float> voltas) {
		this.voltas = voltas;
	}
	
	public void addVolta(float volta)
	{
		this.voltas.add(volta);
	}	

	public float getMedia()
	{
	  float media = 0;
	  for(float volta:voltas){
	    media+=volta;
	  }
	  return (float)(media/voltas.size());
	}
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Piloto [nome=" + nome + ", voltas=" + voltas + "]";
	}
}