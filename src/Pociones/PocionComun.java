package Pociones;

public abstract class PocionComun extends Pocion {

	protected int valorModificar;

	public PocionComun(String nombre,int valorModificar) {
		super(nombre);
		this.valorModificar=valorModificar;
	}

	public void setValorModificar(int valorModificar) {
		this.valorModificar = valorModificar;
	}
	
	
	

}