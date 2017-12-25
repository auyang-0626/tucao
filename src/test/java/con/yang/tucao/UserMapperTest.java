package con.yang.tucao;

import com.yang.tucao.Application;
import com.yang.tucao.entity.User;
import com.yang.tucao.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= Application.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindOne() throws Exception {
        User user = userMapper.getOne("wxid00001");
        Assert.assertEquals(user.getWxid(),"wxid00001");
    }
    @Test
    public void testInsert(){
        userMapper.insert(new User("wxid00001","yang",1d,"标题",new Date()));
    }
}
