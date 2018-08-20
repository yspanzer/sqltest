package com.sqltest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sqltest.entity.nanhuadata.TFactory;
import com.sqltest.mapper.nanhuadata.TFactoryMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PageTest {

    @Autowired
    private TFactoryMapper m_TFactoryMapper;

    @Test
    public void getPageInfo() throws Exception {

        //获取第1页，10条内容，默认查询总数count
        PageHelper.startPage(3, 10);
        List<TFactory> _FactoryList = m_TFactoryMapper.selectAll();

        //用PageInfo对结果进行包装
        PageInfo page = new PageInfo(_FactoryList);

        System.out.println("-------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("分页结果：每页10条记录");
        for (TFactory factory : _FactoryList) {
            System.out.println("企业编码："+factory.getCode() + "；  企业名称："+factory.getName());
        }
        System.out.println("-------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------");

        System.out.println("01、当前页数："+page.getPageNum());
        System.out.println("02、每页记录数："+page.getPageSize());
        System.out.println("03、开始行数："+page.getStartRow());
        System.out.println("04、结束行数："+page.getEndRow());
        System.out.println("05、总记录数："+page.getTotal());
        System.out.println("06、总页数："+page.getPages());
        System.out.println("07、getFirstPage："+page.getFirstPage());
        System.out.println("08、getLastPage："+page.getLastPage());
        System.out.println("09、是否在第一页："+page.isIsFirstPage());
        System.out.println("10、是否在最后一页："+page.isIsLastPage());
        System.out.println("11、是否有上一页："+page.isHasPreviousPage());
        System.out.println("12、是否有下一页："+page.isHasNextPage());

        //测试PageInfo全部属性
        //PageInfo包含了非常全面的分页属性
/*        assertEquals(1, page.getPageNum());
        assertEquals(10, page.getPageSize());
        assertEquals(1, page.getStartRow());
        assertEquals(10, page.getEndRow());
        assertEquals(183, page.getTotal());
        assertEquals(19, page.getPages());
        assertEquals(1, page.getFirstPage());
        assertEquals(8, page.getLastPage());
        assertEquals(true, page.isIsFirstPage());
        assertEquals(false, page.isIsLastPage());
        assertEquals(false, page.isHasPreviousPage());
        assertEquals(true, page.isHasNextPage());
        */


    }


}
