package br.com.damsete.arq.report;

import br.com.damsete.arq.report.impl.ReportImpl;
import br.com.damsete.arq.report.service.PersonService;
import net.sf.jasperreports.engine.JRException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.google.common.collect.Maps.newHashMap;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ReportIntegrationTest {

    private PersonService personService;
    private Report reportTXT;
    private Report report;

    @Before
    public void setUp() {
        this.reportTXT = new ReportImpl("PersonTXT.jrxml");
        this.report = new ReportImpl("Person.jrxml");

        this.personService = new PersonService();
    }

    @After
    public void setDown() {
        this.personService = null;
        this.report = null;
    }

    @Test
    public void should_generate_CSV() throws JRException {
        byte[] relbytes = this.report.export(this.personService.findAll(), newHashMap(), TypeReport.CSV);
        assertNotNull(relbytes);
        assertTrue(relbytes.length > 0);
    }

    @Test
    public void should_generate_HTML() throws JRException {
        byte[] relbytes = this.report.export(this.personService.findAll(), newHashMap(), TypeReport.HTML);
        assertNotNull(relbytes);
        assertTrue(relbytes.length > 0);
    }

    @Test
    public void should_generate_ODS() throws JRException {
        byte[] relbytes = this.report.export(this.personService.findAll(), newHashMap(), TypeReport.ODS);
        assertNotNull(relbytes);
        assertTrue(relbytes.length > 0);
    }

    @Test
    public void should_generate_ODT() throws JRException {
        byte[] relbytes = this.report.export(this.personService.findAll(), newHashMap(), TypeReport.ODT);
        assertNotNull(relbytes);
        assertTrue(relbytes.length > 0);
    }

    @Test
    public void should_generate_PDF() throws JRException {
        byte[] relbytes = this.report.export(this.personService.findAll(), newHashMap(), TypeReport.PDF);
        assertNotNull(relbytes);
        assertTrue(relbytes.length > 0);
    }

    @Test
    public void should_generate_RTF() throws JRException {
        byte[] relbytes = this.report.export(this.personService.findAll(), newHashMap(), TypeReport.RTF);
        assertNotNull(relbytes);
        assertTrue(relbytes.length > 0);
    }

    @Test
    public void should_generate_Text() throws JRException {
        byte[] relbytes = this.reportTXT.export(this.personService.findAll(), newHashMap(), TypeReport.TXT);
        assertNotNull(relbytes);
        assertTrue(relbytes.length > 0);
    }

    @Test
    public void should_generate_XLS() throws JRException {
        byte[] relbytes = this.report.export(this.personService.findAll(), newHashMap(), TypeReport.XLS);
        assertNotNull(relbytes);
        assertTrue(relbytes.length > 0);
    }
}
