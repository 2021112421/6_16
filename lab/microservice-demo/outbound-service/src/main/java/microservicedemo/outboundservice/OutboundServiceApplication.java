package microservicedemo.outboundservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackages =
//        {"microservicedemo.outboundservice.controller"})
@SpringBootApplication
@MapperScan(basePackages="microservicedemo.outboundservice.mapper")
public class OutboundServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OutboundServiceApplication.class, args);
    }
}
