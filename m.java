import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class m {
	public static void main(String[] args)  {
		try {
			new grafico(hash(37));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static double[] hash(int R) throws IOException {
		double [] vector;
		BufferedReader file = new BufferedReader(new FileReader("es_ES.dic"));
		String line = file.readLine(); //  lee el primer elemento
		vector = new double[Integer.parseInt(line)]; // dimesiona el vector con el numero de palabras que tiene el archivo
		
		line = file.readLine();  // lee la primera palabra
		int index = 0;
		while(line != null)
		{
			String linea;
			if(line.indexOf("/") != -1)
			{
				System.out.println(line.substring(0, line.indexOf('/')));
				linea = line.substring(0, line.indexOf('/'));
			}
			else
				linea = line;
			int hash_value = 0;
			for ( int k=1; k < linea.length(); k*=2 )
				hash_value = hash_value * R + (linea.charAt(k-1));
			vector[index++] = hash_value%1000;
			line = file.readLine();
		}		
		return vector;
	}
}
