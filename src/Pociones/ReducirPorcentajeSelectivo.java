package Pociones;

import JuegoDeCartas.Atributo;
import JuegoDeCartas.Carta;

public class ReducirPorcentajeSelectivo extends ReducirPorcentaje {
	private String nombreAtributo;

	public ReducirPorcentajeSelectivo(String nombre,int valorModificar,String n) {
		super(nombre,valorModificar);
		this.nombreAtributo=n;
	}
	
	@Override
	public int utilizarPocion(Carta c,Atributo atributoSeleccionado) {
		if (nombreAtributo.equals(atributoSeleccionado.getNombre())) {
			super.utilizarPocion(c,atributoSeleccionado);
		}
		return atributoSeleccionado.getValor();
	}
}
