package top.sifeizai.framework.domain.management;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: wwy
 * @Date: 2019-07-08 14:24
 */
@Data
@ToString
@Entity
@Table(name="tb_user")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class User implements Serializable {
    private static final long serialVersionUID = -916357210051689789L;
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "id",length = 32)
    private String id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "head_portrait_url")
    private String headPortraitUrl;
    @Column(name = "status")
    private String status;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "gen_time")
    private Date genTime;
    @Column(name = "login_time")
    private Date loginTime;
    @Column(name = "last_login_time")
    private Date lastLoginTime;
    @Column(name = "count")
    private Integer count;
    @Column(name = "activation_code")
    private String activationCode;
    @Column(name = "is_admin")
    private String isAdmin;
}
