import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//abre es_ES.dic remueve lo despues de / de cada palabra, hace hash con cada palabra, agrega a un vector double, y retorna el vector double.
public class hash {
	int R;
	public double[] vector;
	public hash(int R) throws IOException
	{
		this.R = R;
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
			vector[index++] = hash_value;
			line = file.readLine();
		}		
	}
	
}
