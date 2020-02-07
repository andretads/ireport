package br.com.damsete.arq.report.exporter.strategy;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;

import java.io.ByteArrayOutputStream;

public class JRTextExporterStrategy implements JRExporterStrategy {

    @Override
    public void exportReport(JasperPrint print, ByteArrayOutputStream outputStream) throws JRException {
        JRTextExporter exporterTXT = new JRTextExporter();
        exporterTXT.setExporterInput(new SimpleExporterInput(print));
        exporterTXT.setExporterOutput(new SimpleWriterExporterOutput(outputStream));
        exporterTXT.exportReport();
    }
}
