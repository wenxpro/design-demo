package com.example.designdemo.creation.fatory;

public class ExportFactoryImpl implements ExportFactory{

    private Exporter exporter = null;

    @Override
    public Exporter createExporter(ExporterVersion version) {
        switch (version){
            case version_03:
                exporter = new Exporter03();
                break;
            case version_07:
                exporter = new Exporter07();
                break;
            default:
        }
        return exporter;
    }
}
