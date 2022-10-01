package com.example.designdemo;

import com.example.designdemo.creation.builder.Student;
import com.example.designdemo.creation.fatory.ExportFactory;
import com.example.designdemo.creation.fatory.ExportFactoryImpl;
import com.example.designdemo.creation.fatory.Exporter;
import com.example.designdemo.creation.fatory.ExporterVersion;
import com.example.designdemo.creation.instance.CacheTimerManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class CreationTests {

    @Test
    void factoryTest() {
        ExportFactory factory = new ExportFactoryImpl();
        //03 exporter
        Exporter exporter = factory.createExporter(ExporterVersion.version_03);
        exporter.out();
        //07 exporter
        Exporter exporter1 = factory.createExporter(ExporterVersion.version_07);
        exporter1.out();
    }

    @Test
    void builderTest(){
       Student student = new Student.Builder()
               .id(1)
               .age(12)
               .name("张三")
               .build();
       log.info("student:{}",student);
    }

    @Test
    void instanceTest(){
        final String key = "test";
        CacheTimerManager manager = CacheTimerManager.getInstance();
        manager.addCache(key);

        log.info("key : {}, value : {}",key,manager.get(key));
        log.info("key : {}, isCache : {}",key,manager.isCache(key));
        log.info("key : {}, remove : {}",key,manager.remove(key));
        log.info("key : {}, value : {}",key,manager.get(key));
        log.info("key : {}, isCache : {}",key,manager.isCache(key));
    }

}
