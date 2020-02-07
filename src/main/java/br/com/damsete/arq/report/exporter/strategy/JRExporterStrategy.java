package br.com.damsete.arq.report.exporter.strategy;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

import java.io.ByteArrayOutputStream;

public interface JRExporterStrategy {

    void exportReport(JasperPrint print, ByteArrayOutputStream outputStream) throws JRException;
}
