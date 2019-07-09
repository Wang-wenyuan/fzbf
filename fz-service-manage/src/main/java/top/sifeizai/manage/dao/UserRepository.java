package top.sifeizai.manage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.sifeizai.framework.domain.management.User;

/**
 * @Author: wwy
 * @Date: 2019-07-08 14:19
 */
public interface UserRepository extends JpaRepository<User,String> {
}
