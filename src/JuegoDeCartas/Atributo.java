package JuegoDeCartas;

public class Atributo implements Comparable<Atributo> {
	private String nombre;
	private int valor;
	
	public Atributo(String nombre, int valor) {
		this.nombre = nombre;
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public Atributo getCopia() {
		return new Atributo(this.getNombre(),this.getValor());
	}
	
	@Override
	public boolean equals(Object obj) {
		try {
			Atributo otra = (Atributo) obj;
			return this.getNombre().equals(otra.getNombre());
		}
		catch(Exception e){
			return false;
		}
	}
	
	@Override
	public int compareTo(Atributo o) {
		if (this.getValor()>o.getValor())
			return 100;
		else if	(this.getValor()<o.getValor())
			return -100;
		else
			return 0;
	}
}
