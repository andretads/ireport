package br.com.damsete.arq.report.exporter.strategy;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;

import java.io.ByteArrayOutputStream;

public class JRXlsExporterStrategy implements JRExporterStrategy {

    @Override
    public void exportReport(JasperPrint print, ByteArrayOutputStream outputStream) throws JRException {
        JRXlsExporter exporterXLS = new JRXlsExporter();
        exporterXLS.setExporterInput(new SimpleExporterInput(print));
        exporterXLS.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
        SimpleXlsReportConfiguration configurationXLS = new SimpleXlsReportConfiguration();
        configurationXLS.setOnePagePerSheet(true);
        configurationXLS.setRemoveEmptySpaceBetweenRows(true);
        configurationXLS.setRemoveEmptySpaceBetweenColumns(true);
        configurationXLS.setWhitePageBackground(false);
        configurationXLS.setDetectCellType(true);
        configurationXLS.setIgnoreGraphics(false);
        configurationXLS.setFreezeRow(3);
        exporterXLS.setConfiguration(configurationXLS);
        exporterXLS.exportReport();
    }
}
