package JuegoDeCartas;

import java.util.ArrayList;

import Pociones.Pocion;

public class Carta {
	String nombre;
	private ArrayList<Atributo> atributos;
	private Pocion pocion;
	
	public Carta(String nombre) {
		this.nombre = nombre;
		this.atributos = new ArrayList<>();
		this.pocion=null;
	}
	public String getNombre() {
		return nombre;
	}
	
	public String getPocima() {
		return pocion.getNombre();
	}
	
	public void setPocion(Pocion pocion) {
		this.pocion = pocion;
	}
	
	public boolean tienePocion() {
		return this.pocion!=null;
	}
	
	public void aplicarPocion(Atributo atributoSeleccionado) {
		atributoSeleccionado.setValor(pocion.utilizarPocion(this, atributoSeleccionado));  
	}

	public ArrayList<Atributo> getAtributos() {
		ArrayList<Atributo> retorno = new ArrayList<>();
		retorno.addAll(atributos);
		return retorno;
	}
	

	
	public Atributo getCopiaAtributo(int i) {
		return this.getAtributos().get(i).getCopia();
	}
	
	public Atributo buscarAtributo(Atributo a) {
		for(int i=0; i<this.atributos.size(); i++) {
			if(this.atributos.get(i).equals(a)) {
				return getCopiaAtributo(i);
			}
		}
		return null;
	}
	
	public Atributo seleccionarAtributoRandom() {
		int iRandom = (int) (Math.random() * atributos.size());
		return getCopiaAtributo(iRandom);
	}
	
	public Atributo seleccionarAtributoMayor() {
		Atributo max = new Atributo("max",-1);
		int j=-1; // indice que indica donde está el mayor atributo
		for(int i=0; i<this.atributos.size(); i++) {
			if(this.atributos.get(i).compareTo(max)>0) {
				max = this.atributos.get(i);
				j=i;
			}
		}
		return getCopiaAtributo(j);
		
}

	public void addAtributo(Atributo atributo) {
		atributos.add(atributo);
	}
	
	@Override
	public boolean equals(Object obj) {
		try {
			Carta otra = (Carta) obj;
			boolean entra = true;
			if (atributos.size()==otra.getAtributos().size()) {
				int i=0;
				while ((entra) && (i<atributos.size())){
					entra = atributos.contains(otra.getAtributos().get(i));
					i++;
				}
			}
			else return false;
			return entra;
		}
		catch(Exception e){
			return false;
		}
	}
	
}
