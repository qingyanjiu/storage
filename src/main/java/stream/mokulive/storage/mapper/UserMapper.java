package stream.mokulive.storage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import stream.mokulive.storage.vo.Auth0User;

@Repository
@Mapper
public interface UserMapper {

    Auth0User findById(String userId);

}
