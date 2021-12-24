package zc.com.service;

import zc.com.entity.AreaLibrary;
import java.util.List;

/**
 * 地址库表(AreaLibrary)表服务接口
 *
 * @author yeyu
 * @since 2021-12-24 17:57:12
 */
public interface AreaLibraryService {

    /**
     * 通过ID查询单条数据
     *
     * @param code 主键
     * @return 实例对象
     */
    AreaLibrary queryById(Integer code);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AreaLibrary> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param areaLibrary 实例对象
     * @return 实例对象
     */
    AreaLibrary insert(AreaLibrary areaLibrary);

    /**
     * 修改数据
     *
     * @param areaLibrary 实例对象
     * @return 实例对象
     */
    AreaLibrary update(AreaLibrary areaLibrary);

    /**
     * 通过主键删除数据
     *
     * @param code 主键
     * @return 是否成功
     */
    boolean deleteById(Integer code);

}