package Estrategias;

import JuegoDeCartas.*;


public class Ambicioso implements Estrategia {
	

	@Override
	public Atributo implementarEstrategia(Carta c) {
		return c.seleccionarAtributoMayor();
	}

}
