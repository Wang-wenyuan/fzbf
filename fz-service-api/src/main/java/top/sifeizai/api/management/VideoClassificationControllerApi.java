package top.sifeizai.api.management;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import top.sifeizai.framework.domain.management.user.request.QueryPageRequest;
import top.sifeizai.model.response.QueryResponseResult;

/**
 * @Author: wwy
 * @Date: 2019-09-03 10:44
 */
@Api(value="视频分类管理接口",description = "视频分类管理接口，提供页面的增、删、改、查")
public interface VideoClassificationControllerApi {
    /**
     * 分页查询视频分类
     * @param page
     * @param size
     * @param queryPageRequest
     * @return
     */
    @ApiOperation("分页查询视频分类管理页面列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value = "页码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录数",required=true,paramType="path",dataType="int")
    })
    QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);
}
