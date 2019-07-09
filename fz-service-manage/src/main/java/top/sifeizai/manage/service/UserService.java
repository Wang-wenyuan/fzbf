package top.sifeizai.manage.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import top.sifeizai.exception.ExceptionCast;
import top.sifeizai.framework.domain.management.User;
import top.sifeizai.framework.domain.management.request.QueryPageRequest;
import top.sifeizai.framework.domain.management.response.UserResult;
import top.sifeizai.manage.dao.UserRepository;
import top.sifeizai.model.response.CommonCode;
import top.sifeizai.model.response.QueryResponseResult;
import top.sifeizai.model.response.QueryResult;
import top.sifeizai.model.response.ResponseResult;

import java.util.List;
import java.util.Optional;

/**
 * @Author: wwy
 * @Date: 2019-07-08 15:03
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    /**
     * 分页获取用户数据
     */
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest){
        if(queryPageRequest == null){
            queryPageRequest = new QueryPageRequest();
        }
        User user = new User();
        if(StringUtils.isNotEmpty(queryPageRequest.getNickname())){
            user.setNickname(queryPageRequest.getNickname());
        }
        if(queryPageRequest.getGenTime() !=null){
            user.setGenTime(queryPageRequest.getGenTime());
        }
        if(queryPageRequest.getIsAdmin() !=null){
            user.setIsAdmin(queryPageRequest.getIsAdmin());
        }
        //字段条件
        Example<? extends User> example = Example.of(user);
        if(page <= 0){
            page = 1;
        }
        page = page-1;
        if(size <= 0){
            size = 10;
        }
        //分页条件
        Pageable pageable = PageRequest.of(page,size);
        Page<? extends User> all = userRepository.findAll(example,pageable);
        List<? extends User> content = all.getContent();//结果集
        long totalElements = all.getTotalElements();//总记录数
        QueryResult queryResult = new QueryResult();
        queryResult.setList(content);
        queryResult.setTotal(totalElements);
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    public UserResult add(User user){
        if(user == null){
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        userRepository.save(user);
        UserResult userResult = new UserResult(CommonCode.SUCCESS,user);
        return userResult;
    }

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    public User findById(String id){
        if(StringUtils.isEmpty(id) || "null".equals(id)){
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.get();
        return user;
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    public ResponseResult delete(String id){
        if(StringUtils.isEmpty(id)){
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        //查询是否为空
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            userRepository.deleteById(id);
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);
    }

    /**
     * 根据id修改
     * @param id
     * @param user
     * @return
     */
    public UserResult update(String id,User user){
        //根据id查找信息
        User one = this.findById(id);
        //不为空进行数据更新
        if(one !=null){
            if(StringUtils.isNotEmpty(user.getEmail())){
                one.setEmail(user.getEmail());
            }
            if(StringUtils.isNotEmpty(user.getHeadPortraitUrl())){
                one.setHeadPortraitUrl(user.getHeadPortraitUrl());
            }
            if(StringUtils.isNotEmpty(user.getIsAdmin())){
                one.setIsAdmin(user.getIsAdmin());
            }
            if(StringUtils.isNotEmpty(user.getNickname())){
                one.setNickname(user.getNickname());
            }
            if(StringUtils.isNotEmpty(user.getPhone())){
                one.setPhone(user.getPhone());
            }
            if(StringUtils.isNotEmpty(user.getUsername())){
                one.setUsername(user.getUsername());
            }
            if(StringUtils.isNotEmpty(user.getPassword())){
                one.setPassword(user.getPassword());
            }
            if(StringUtils.isNotEmpty(user.getStatus())){
                one.setPassword(user.getStatus());
            }
            userRepository.save(one);
            return new UserResult(CommonCode.SUCCESS,one);
        }
        return new UserResult(CommonCode.FAIL,null);

    }
}
