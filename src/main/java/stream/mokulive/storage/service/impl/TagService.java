package stream.mokulive.storage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stream.mokulive.storage.exception.DuplicateNameException;
import stream.mokulive.storage.mapper.TagMapper;
import stream.mokulive.storage.service.ITagService;
import stream.mokulive.storage.utils.IdGenerator;
import stream.mokulive.storage.vo.Tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TagService implements ITagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public void addTag(Tag tag) throws Exception {
        Map params = new HashMap();
        params.put("tagName",tag.getTagName());
        int count = tagMapper.checkName(params);
        if(count == 0) {
            tag.setTagId(IdGenerator.generate());
            tagMapper.addTag(tag);
        }else{
            throw new DuplicateNameException();
        }
    }

    @Override
    public void updateTag(Tag tag) throws Exception {
        tagMapper.updateTag(tag);
    }

    @Override
    public void deleteTag(String tagId) throws Exception {
        Map params = new HashMap();
        params.put("tagId",tagId);
        tagMapper.deleteTag(params);
    }

    @Override
    public Tag findTagById(String tagId) throws Exception {
        Tag tag = null;
        Map params = new HashMap();
        params.put("tagId",tagId);
        List<Tag> list = new ArrayList();
        list = tagMapper.findTagList(params);
        if(list.size()>0){
            tag = list.get(0);
        }
        return tag;
    }

    @Override
    public List<Tag> findTagList() throws Exception {
        Map params = new HashMap();
        return tagMapper.findTagList(params);
    }
}
