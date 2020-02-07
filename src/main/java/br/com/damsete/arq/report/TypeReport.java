package br.com.damsete.arq.report;

import br.com.damsete.arq.report.exporter.strategy.*;

public enum TypeReport {

    CSV(new JRCsvExporterStrategy()),

    HTML(new JRHtmlExporterStrategy()),

    ODS(new JROdsExporterStrategy()),

    ODT(new JROdtExporterStrategy()),

    PDF(new JRPdfExporterStrategy()),

    RTF(new JRRtfExporterStrategy()),

    TXT(new JRTextExporterStrategy()),

    XLS(new JRXlsExporterStrategy());

    private JRExporterStrategy exporter;

    TypeReport(JRExporterStrategy exporter) {
        this.exporter = exporter;
    }

    public JRExporterStrategy getExporter() {
        return exporter;
    }
}
