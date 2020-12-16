package JuegoDeCartas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;


import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import Pociones.Pocion;

public class Juego {
	private Mazo mazo;
	private Jugador j1,j2;
	private int turno;
	private int maxRondas;
	private ArrayList<Pocion> pociones;
	
	public Juego(Mazo mazo, Jugador j1, Jugador j2,int maxRondas,ArrayList<Pocion> pociones) {
		this.mazo = mazo;
		this.j1 = j1;
		this.j2 = j2;
		this.maxRondas=maxRondas;
		this.turno=1;
		this.pociones=pociones;
	}
		
	public void repartir() {
		while(mazo.cantidadCartas() > 1) {
			j1.addCarta(mazo.getPrimeraCarta());
			j2.addCarta(mazo.getPrimeraCarta());
		}
	}
	

	
	public void repartirPociones() {
		
		
		for (int j = 0; j < pociones.size(); j++) {
			int i=(int) (Math.random() * mazo.cantidadCartas());
			while (mazo.getCartas().get(i).tienePocion()) {
				i=(int) (Math.random() * mazo.cantidadCartas());
			}
			mazo.agregarPocion(pociones.get(j), i);
		}
			
		
		
	}
	
	public void comenzarJuego() {
		mazo.mezclar();
		if (!pociones.isEmpty())
			repartirPociones();
		repartir();
		int i=0;
		while(i<maxRondas && (j1.getTamanio() > 0 && j2.getTamanio() > 0)) {
			System.out.println("----------Ronda " + i + "---------");
			if (turno==1)
				pelear(j1,j2);
			else
				pelear(j2,j1);
			System.out.println(j1.getNombre() + " tiene " + j1.getTamanio() + " cartas  y " + j2.getNombre() + " tiene " + j2.getTamanio()+ " cartas");
			i++;
		}
		
		if (j1.getTamanio()>j2.getTamanio()) 
			System.out.println("El ganador es " + j1.getNombre());
		else 
			if ((j1.getTamanio()<j2.getTamanio()))
				System.out.println("El ganador es " + j2.getNombre());
			else 
				System.out.println("Los jugadores empataron");
		
	}
	
	public void pelear(Jugador j1,Jugador j2) {
		Carta c1;
		Carta c2;
		Atributo atributoPelea;
		Atributo atributoPeleaRival;
		c1 = j1.jugarCarta();
		c2 = j2.jugarCarta();
		atributoPelea = j1.implementarEstrategia(c1);  			//	Son copias de los
		atributoPeleaRival = c2.buscarAtributo(atributoPelea); //	 atributos originales
		System.out.println("El jugador " + j1.getNombre() + " eligio competir por el atributo " + atributoPelea.getNombre());
		System.out.println("La carta de " + j1.getNombre() + " es " + c1.getNombre() + " con " + atributoPelea.getNombre() + " " + atributoPelea.getValor());
		if (c1.tienePocion()) {
			c1.aplicarPocion(atributoPelea);
			System.out.println("ATENCION: El jugador " + j1.getNombre() + " aplicó pocima " + c1.getPocima() + " valor resultante " + atributoPelea.getValor());
		}
		System.out.println("La carta de " + j2.getNombre() + " es " + c2.getNombre() + " con " + atributoPeleaRival.getNombre()+ " " + atributoPeleaRival.getValor());
		if (c2.tienePocion()) {
			c2.aplicarPocion(atributoPeleaRival);
			System.out.println("ATENCION: El jugador " + j2.getNombre() + " aplicó pocima " + c2.getPocima() + " valor resultante " + atributoPeleaRival.getValor());
		}
			if(atributoPelea.compareTo(atributoPeleaRival)>1) {
				j1.addCarta(c1);
				j1.addCarta(c2);
				System.out.println("Gana la ronda " + j1.getNombre());
				turno = 1;
			}else if(atributoPelea.compareTo(atributoPeleaRival)<1){
				j2.addCarta(c1);
				j2.addCarta(c2);
				System.out.println("Gana la ronda " + j2.getNombre());
				turno = 2;
			}
			else {
				j1.addCarta(c1);
				j2.addCarta(c2);
				System.out.println("Ronda empatada " + j2.getNombre());
			}
	}
	public void getTamanio() {
		System.out.println("Tamaño del mazo: " + mazo.cantidadCartas());
	}
	
	public static void empezarJuego(String jsonFile, Juego j) {
        File jsonInputFile = new File(jsonFile);
        InputStream is;
        try {
            is = new FileInputStream(jsonInputFile);
            JsonReader reader = Json.createReader(is);
            JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
            for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
                String nombreCarta = carta.getString("nombre");
                JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
                Carta c1 = new Carta(nombreCarta);
                String atributosStr = "";
                for (String nombreAtributo:atributos.keySet()) {
                    atributosStr = atributosStr + nombreAtributo + ": " +
                    atributos.getInt(nombreAtributo) + "; ";
                	Atributo a1 = new Atributo(nombreAtributo, atributos.getInt(nombreAtributo));
                	c1.addAtributo(a1);
                }
                j.mazo.addCarta(c1); 
            }
            reader.close();
            j.getTamanio();
            j.comenzarJuego();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

		
		
		
		
		
}
