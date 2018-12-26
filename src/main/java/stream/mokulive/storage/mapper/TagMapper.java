package stream.mokulive.storage.mapper;

import org.springframework.stereotype.Repository;
import stream.mokulive.storage.vo.Tag;

import java.util.List;
import java.util.Map;

@Repository
public interface TagMapper {

    int checkName(Map params);

    void addTag(Tag tag);

    void updateTag(Tag tag);

    void deleteTag(Map params);

    List<Tag> findTagList(Map params);
}
