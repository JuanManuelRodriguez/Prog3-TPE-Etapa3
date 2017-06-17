package parte3GrafoND;

import java.util.Vector;

public interface GrafoUsuarioDeporte {
	public void bind(String user, String sport);
	public Nodo addUser(String user);
	public Nodo addSport(String sport);
	public Nodo getUser(String user);
	public Nodo getSport(String sport);
	public Vector<String> personasEnComun(String user);
	public String deporteMasGustado();
	public String personaMasLejana(String user);
}