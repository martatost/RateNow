package com.ratenow.provatecnica.services;

import java.util.List;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.ratenow.provatecnica.model.TestGraph;

public class BarChart {

    public JFreeChart generationBarChart(TestGraph graphInformation) {

        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        List<Integer> valuesToShow = graphInformation.getValuesToShow();

        for (int i = 0; i < valuesToShow.size(); i++) {
            dataSet.setValue(valuesToShow.get(i), "value", "" + (i + 1));
        }

        JFreeChart chart = ChartFactory.createBarChart(graphInformation.getTitle(), "", "", dataSet, PlotOrientation.VERTICAL, false, true, false);

        return chart;
    }

}
