package br.com.damsete.arq.report.exporter.strategy;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;

import java.io.ByteArrayOutputStream;

public class JRRtfExporterStrategy implements JRExporterStrategy {

    @Override
    public void exportReport(JasperPrint print, ByteArrayOutputStream outputStream) throws JRException {
        JRRtfExporter exporterRTF = new JRRtfExporter();
        exporterRTF.setExporterInput(new SimpleExporterInput(print));
        exporterRTF.setExporterOutput(new SimpleWriterExporterOutput(outputStream));
        exporterRTF.exportReport();
    }
}
