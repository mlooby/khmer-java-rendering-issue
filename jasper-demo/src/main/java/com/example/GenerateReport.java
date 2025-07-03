package com.example;

import net.sf.jasperreports.engine.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class GenerateReport
{
    public static void main(String[] args) throws Exception
    {
        JasperReport jasperReport = JasperCompileManager.compileReport(
                GenerateReport.class.getResourceAsStream("/reports/khmer_test.jrxml"));

        // Fill the report with empty data and parameters
        Map<String, Object> parameters = new HashMap<>();
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

        // Export to PDF
        String outputPath = "build/output/khmer_test_output.pdf";
        new java.io.File("build/output").mkdirs();
        JasperExportManager.exportReportToPdfFile(jasperPrint, outputPath);

        System.out.println("Exported to: " + System.getProperty("user.dir") + File.separator + outputPath);
    }
}
