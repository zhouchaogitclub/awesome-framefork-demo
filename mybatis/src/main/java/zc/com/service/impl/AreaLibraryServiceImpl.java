package zc.com.service.impl;

import zc.com.entity.AreaLibrary;
import zc.com.dao.AreaLibraryDao;
import zc.com.service.AreaLibraryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 地址库表(AreaLibrary)表服务实现类
 *
 * @author yeyu
 * @since 2021-12-24 17:57:13
 */
@Service("areaLibraryService")
public class AreaLibraryServiceImpl implements AreaLibraryService {
    @Resource
    private AreaLibraryDao areaLibraryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param code 主键
     * @return 实例对象
     */
    @Override
    public AreaLibrary queryById(Integer code) {
        return this.areaLibraryDao.queryById(code);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<AreaLibrary> queryAllByLimit(int offset, int limit) {
        return this.areaLibraryDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param areaLibrary 实例对象
     * @return 实例对象
     */
    @Override
    public AreaLibrary insert(AreaLibrary areaLibrary) {
        this.areaLibraryDao.insert(areaLibrary);
        return areaLibrary;
    }

    /**
     * 修改数据
     *
     * @param areaLibrary 实例对象
     * @return 实例对象
     */
    @Override
    public AreaLibrary update(AreaLibrary areaLibrary) {
        this.areaLibraryDao.update(areaLibrary);
        return this.queryById(areaLibrary.getCode());
    }

    /**
     * 通过主键删除数据
     *
     * @param code 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer code) {
        return this.areaLibraryDao.deleteById(code) > 0;
    }
}