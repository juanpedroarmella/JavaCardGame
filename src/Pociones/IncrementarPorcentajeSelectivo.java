package Pociones;

import JuegoDeCartas.Atributo;
import JuegoDeCartas.Carta;

public class IncrementarPorcentajeSelectivo extends IncrementarPorcentaje {
	
	private String nombreAtributo;

	public IncrementarPorcentajeSelectivo(String nombre,int valorModificar,String n) {
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
