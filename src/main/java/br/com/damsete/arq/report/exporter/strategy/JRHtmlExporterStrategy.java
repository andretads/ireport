package br.com.damsete.arq.report.exporter.strategy;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;

import java.io.ByteArrayOutputStream;

public class JRHtmlExporterStrategy implements JRExporterStrategy {

    @Override
    public void exportReport(JasperPrint print, ByteArrayOutputStream outputStream) throws JRException {
        HtmlExporter exporterHTML = new HtmlExporter();
        exporterHTML.setExporterInput(new SimpleExporterInput(print));
        exporterHTML.setExporterOutput(new SimpleHtmlExporterOutput(outputStream));
        exporterHTML.exportReport();
    }
}
