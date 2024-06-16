package microservicedemo.outboundservice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import microservicedemo.outboundservice.mapper.OutboundMapper;
import microservicedemo.outboundservice.po.Outbound;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@Slf4j
public class OutboundController {
    private final OutboundMapper outboundMapper;

    @PostMapping("/reduceStock")
    public String reduceStock(@RequestBody Outbound outbound) {
        outboundMapper.reduceStock(outbound);
        outboundMapper.updateStock(outbound.getProductId(), outbound.getQuantity());
        log.info("Reduced stock: {}", outbound);
        return "Stock reduced successfully";
    }
}
