package com.ratenow.provatecnica.services;

import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;

import org.jfree.data.general.DefaultPieDataset;

import com.ratenow.provatecnica.model.TestGraph;

public class PieChart {
	
	public JFreeChart generationPieChart(TestGraph graphInformation) {
		
		DefaultPieDataset dataSet = new DefaultPieDataset();
		List<Integer> valuesToShow = graphInformation.getValuesToShow();
		
		for(int i=0; i<valuesToShow.size();i++) {
			dataSet.setValue("i", valuesToShow.get(i));
		}
		
		JFreeChart chart = ChartFactory.createPieChart(
				"Test Graph RateNow", dataSet, true, true, false);

		return chart;
	}

}
