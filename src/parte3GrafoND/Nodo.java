package parte3GrafoND;

import java.util.Vector;

public class Nodo {
	private String id; //DNI o gusto de usuario
	private Vector<Nodo> lista;
	
	public Nodo(String id){
		this.id = id;
		lista = new Vector<Nodo>();
	}
	
	public String getId(){
		return this.id;
	}
	
	public Vector<Nodo> getLista(){
		return this.lista;
	}
	
	public void addToLista(Nodo elem){
		this.lista.add(elem);
	}
	
	public boolean contieneElemento(String elem) {
		for (Nodo nodo : lista) {
			if (nodo.getId().equals(elem)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return this.id;
	}
}
