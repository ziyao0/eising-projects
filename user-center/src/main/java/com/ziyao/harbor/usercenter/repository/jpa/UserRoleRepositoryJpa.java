package com.ziyao.harbor.usercenter.repository.jpa;

import com.ziyao.harbor.usercenter.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author ziyao
 */
@Repository
public interface UserRoleRepositoryJpa extends JpaRepository<UserRole, Long> {


    @Query("select role from user_role where userId=:userId")
    Set<String> findByUserId(Long userId);

}
