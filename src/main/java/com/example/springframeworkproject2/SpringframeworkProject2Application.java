package com.example.springframeworkproject2;

import com.example.springframeworkproject2.domain.DataParser;
import com.example.springframeworkproject2.domain.FileLoad;
import com.example.springframeworkproject2.repository.ChargeRepository;
import com.example.springframeworkproject2.repository.ChargeRepositoryImpl;
import com.example.springframeworkproject2.result.ResultReport;
import com.example.springframeworkproject2.result.ResultReportImpl;
import com.example.springframeworkproject2.service.WaterUsageChargeService;
import com.example.springframeworkproject2.service.WaterUsageChargeServiceImpl;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.List;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SpringframeworkProject2Application {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        ChargeRepositoryImpl bean = ac.getBean(ChargeRepositoryImpl.class);
        bean.loadData("data/Tariff_20220331.csv");
        List<FileLoad> calculate = ac.getBean(WaterUsageChargeServiceImpl.class).calculate(1000);
        List<FileLoad> print = ac.getBean(ResultReportImpl.class).print(calculate);


        System.out.println(print);

        ac.getBean(ChargeRepository.class).loadData("/Users/jangtaewon/Downloads/springframework-project-2-1/src/main/resources/data/Tariff_20220331.json");
        List<FileLoad> calculate1 = ac.getBean(WaterUsageChargeService.class).calculate(2000);
        System.out.println(ac.getBean(ResultReport.class).print(calculate1));









    }
}
