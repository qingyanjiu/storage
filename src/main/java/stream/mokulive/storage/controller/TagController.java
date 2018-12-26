package stream.mokulive.storage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import stream.mokulive.storage.exception.DuplicateNameException;
import stream.mokulive.storage.service.ITagService;
import stream.mokulive.storage.utils.Utils;
import stream.mokulive.storage.vo.Tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/tag")
@Controller
public class TagController {

    @Autowired
    private ITagService tagService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Map add(Tag tag) {
    	Map result = new HashMap();
        try {
            tagService.addTag(tag);
            Utils.tagResult(result,true);
        } catch (Exception e) {
            Utils.tagResult(result,false);
            if(e instanceof DuplicateNameException){
                result.put("msg","Duplicate name");
            }
        }
        return result;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Map update(Tag tag) {
    	Map result = new HashMap();
        try {
            tagService.updateTag(tag);
            Utils.tagResult(result,true);
        } catch (Exception e) {
            Utils.tagResult(result,false);
        }
        return result;
    }

    @RequestMapping(value = "delete/{tagId}", method = RequestMethod.POST)
    @ResponseBody
    public Map delete(@PathVariable("tagId") String tagId) {
    	Map result = new HashMap();
        try {
            tagService.deleteTag(tagId);
            Utils.tagResult(result,true);
        } catch (Exception e) {
            Utils.tagResult(result,false);
        }
        return result;
    }

    @RequestMapping(value = "{tagId}", method = RequestMethod.POST)
    @ResponseBody
    public Map findById(@PathVariable("tagId") String tagId) {
        Map result = new HashMap();
        Tag tag = new Tag();
        try {
            tag = tagService.findTagById(tagId);
            Utils.tagResult(result,true);
            result.put("tag",tag);
        } catch (Exception e) {
            Utils.tagResult(result,false);
        }
        return result;
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public Map list() {
    	Map result = new HashMap();
    	List tagList = new ArrayList();
        try {
            tagList = tagService.findTagList();
            Utils.tagResult(result,true);
            result.put("tagList",tagList);
        } catch (Exception e) {
            Utils.tagResult(result,false);
        }
        return result;
    }

}
