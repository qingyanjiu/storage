package stream.mokulive.storage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import stream.mokulive.storage.service.ITagService;
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
    public Map add(@RequestBody Tag tag) throws Exception{
    	Map result = new HashMap();
        tagService.addTag(tag);
        return result;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Map update(@RequestBody Tag tag) throws Exception{
    	Map result = new HashMap();
        tagService.updateTag(tag);
        return result;
    }

    @RequestMapping(value = "delete/{tagId}", method = RequestMethod.POST)
    @ResponseBody
    public Map delete(@PathVariable("tagId") String tagId) throws Exception{
    	Map result = new HashMap();
        tagService.deleteTag(tagId);
        return result;
    }

    @RequestMapping(value = "{tagId}", method = RequestMethod.POST)
    @ResponseBody
    public Map findById(@PathVariable("tagId") String tagId) throws Exception{
        Map result = new HashMap();
        Tag tag = new Tag();
        tag = tagService.findTagById(tagId);
        result.put("tag",tag);
        return result;
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public Map list() throws Exception{
    	Map result = new HashMap();
    	List tagList = new ArrayList();
        tagList = tagService.findTagList();
        result.put("tagList",tagList);
        return result;
    }

}
