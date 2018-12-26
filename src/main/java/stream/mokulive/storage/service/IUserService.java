package stream.mokulive.storage.service;

import stream.mokulive.storage.vo.Auth0User;

public interface IUserService {

    /**
     * 用用户id请求用户信息，如果存在，返回Auth0User对象，否则返回null
     * @param userId
     * @return
     */
    Auth0User checkUser(String userId) throws Exception;

    /**
     * 添加用户信息，添加成功返回true
     * @param user
     * @return
     */
    void addUser(Auth0User user) throws Exception;


}
