package parte3GrafoND;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerDatos {
	
	public static void CSVInsert(String path, String separador,GrafoND grafo) {
		String csvFile = path;
		String line = "";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] items = line.split(separador);
				
				for (int i = 1; i < items.length; i++) {
					grafo.bind(items[0], items[i]);	
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
