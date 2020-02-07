package br.com.damsete.arq.report;

import net.sf.jasperreports.engine.JRException;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

public interface Report extends Serializable {

    Object getSource() throws JRException;

    Object getReportObject();

    String getPath();

    void prepare(Collection<?> dataSource, Map<String, Object> param) throws JRException;

    byte[] export(Collection<?> dataSource, Map<String, Object> param, TypeReport type) throws JRException;

    byte[] export(TypeReport type) throws JRException;
}
