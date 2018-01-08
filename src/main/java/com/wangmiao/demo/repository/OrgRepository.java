package com.wangmiao.demo.repository;

import com.wangmiao.demo.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrgRepository extends JpaRepository<Organization,Long> {

}
