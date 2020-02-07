package br.com.damsete.arq.report.impl;

import br.com.damsete.arq.report.Report;
import br.com.damsete.arq.report.TypeReport;
import br.com.damsete.arq.report.exporter.strategy.JRExporterStrategy;
import br.com.damsete.arq.report.utils.ClassLoaders;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;

public class ReportImpl implements Report {

    private static final String NON_COMPILED_REPORT_EXTENSION = ".jrxml";
    private static final String COMPILED_REPORT_EXTENSION = ".jasper";
    private static final String DEFAULT_PATH = "reports/";

    private JasperReport jasper = null;
    private JasperPrint print = null;
    private String path;

    public ReportImpl(String fileName) {
        this.path = DEFAULT_PATH + fileName;
    }

    @Override
    public Object getSource() throws JRException {
        loadReport();
        return this.jasper;
    }

    @Override
    public Object getReportObject() {
        return print;
    }

    @Override
    public String getPath() {
        return this.path;
    }

    @Override
    public void prepare(Collection<?> dataSource, Map<String, Object> param) throws JRException {
        loadReport();

        this.print = JasperFillManager.fillReport(this.jasper, param, new JRBeanCollectionDataSource(dataSource));
    }

    @Override
    public byte[] export(Collection<?> dataSource, Map<String, Object> param, TypeReport type) throws JRException {
        prepare(dataSource, param);
        return export(type);
    }

    @Override
    public byte[] export(TypeReport type) throws JRException {
        if (!isFilled()) {
            throw new IllegalArgumentException("It is necessary to fill out the reports first. Use the fill method.");
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        JRExporterStrategy strategy = type.getExporter();
        strategy.exportReport(print, outputStream);

        return outputStream.toByteArray();
    }

    private InputStream getReportStream(String relativePath) {
        ClassLoader classLoader = ClassLoaders.getClassLoaderForResource();
        if (classLoader == null) {
            throw new IllegalArgumentException(String.format("ClassLoader to %s not found.", relativePath));
        }

        InputStream reportStream = classLoader.getResourceAsStream(relativePath);
        if (reportStream == null) {
            throw new IllegalArgumentException(String.format("File %s not found.", relativePath));
        }

        return reportStream;
    }

    private void loadJRXML(String relativePath) throws JRException {
        this.jasper = JasperCompileManager.compileReport(getReportStream(relativePath));
    }

    private void loadJasper(String relativePath) throws JRException {
        this.jasper = (JasperReport) JRLoader.loadObject(getReportStream(relativePath));
    }

    private void loadReport() throws JRException {
        if (this.path.endsWith(COMPILED_REPORT_EXTENSION)) {
            loadJasper(this.path);
        } else if (this.path.endsWith(NON_COMPILED_REPORT_EXTENSION)) {
            loadJRXML(this.path);
        } else {
            throw new IllegalArgumentException(String.format("Enter the file with a valid extension: jrxml or jasper. File %s is invalid.", this.path));
        }
    }

    private boolean isFilled() {
        return print != null;
    }
}
