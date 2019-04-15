//libreria: jchart 1.0.19
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class grafico1{
	grafico1 (double[] vector, int R)  // vector de los sueldos de cada empleado
	{
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i = 0; i < vector.length; i++) {
			dataset.setValue(vector[i], "1", Integer.toString(i));  // inserta en la lista de datos el valor, el conjunto, el respectivo numero del empleado
		}
        JFreeChart chart = ChartFactory.createBarChart(
                null, "Numero de clave", "Frecuencia", dataset,
                PlotOrientation.VERTICAL, false, false, false);

        try {
			ChartUtilities.saveChartAsPNG(new File("R"+R+".PNG"), chart, 1000, 1000);
	        } catch (IOException e) {}
        JFrame frame = new JFrame("Frecuencias");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ChartPanel(chart));
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
	}
}