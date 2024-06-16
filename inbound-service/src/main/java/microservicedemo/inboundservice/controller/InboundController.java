package microservicedemo.inboundservice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import microservicedemo.inboundservice.mapper.InboundMapper;
import microservicedemo.inboundservice.po.Inbound;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@Slf4j
public class InboundController {
    private final InboundMapper inboundMapper;

    @PostMapping("/addStock")
    public String addStock(@RequestBody Inbound inbound) {
        try {
            inboundMapper.addStock(inbound);
            inboundMapper.updateStock(inbound.getProductId(), inbound.getQuantity());
            log.info("Added stock: {}", inbound);
            return "Stock added successfully";
        } catch (Exception e) {
            log.error("Error adding stock", e);
            return "Error adding stock: " + e.getMessage();
        }
    }
}
