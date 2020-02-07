package br.com.damsete.arq.report.exporter.strategy;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import java.io.ByteArrayOutputStream;

public class JROdtExporterStrategy implements JRExporterStrategy {

    @Override
    public void exportReport(JasperPrint print, ByteArrayOutputStream outputStream) throws JRException {
        JROdtExporter exporterODT = new JROdtExporter();
        exporterODT.setExporterInput(new SimpleExporterInput(print));
        exporterODT.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
        exporterODT.exportReport();
    }
}
