package zc.com.controller;

import zc.com.entity.AreaLibrary;
import zc.com.service.AreaLibraryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 地址库表(AreaLibrary)表控制层
 *
 * @author yeyu
 * @since 2021-12-24 17:57:14
 */
@RestController
@RequestMapping("areaLibrary")
public class AreaLibraryController {
    /**
     * 服务对象
     */
    @Resource
    private AreaLibraryService areaLibraryService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public AreaLibrary selectOne(Integer id) {
        return this.areaLibraryService.queryById(id);
    }

}