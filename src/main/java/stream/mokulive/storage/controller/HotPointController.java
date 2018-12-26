package stream.mokulive.storage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import stream.mokulive.storage.exception.DuplicateNameException;
import stream.mokulive.storage.service.IHotPointService;
import stream.mokulive.storage.utils.Utils;
import stream.mokulive.storage.vo.Building;
import stream.mokulive.storage.vo.HotPoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/hotPoint")
@Controller
public class HotPointController {

    @Autowired
    private IHotPointService hotPointService;

    @RequestMapping(value="add", method = RequestMethod.POST)
    @ResponseBody
    public Map add(HotPoint hotPoint) {
        Map result = new HashMap();
        try {
            hotPointService.addHotPoint(hotPoint);
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
    public Map update(HotPoint hotPoint) {
        Map result = new HashMap();
        try {
            hotPointService.updateHotPoint(hotPoint);
            Utils.tagResult(result,true);
        } catch (Exception e) {
            Utils.tagResult(result,false);
        }
        return result;
    }

    @RequestMapping(value = "delete/{hotPointId}", method = RequestMethod.POST)
    @ResponseBody
    public Map delete(@PathVariable("hotPointId") String hotPointId) {
        Map result = new HashMap();
        try {
            hotPointService.deleteHotPoint(hotPointId);
            Utils.tagResult(result,true);
        } catch (Exception e) {
            Utils.tagResult(result,false);
        }
        return result;
    }

    @RequestMapping(value = "{hotPointId}",method = RequestMethod.POST)
    @ResponseBody
    public Map findById(@PathVariable("hotPointId") String hotPointId) {
        Map result = new HashMap();
        HotPoint hotPoint = new HotPoint();
        try {
            hotPoint = hotPointService.findHotPointById(hotPointId);
            Utils.tagResult(result,true);
            result.put("hotPoint",hotPoint);
        } catch (Exception e) {
            Utils.tagResult(result,false);
        }
        return result;
    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map findList(String userId) {
        Map result = new HashMap();
        List<HotPoint> hotPointList = new ArrayList();
        try {
            hotPointList = hotPointService.findAllHotPointList(userId);
            Utils.tagResult(result,true);
            result.put("hotPointList",hotPointList);
        } catch (Exception e) {
            Utils.tagResult(result,false);
        }
        return result;
    }

}
