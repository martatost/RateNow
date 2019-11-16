package com.ratenow.provatecnica.controller;

import java.io.IOException;
import java.util.Optional;

import org.jfree.chart.JFreeChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ratenow.provatecnica.model.TestGraph;
import com.ratenow.provatecnica.repositories.TestGraphRepository;
import com.ratenow.provatecnica.services.PdfService;
import com.ratenow.provatecnica.services.BarChart;

@RestController
public class TestGraphController {

    @Autowired
    TestGraphRepository testGraphRepository;

    @RequestMapping(value = "/testgraph", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void newTestGraph(@RequestBody TestGraph testGraph) {
        testGraphRepository.save(testGraph);
    }

    @RequestMapping(value = "/testgraph/{graphid}", method = RequestMethod.GET)
    public TestGraph getById(@PathVariable("graphid") Long id) {

        Optional<TestGraph> optional = testGraphRepository.findById(id);
        TestGraph testGraph = optional.isPresent() ? optional.get() : null;
        return testGraph;
    }

    @RequestMapping("/pdf/{graphid}")
    public void printTestGraph(@PathVariable("graphid") Long id) throws IOException {
        String filePath = "src/main/resources/files/";
        BarChart barChart = new BarChart();
        Optional<TestGraph> optional = testGraphRepository.findById(id);

        TestGraph testGraph = optional.isPresent() ? optional.get() : null;
        JFreeChart chart = barChart.generationBarChart(testGraph);

        PdfService.writeChartToPDF(testGraph, chart, 500, 400, filePath);
        PdfService.generationImageBarChar(chart, filePath, testGraph.getTitle());
    }
}
