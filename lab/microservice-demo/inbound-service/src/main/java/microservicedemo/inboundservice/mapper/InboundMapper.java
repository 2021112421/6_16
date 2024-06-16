package microservicedemo.inboundservice.mapper;

import microservicedemo.inboundservice.po.Inbound;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface InboundMapper {
    @Insert("INSERT INTO inbound(product_id, quantity, timestamp) VALUES(#{productId}, #{quantity}, now())")
    void addStock(Inbound inbound);

    @Update("UPDATE product SET stock = stock + #{quantity} WHERE id = #{productId}")
    void updateStock(@Param("productId") Long productId, @Param("quantity") Long quantity);
}
