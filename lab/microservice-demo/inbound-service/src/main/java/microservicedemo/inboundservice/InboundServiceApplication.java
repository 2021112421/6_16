package microservicedemo.inboundservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackages =
//        {"microservicedemo.inboundservice.controller"})
@SpringBootApplication
@MapperScan(basePackages="microservicedemo.inboundservice.mapper")
public class InboundServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(InboundServiceApplication.class, args);
    }
}
