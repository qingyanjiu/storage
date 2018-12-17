package stream.mokulive.storage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import stream.mokulive.storage.vo.User;

@Repository
@Mapper
public interface UserMapper {

    User findByName(String username);

}
