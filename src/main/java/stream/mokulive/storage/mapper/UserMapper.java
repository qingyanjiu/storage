package stream.mokulive.storage.mapper;

import org.springframework.stereotype.Repository;
import stream.mokulive.storage.vo.Auth0User;

@Repository
public interface UserMapper {

    Auth0User findById(String userId);

}
