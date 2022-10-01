package com.example.designdemo.creation.fatory;

public interface ExportFactory {
    Exporter createExporter(ExporterVersion version);
}
