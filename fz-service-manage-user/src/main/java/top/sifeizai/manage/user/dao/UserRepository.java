package top.sifeizai.manage.user.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import top.sifeizai.framework.domain.management.user.User;

/**
 * @Author: wwy
 * @Date: 2019-07-08 14:19
 */
public interface UserRepository extends JpaRepository<User,String> {
}
