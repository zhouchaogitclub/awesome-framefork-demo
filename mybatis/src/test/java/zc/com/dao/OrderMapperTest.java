package zc.com.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zc.com.entity.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @author yeyu
 * @since 2022/7/8 14:22
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderMapperTest {
    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void insert() {
        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setUserId(1L);
            order.setState((byte) 0);
            order.setTotalPrice(new BigDecimal((i + 1) * 5));
            order.setCreateTime(LocalDateTime.now());
            order.setUpdateTime(order.getCreateTime());
            this.orderMapper.insert(order);
        }
    }

    @Test
    public void selectListByIds() {
        List<Long> idList = Arrays.asList(593141944457101312L, 593141944922669057L);
        List<Order> orderList = this.orderMapper.selectListByIds(idList);
        System.out.println(orderList);
    }
}