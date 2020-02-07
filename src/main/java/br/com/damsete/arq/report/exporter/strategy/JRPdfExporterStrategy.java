package br.com.damsete.arq.report.exporter.strategy;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import java.io.ByteArrayOutputStream;

public class JRPdfExporterStrategy implements JRExporterStrategy {

    @Override
    public void exportReport(JasperPrint print, ByteArrayOutputStream outputStream) throws JRException {
        JRPdfExporter exporterPDF = new JRPdfExporter();
        exporterPDF.setExporterInput(new SimpleExporterInput(print));
        exporterPDF.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
        exporterPDF.exportReport();
    }
}
