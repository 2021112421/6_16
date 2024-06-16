package microservicedemo.outboundservice.mapper;

import microservicedemo.outboundservice.po.Outbound;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface OutboundMapper {
    @Insert("INSERT INTO outbound(product_id, quantity, timestamp) VALUES(#{productId}, #{quantity}, now())")
    void reduceStock(Outbound outbound);

    @Update("UPDATE product SET stock = stock - #{quantity} WHERE id = #{productId} AND stock >= #{quantity}")
    void updateStock(@Param("productId") Long productId, @Param("quantity") Long quantity);
}
