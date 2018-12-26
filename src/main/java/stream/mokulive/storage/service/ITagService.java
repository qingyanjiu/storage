package stream.mokulive.storage.service;

import stream.mokulive.storage.vo.Building;
import stream.mokulive.storage.vo.Tag;

import java.util.List;

public interface ITagService {

    void addTag(Tag tag) throws Exception;

    void updateTag(Tag tag) throws Exception;

    void deleteTag(String tagId) throws Exception;

    Tag findTagById(String tagId) throws Exception;

    List<Tag> findTagList() throws Exception;
}
