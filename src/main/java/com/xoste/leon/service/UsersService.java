package com.xoste.leon.service;

import com.xoste.leon.pojo.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Leon
 */
@Service
public interface UsersService {
    /**
     * 查询所有
     * @return Users
     */
    List<Users> findUsersAll();

    /**
     * 通过id查询
     * @param id Integer
     * @return Users
     */
    Optional<Users> findUsersById(Integer id);

    /**
     * 通过page查询
     * @param pageable Pageable
     * @return Users
     */
    Page<Users> findUsersByPage(Pageable pageable);

    /**
     * 插入数据
     * @param users Users
     */
    void saveUsers(Users users);
}
