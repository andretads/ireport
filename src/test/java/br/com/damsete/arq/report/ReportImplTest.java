package br.com.damsete.arq.report;

import br.com.damsete.arq.report.impl.ReportImpl;
import br.com.damsete.arq.report.service.PersonService;
import net.sf.jasperreports.engine.JRException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;

import static com.google.common.collect.Maps.newHashMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore({"com.sun.org.apache.xerces.*", "javax.xml.*", "org.xml.*", "org.w3c.dom.*"})
public class ReportImplTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void should_generate_source() throws JRException {
        Report reportJrxml = new ReportImpl("Person.jrxml");
        Object sourceJrxml = reportJrxml.getSource();

        Report reportJasper = new ReportImpl("Person.jasper");
        Object sourceJasper = reportJasper.getSource();

        assertNotNull(sourceJrxml);
        assertNotNull(sourceJasper);
    }

    @Test
    public void should_get_path() {
        Report report = new ReportImpl("Person.jrxml");
        String path = report.getPath();

        assertNotNull(path);
        assertEquals(path, "reports/Person.jrxml");
    }

    @Test
    public void should_get_report_object() throws JRException {
        Report report = new ReportImpl("Person.jrxml");

        report.prepare(new PersonService().findAll(), newHashMap());

        Object reportObject = report.getReportObject();

        assertNotNull(reportObject);
    }

    @Test
    public void should_deny_generate_source_with_invalid_path() throws JRException {
        this.exception.expect(IllegalArgumentException.class);

        Report report = new ReportImpl("readme.txt");
        report.getSource();
    }

    @Test
    public void should_deny_export_not_filled() throws JRException {
        this.exception.expect(IllegalArgumentException.class);

        Report report = new ReportImpl("Person.jrxml");
        report.export(TypeReport.PDF);
    }
}
