package parte3GrafoND;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class GrafoND implements GrafoUsuarioDeporte {
	private Map<String,Nodo> users;
	private Map<String,Nodo> sports;
	
	public GrafoND(){
		this.users=new HashMap<String,Nodo>();
		this.sports=new HashMap<String,Nodo>();
	}
	
	public void bind(String user, String sport){
		Nodo auxSport = this.addSport(sport);
		Nodo auxUser = this.addUser(user);
		if(!auxUser.contieneElemento(sport)) {
			auxUser.addToLista(auxSport);
		}
		if(!auxSport.contieneElemento(user)){
			auxSport.addToLista(auxUser);
		}
	}
	
	public Nodo addUser(String user) {
		Nodo aux = this.getUser(user);
		if(aux == null) {
			aux = new Nodo(user);
			users.put(user, aux);
		}
		return aux;
	}
	
	public Nodo addSport(String sport) {
		Nodo aux = this.getSport(sport);
		if(aux == null) {
			aux = new Nodo(sport);
			sports.put(sport, aux);
		}
		return aux;
	}
	
	public Nodo getUser(String user) {
		return users.get(user);
	}
	
	public Nodo getSport(String sport) {
		return sports.get(sport);
	}
	
	public Vector<String> personasEnComun(String user) {
		Vector<String> usuariosComun = new Vector<String>();
		Nodo usuarioActual = this.getUser(user);
		
		if (usuarioActual != null) {
			Vector<Nodo> deportes = usuarioActual.getLista();
			for (Nodo userAux : users.values()) {
				int contador = 0;
				if(!userAux.getId().equals(user)){
					for (Nodo deporte : deportes) {
						if(userAux.contieneElemento(deporte.getId())) {
							contador++;
						}
					}
					if(contador > 1) {
						usuariosComun.add(userAux.getId());
					}
				}
			}
			return usuariosComun;
		}
		return null;
	}
	
	public String deporteMasGustado(){
		String deporteMasGustado = "";
		int contador = 0;
		for (Nodo sport : sports.values()){
			if(sport.getLista().size() > contador) {
				deporteMasGustado = sport.getId();
				contador = sport.getLista().size();
			}
		}
		return deporteMasGustado;
	}
	
	public String personaMasLejana(String user){
		String personaMasLejana = "";
		int contador = Integer.MAX_VALUE;
		
		Nodo usuarioActual = this.getUser(user);
		if (usuarioActual != null) {
			Vector<Nodo> deportes = usuarioActual.getLista();
			for (Nodo userAux : users.values()){
				if(!userAux.getId().equals(user)){
					int contActual = 0;
					for (Nodo deporte : deportes) {
						if(userAux.contieneElemento(deporte.getId())){
							contActual++;
						}
					}
					if(contActual < contador) {
						contador = contActual;
						personaMasLejana = userAux.getId();
					}
					if(contador == 0) {
						return personaMasLejana;
					}
				}
			}
		}
		return personaMasLejana;
	}
}
