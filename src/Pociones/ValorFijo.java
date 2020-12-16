package Pociones;

import JuegoDeCartas.Atributo;
import JuegoDeCartas.Carta;

public class ValorFijo extends PocionComun {
	
	public ValorFijo(String nombre,int valorModificar) {
		super(nombre,valorModificar);
	}
	
	@Override
	public int utilizarPocion(Carta c,Atributo atributoSeleccionado) {
		return valorModificar;
	}
	 
}