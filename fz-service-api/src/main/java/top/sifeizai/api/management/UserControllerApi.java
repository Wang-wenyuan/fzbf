package top.sifeizai.api.management;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import top.sifeizai.framework.domain.management.User;
import top.sifeizai.framework.domain.management.request.QueryPageRequest;
import top.sifeizai.framework.domain.management.response.UserResult;
import top.sifeizai.model.response.QueryResponseResult;
import top.sifeizai.model.response.ResponseResult;

/**
 * 用户管理接口
 * @Author: wwy
 * @Date: 2019-07-02 17:51
 */
@Api(value="用户页面管理接口",description = "用户页面管理接口，提供页面的增、删、改、查")
public interface UserControllerApi {
    /**
     * 分页查询用户信息
     * @param page
     * @param size
     * @param queryPageRequest
     * @return
     */
    @ApiOperation("分页查询用户管理页面列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value = "页码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录数",required=true,paramType="path",dataType="int")
    })
    QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);

    /**
     * 添加用户
     * @param user
     * @return
     */
    @ApiOperation("添加用户")
    UserResult add(User user);

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    @ApiOperation("根据id查找用户")
    User findById(String id);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @ApiOperation("根据id删除用户")
    ResponseResult delete(String id);

    /**
     * 根据id修改用户
     * @param id
     * @param user
     * @return
     */
    @ApiOperation("根据id修改用户")
    UserResult update(String id,User user);


}
