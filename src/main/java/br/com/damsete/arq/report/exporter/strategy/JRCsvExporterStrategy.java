package br.com.damsete.arq.report.exporter.strategy;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;

import java.io.ByteArrayOutputStream;

public class JRCsvExporterStrategy implements JRExporterStrategy {

    @Override
    public void exportReport(JasperPrint print, ByteArrayOutputStream outputStream) throws JRException {
        JRCsvExporter exporterCSV = new JRCsvExporter();
        exporterCSV.setExporterInput(new SimpleExporterInput(print));
        exporterCSV.setExporterOutput(new SimpleWriterExporterOutput(outputStream));
        exporterCSV.exportReport();
    }
}
