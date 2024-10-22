package cn.edu.zucc.jpa.qa.repository;

import cn.edu.zucc.jpa.qa.entity.MstUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-04-07 23:25
 */
public interface UserRepository extends JpaRepository<MstUserEntity, Integer> {
}
