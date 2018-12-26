package stream.mokulive.storage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import stream.mokulive.storage.exception.DuplicateNameException;
import stream.mokulive.storage.service.ITypeService;
import stream.mokulive.storage.utils.Utils;
import stream.mokulive.storage.vo.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/type")
@Controller
public class TypeController {

    @Autowired
    private ITypeService typeService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Map add(Type type) throws Exception {
    	Map result = new HashMap();
        typeService.addType(type);
        return result;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Map update(Type type) throws Exception {
    	Map result = new HashMap();
        typeService.updateType(type);
        return result;
    }

    @RequestMapping(value = "delete/{typeId}", method = RequestMethod.POST)
    @ResponseBody
    public Map delete(@PathVariable("typeId") String typeId) throws Exception {
    	Map result = new HashMap();
        typeService.deleteType(typeId);
        return result;
    }


    @RequestMapping(value = "{typeId}", method = RequestMethod.POST)
    @ResponseBody
    public Map findById(@PathVariable("typeId") String typeId) throws Exception {
        Map result = new HashMap();
        Type type = new Type();
        type = typeService.findTypeById(typeId);
        result.put("type",type);
        return result;
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public Map list() throws Exception {
    	Map result = new HashMap();
    	List typeList = new ArrayList();
        typeList = typeService.findTypeList();
        result.put("typeList",typeList);
        return result;
    }

}
