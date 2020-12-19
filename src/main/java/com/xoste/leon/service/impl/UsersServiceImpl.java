package com.xoste.leon.service.impl;

import com.xoste.leon.dao.UsersRepository;
import com.xoste.leon.pojo.Users;
import com.xoste.leon.service.UsersService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author Leon
 */
@Service
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersRepository usersRepository;
    /**
     * 查询所有
     *
     * @return Users
     */
    @Override
    @Cacheable(value = "Users")
    public List<Users> findUsersAll() {
        return usersRepository.findAll();
    }

    /**
     * 通过id查询
     *
     * @param id Integer
     * @return Users
     * @Cacheable: 对当前的查询对象做缓存处理
     */
    @Override
    @Cacheable(value = "Users")
    public Optional<Users> findUsersById(Integer id) {
        return usersRepository.findById(id);
    }

    /**
     * 通过page查询
     *
     * @param pageable Pageable
     * @return Users
     */
    @Override
    @Cacheable(value = "Users", key = "#pageable.pageSize")
    public Page<Users> findUsersByPage(Pageable pageable) {
        return usersRepository.findAll(pageable);
    }

    /**
     * 插入数据
     * @CacheEvict: 清除缓存中一Users缓存策略缓存的对象
     */
    @Override
    @CacheEvict(value = "Users", allEntries = true)
    public void saveUsers(Users users) {
        this.usersRepository.save(users);
    }
}
