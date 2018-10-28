import com.github.pagehelper.PageInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 功能描述:
 * Created by zhaodengke on 2018/10/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "file:web/WEB-INF/springmvc.xml"})
public class ControllerTest {

    // 如果想让IOC容器进行注入 必须在测试类上使用@WebAppConfiguration注解
    @Autowired
    private WebApplicationContext context;

    /**
     * 虚拟mvc请求，获取处理结果
     */
    private MockMvc mockMvc;

    @Before
    public void initMockMvc() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void testPage() throws Exception {
        // 模拟请求拿到返回值
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getEmployee");
        requestBuilder = requestBuilder.param("pageNum", "1");
        MvcResult pageNum = mockMvc.perform(requestBuilder).andReturn();

        // 请求成功后，会在请求域中会有pageInfo
        PageInfo pageInfo = (PageInfo) pageNum.getRequest().getAttribute("pageInfo");
        System.out.println(pageInfo.getList());
    }
}
