package com.xoste.leon.test;

import com.xoste.leon.Application;
import com.xoste.leon.pojo.Users;
import com.xoste.leon.service.impl.UsersServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Leon
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UsersServiceImplTest {
    @Autowired
    private UsersServiceImpl usersServiceImpl;
    @Test
    public void findUsersById() {
        // 第一次查询
        System.out.println(this.usersServiceImpl.findUsersById(2));
        // 第二次查询
        System.out.println(this.usersServiceImpl.findUsersById(2));
    }

    @Test
    public void  findUsersByPage() {
        Pageable pageable = PageRequest.of(0, 2);
        // 第一次分页
        System.out.println(this.usersServiceImpl.findUsersByPage(pageable).getTotalElements());
        // 第二次分页
        System.out.println(this.usersServiceImpl.findUsersByPage(pageable).getTotalElements());
        pageable = PageRequest.of(1,2);
        // 第三次分页
        System.out.println(this.usersServiceImpl.findUsersByPage(pageable).getTotalElements());
    }

    @Test
    public void findUsersAll() {
        // 第一次查询
        System.out.println(this.usersServiceImpl.findUsersAll().size());
        Users users = new Users();
        users.setUsername("齐齐");
        users.setPassword("12343er");
        this.usersServiceImpl.saveUsers(users);
        // 第二次查询
        System.out.println(this.usersServiceImpl.findUsersAll().size());
    }
}
