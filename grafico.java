//codigo ejemplo de: http://programacionjfreechart.blogspot.com/2011/05/ejemplo-practico-histograma-de-ingresos.html
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class grafico extends ApplicationFrame {
	static int R;
	public grafico(double[] vector, int R) {
		super("Frecuencias");
		this.R = R;
		JPanel chartPanel = crearPanel(vector);
		chartPanel.setPreferredSize(new java.awt.Dimension(1000, 1000));
		setContentPane(chartPanel);
		this.pack();
		RefineryUtilities.centerFrameOnScreen(this);
		this.setVisible(true);
	}
	
	public static JPanel crearPanel(double[] vector) {
		JFreeChart chart = crearChart(crearDataset(vector));
		try {
			ChartUtilities.saveChartAsPNG(new File("todosLosCaracteres-R"+R+".PNG"), chart, 1000, 1000);
	        } catch (IOException e) {}
		return new ChartPanel(chart);
	}
	
	private static IntervalXYDataset crearDataset(double[] vector) {
		HistogramDataset dataset = new HistogramDataset();
		dataset.addSeries("Frecuencias de claves", vector, 10000);
		return dataset;
	}
	
	private static JFreeChart crearChart(IntervalXYDataset dataset) {
		JFreeChart chart = ChartFactory.createHistogram(
		"R="+R,
		"valor de la clave",
		"frecuencias",
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