package top.sifeizai.framework.domain.management.user.request;

import lombok.Data;

import java.util.Date;

/**
 * @Author: wwy
 * @Date: 2019-07-08 9:41
 */
@Data
public class QueryPageRequest {
    private String username;
    private String nickname;
    private Date genTime;
    private String isAdmin;
    private String status;
}
