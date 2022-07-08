package zc.com.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import zc.com.entity.Order;

import java.util.List;

/**
 * @author yeyu
 * @since 2022/7/8 14:13
 */
@Mapper
public interface OrderMapper {
    /**
     * 插入
     *
     * @param order
     */
    void insert(Order order);

    /**
     * 批量查询
     *
     * @param idList
     * @return
     */
    List<Order> selectListByIds(@Param("idList") List<Long> idList);
}
