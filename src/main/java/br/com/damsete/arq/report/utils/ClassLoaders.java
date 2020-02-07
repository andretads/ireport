package br.com.damsete.arq.report.utils;

public class ClassLoaders {

    private ClassLoaders() {
        super();
    }

    public static ClassLoader getClassLoaderForResource() {
        return Thread.currentThread().getContextClassLoader();
    }
}
