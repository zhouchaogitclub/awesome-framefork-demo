package zc.com.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import zc.com.dao.AreaLibraryDao;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author yeyu
 * @since 2021/12/24 8:47 PM
 */
@SpringBootTest
public class AreaLibraryServiceTest {
    @Resource
    private AreaLibraryDao areaLibraryDao;
    @Value("${name}")
    private String name;

    @Test
    public void queryById() {
    }

    @Test
    public void queryAllByLimit() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void update() {
    }

    @Test
    public void deleteById() {
    }
}