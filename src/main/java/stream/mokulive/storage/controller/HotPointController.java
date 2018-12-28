package stream.mokulive.storage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    public Map add(@RequestBody HotPoint hotPoint) throws Exception {
        Map result = new HashMap();
        hotPointService.addHotPoint(hotPoint);
        return result;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Map update(@RequestBody HotPoint hotPoint) throws Exception {
        Map result = new HashMap();
        hotPointService.updateHotPoint(hotPoint);
        return result;
    }

    @RequestMapping(value = "delete/{hotPointId}", method = RequestMethod.POST)
    @ResponseBody
    public Map delete(@PathVariable("hotPointId") String hotPointId) throws Exception {
        Map result = new HashMap();
        hotPointService.deleteHotPoint(hotPointId);
        return result;
    }

    @RequestMapping(value = "{hotPointId}",method = RequestMethod.POST)
    @ResponseBody
    public Map findById(@PathVariable("hotPointId") String hotPointId) throws Exception {
        Map result = new HashMap();
        HotPoint hotPoint = null;
        hotPoint = hotPointService.findHotPointById(hotPointId);
        result.put("hotPoint",hotPoint);
        return result;
    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map findList(String userId) throws Exception {
        Map result = new HashMap();
        List<HotPoint> hotPointList = new ArrayList();
        hotPointList = hotPointService.findAllHotPointList(userId);
        result.put("hotPointList",hotPointList);
        return result;
    }

}
