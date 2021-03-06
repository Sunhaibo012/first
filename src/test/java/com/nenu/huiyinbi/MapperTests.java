package com.nenu.huiyinbi;

import com.nenu.huiyinbi.dao.DiscussPostMapper;
import com.nenu.huiyinbi.dao.UserMapper;
import com.nenu.huiyinbi.entity.DiscussPost;
import com.nenu.huiyinbi.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @auther hiber
 * @create 2020/7/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = HuiyinbiApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(101);
        System.out.println(user);

        user = userMapper.selectByName("liubei");
        System.out.println(user);

        user = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("孙海波");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("1234567@qq.com");
        user.setHeaderUrl("http://images.nowcoder.com/head/100t.png");
        user.setCreateTime(new Date());

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void testUpdateUser(){
        int rows = userMapper.updateStatus(150,1);
        System.out.println(rows);

        rows = userMapper.updateHeader(150,"http://images.nowcoder.com/head/102.png");
        System.out.println(rows);

        rows = userMapper.updatePassword(150,"asdasdasd");
        System.out.println(rows);

    }

    @Test
    public void testSelectPosts(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0,0,10);
        for (DiscussPost post:list){
            System.out.println(post);
        }

        int rows = discussPostMapper.selectDiscussPostsRows(0);
        System.out.println(rows);
    }
}
