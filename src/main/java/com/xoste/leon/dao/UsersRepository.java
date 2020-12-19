package com.xoste.leon.dao;

import com.xoste.leon.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UsersRepository
 * @author Leon
 */
public interface UsersRepository extends JpaRepository<Users, Integer> {
}
