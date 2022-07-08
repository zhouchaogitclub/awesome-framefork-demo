package zc.com.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author yeyu
 * @since 2022/7/8 14:19
 */
@Data
public class Order {
    private Long orderId;
    private Long userId;
    private BigDecimal totalPrice;
    private byte state;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
