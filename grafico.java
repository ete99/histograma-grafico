//codigo ejemplo de: http://programacionjfreechart.blogspot.com/2011/05/ejemplo-practico-histograma-de-ingresos.html
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class grafico extends ApplicationFrame {
	public grafico(double[] vector) {
		super("Frecuencias");
		JPanel chartPanel = crearPanel(vector);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 475));
		setContentPane(chartPanel);
		this.pack();
		RefineryUtilities.centerFrameOnScreen(this);
		this.setVisible(true);
	}
	
	public static JPanel crearPanel(double[] vector) {
		JFreeChart chart = crearChart(crearDataset(vector));
		return new ChartPanel(chart);
	}
	
	private static IntervalXYDataset crearDataset(double[] vector) {
		HistogramDataset dataset = new HistogramDataset();
		dataset.addSeries("Frecuencias de claves", vector, 8);
		return dataset;
	}
	
	private static JFreeChart crearChart(IntervalXYDataset dataset) {
		JFreeChart chart = ChartFactory.createHistogram(
		"Histograma",
		"frecuencias",
		"valor de la clave",
		dataset,
		PlotOrientation.VERTICAL,
		true,
		true,
		false
		);
		XYPlot plot = (XYPlot) chart.getPlot();
		XYBarRenderer renderer = (XYBarRenderer) plot.getRenderer();
		renderer.setDrawBarOutline(false);
		return chart;
	}


}