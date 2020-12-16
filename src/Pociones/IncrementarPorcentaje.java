package Pociones;
import JuegoDeCartas.Atributo;
import JuegoDeCartas.Carta;

public class IncrementarPorcentaje extends PocionComun {
	
	
	public IncrementarPorcentaje(String nombre,int valorModificar) {
		super(nombre,valorModificar);
	}
	
	@Override
	public int utilizarPocion(Carta c,Atributo atributoSeleccionado) {
		for (int i = 0; i < c.getAtributos().size(); i++) {
			if (c.getAtributos().get(i).getValor()==atributoSeleccionado.getValor()) {
				int valor = c.getAtributos().get(i).getValor();
				 valor += this.valorModificar*valor/100;
				 return valor;
			} 
		}
		return atributoSeleccionado.getValor();
	}
	 
}