package br.com.damsete.arq.report.utils;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ClassLoadersTest {

    @Test
    public void should_get_class_loader() {
        ClassLoader classLoader = ClassLoaders.getClassLoaderForResource();

        assertNotNull(classLoader);
    }
}