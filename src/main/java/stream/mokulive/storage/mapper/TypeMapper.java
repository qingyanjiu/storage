package stream.mokulive.storage.mapper;

import org.springframework.stereotype.Repository;
import stream.mokulive.storage.vo.Type;

import java.util.List;
import java.util.Map;

@Repository
public interface TypeMapper {

    int checkName(Map params);

    void addType(Type type);

    void updateType(Type type);

    void deleteType(Map params);

    List<Type> findTypeList(Map params);
}
