package com.wangmiao.demo.repository;

import com.wangmiao.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/9/10.
 */
public interface UserRepository extends JpaRepository<User,Long> {
}

