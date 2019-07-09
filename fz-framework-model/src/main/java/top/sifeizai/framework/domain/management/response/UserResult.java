package top.sifeizai.framework.domain.management.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import top.sifeizai.framework.domain.management.User;
import top.sifeizai.model.response.ResponseResult;
import top.sifeizai.model.response.ResultCode;

/**
 * @Author: wwy
 * @Date: 2019-07-09 10:09
 */
@Data
@NoArgsConstructor
public class UserResult extends ResponseResult {
    User user;
    public UserResult(ResultCode resultCode, User user){
        super(resultCode);
        this.user = user;
    }
}
