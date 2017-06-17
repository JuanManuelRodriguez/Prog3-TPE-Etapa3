package parte3GrafoND;

public class PruebaGrafoND {

	public static void main(String[] args) {
		GrafoND grafo = new GrafoND();
		
		LeerDatos.CSVInsert("./src/data/dataset_insert_10000.csv", ";", grafo);

		System.out.println(grafo.getUser("44083345"));
		System.out.println(grafo.getSport("Waterpolo").getLista());

		String deporteMasGustado = grafo.deporteMasGustado();
		System.out.println("El deporte más gustado es: " + deporteMasGustado +" con "+ grafo.getSport(deporteMasGustado).getLista().size() + " usuarios");
		
		String usuario = "99446263";
		System.out.println("La persona mas alejada de " + usuario + " es: " + grafo.personaMasLejana(usuario));
	}
}
