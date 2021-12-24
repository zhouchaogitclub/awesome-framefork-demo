package zc.com.dao;

import zc.com.entity.AreaLibrary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 地址库表(AreaLibrary)表数据库访问层
 *
 * @author yeyu
 * @since 2021-12-24 17:57:11
 */
public interface AreaLibraryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param code 主键
     * @return 实例对象
     */
    AreaLibrary queryById(Integer code);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AreaLibrary> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param areaLibrary 实例对象
     * @return 对象列表
     */
    List<AreaLibrary> queryAll(AreaLibrary areaLibrary);

    /**
     * 新增数据
     *
     * @param areaLibrary 实例对象
     * @return 影响行数
     */
    int insert(AreaLibrary areaLibrary);

    /**
     * 修改数据
     *
     * @param areaLibrary 实例对象
     * @return 影响行数
     */
    int update(AreaLibrary areaLibrary);

    /**
     * 通过主键删除数据
     *
     * @param code 主键
     * @return 影响行数
     */
    int deleteById(Integer code);

}