package stream.mokulive.storage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stream.mokulive.storage.mapper.UserMapper;
import stream.mokulive.storage.service.IUserService;
import stream.mokulive.storage.vo.Auth0User;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Auth0User checkUser(String userId) throws Exception {
        return userMapper.findById(userId);
    }

    @Override
    public void addUser(Auth0User user) throws Exception {
        userMapper.addUser(user);
    }
}
