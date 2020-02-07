package br.com.damsete.arq.report.exporter.strategy;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.oasis.JROdsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOdsReportConfiguration;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import java.io.ByteArrayOutputStream;

public class JROdsExporterStrategy implements JRExporterStrategy {

    @Override
    public void exportReport(JasperPrint print, ByteArrayOutputStream outputStream) throws JRException {
        JROdsExporter exporterODS = new JROdsExporter();
        exporterODS.setExporterInput(new SimpleExporterInput(print));
        exporterODS.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
        SimpleOdsReportConfiguration configurationODS = new SimpleOdsReportConfiguration();
        configurationODS.setOnePagePerSheet(true);
        exporterODS.setConfiguration(configurationODS);
        exporterODS.exportReport();
    }
}
