import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class m {
	public static void main(String[] args)  {
		try {
			//new grafico(hash(31), 31);
			new grafico(hashCada(64), 64);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static double[] hashCada(int R) throws IOException {
		double [] vector;
		BufferedReader file = new BufferedReader(new FileReader("es_ES.dic"));
		String line = file.readLine(); //  lee el numero de palabras en el archivo
		vector = new double[Integer.parseInt(line)]; // dimesiona el vector con el numero de palabras que tiene el archivo
		
		line = file.readLine();  // lee la primera palabra
		int index = 0;
		while(line != null)
		{
			String linea;
			if(line.indexOf("/") != -1)  // separamos el parentesis de las palabras si tienen parentesis
			{
				System.out.println(line.substring(0, line.indexOf('/')));
				linea = line.substring(0, line.indexOf('/'));
			}
			else
				linea = line;
			int hash_value = 0;
			for ( int k=1; k < linea.length(); k++ )
			{
				if(linea.charAt(k-1)<0)
					System.out.println(linea + "->" + (k-1));
				hash_value = (hash_value * R + (linea.charAt(k-1)))%1000;  // hacemos modulo por cada operacion pq los numeros exceden la capacidad de int
			}
			vector[index++] = hash_value;
			line = file.readLine();
		}		
		return vector;
	}
	
	public static double[] hash(int R) throws IOException {
		double [] vector;
		BufferedReader file = new BufferedReader(new FileReader("es_ES.dic"));
		String line = file.readLine(); //  lee el numero de palabras en el archivo
		vector = new double[Integer.parseInt(line)]; // dimesiona el vector con el numero de palabras que tiene el archivo
		
		line = file.readLine();  // lee la primera palabra
		int index = 0;
		while(line != null)
		{
			String linea;
			if(line.indexOf("/") != -1)  // separamos el parentesis de las palabras si tienen parentesis
			{
				System.out.println(line.substring(0, line.indexOf('/')));
				linea = line.substring(0, line.indexOf('/'));
			}
			else
				linea = line;
			int hash_value = 0;
			for ( int k=1; k < linea.length(); k*=2 )
			{
				if(linea.charAt(k-1)<0)
					System.out.println(linea + "->" + (k-1));
				hash_value = (hash_value * R + (linea.charAt(k-1)))%1000;  // hacemos modulo por cada operacion pq los numeros exceden la capacidad de int
			}
			vector[index++] = hash_value;
			line = file.readLine();
		}		
		return vector;
	}
}
