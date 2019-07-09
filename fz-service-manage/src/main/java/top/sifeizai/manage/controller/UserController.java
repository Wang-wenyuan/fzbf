package top.sifeizai.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.sifeizai.api.management.UserControllerApi;
import top.sifeizai.framework.domain.management.User;
import top.sifeizai.framework.domain.management.request.QueryPageRequest;
import top.sifeizai.framework.domain.management.response.UserResult;
import top.sifeizai.manage.service.UserService;
import top.sifeizai.model.response.QueryResponseResult;
import top.sifeizai.model.response.ResponseResult;

/**
 * @Author: wwy
 * @Date: 2019-07-09 8:37
 */
@RestController
@RequestMapping("/user")
public class UserController implements UserControllerApi {
    @Autowired
    UserService userService;

    /**
     * 分页查询用户列表
     * @param page
     * @param size
     * @param queryPageRequest
     * @return
     */
    @Override
    @GetMapping("list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size") int size, QueryPageRequest queryPageRequest) {
        return userService.findList(page,size,queryPageRequest);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    @PostMapping("/add")
    public UserResult add(@RequestBody User user) {
        return userService.add(user);
    }

    @Override
    @GetMapping("/get/{id}")
    public User findById(@PathVariable("id") String id) {
        return userService.findById(id);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseResult delete(@PathVariable("id") String id) {
        return userService.delete(id);
    }

    @Override
    @PutMapping("/update/{id}")
    public UserResult update(@PathVariable("id") String id, @RequestBody User user) {
        return userService.update(id,user);
    }
}
