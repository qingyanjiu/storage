package stream.mokulive.storage.service.impl;

import org.springframework.stereotype.Service;
import stream.mokulive.storage.service.IUserService;
import stream.mokulive.storage.vo.Auth0User;

@Service
public class UserServiceImpl implements IUserService {

    @Override
    public Auth0User checkUser(String userId) {
        return null;
    }

    @Override
    public boolean addUser(String userId) {
        return false;
    }
}
