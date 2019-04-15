import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class m {
	public static void main(String[] args)  {
		try {
			//new grafico(hash(31), 31);
			new grafico1(hash(31), 31);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// hace hash por cada letra
	public static double[] hashCada(int R) throws IOException {
		double [] vector;
		BufferedReader file = new BufferedReader(new FileReader("es_ES.dic"));
		String line = file.readLine(); //  lee el numero de palabras en el archivo
		vector = new double[1000]; // dimesiona el vector con el numero de palabras que tiene el archivo
		
		line = file.readLine();  // lee la primera palabra
		while(line != null)
		{
			String linea;
			if(line.indexOf("/") != -1)  // separamos el parentesis de las palabras si tienen parentesis
			{
				//System.out.println(line.substring(0, line.indexOf('/')));
				linea = line.substring(0, line.indexOf('/'));
			}
			else
				linea = line;
			int hash_value = 0;
			for ( int k=1; k < linea.length(); k++ )
			{
				hash_value = (hash_value * R + (linea.charAt(k-1)))%1000;  // hacemos modulo por cada operacion pq los numeros exceden la capacidad de int
			}
			vector[hash_value] += 1;
			line = file.readLine();
		}		
		return vector;
	}
	
	// hace hash con 2^k-1
	public static double[] hash(int R) throws IOException {
		double [] vector;
		BufferedReader file = new BufferedReader(new FileReader("es_ES.dic"));
		String line = file.readLine(); //  lee el numero de palabras en el archivo
		vector = new double[1000]; // dimesiona el vector con el numero de palabras que tiene el archivo
		
		line = file.readLine();  // lee la primera palabra
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
				hash_value = (hash_value * R + (linea.charAt(k-1)))%1000;  // hacemos modulo por cada operacion pq los numeros exceden la capacidad de int
			}
			vector[hash_value] += 1;
			line = file.readLine();
		}		
		return vector;
	}
}
