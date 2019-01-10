package stream.mokulive.storage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import stream.mokulive.storage.service.IBuildingService;
import stream.mokulive.storage.vo.Building;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/building")
@Controller
public class BuildingController {

    @Autowired
    private IBuildingService buildingService;

    @RequestMapping(value="add", method = RequestMethod.POST)
    @ResponseBody
    public Map add(@RequestBody Building building) throws Exception {
        Map result = new HashMap();
        buildingService.addBuilding(building);
        return result;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Map update(@RequestBody Building building) throws Exception {
        Map result = new HashMap();
        buildingService.updateBuilding(building);
        return result;
    }

    @RequestMapping(value = "delete/{buildingId}", method = RequestMethod.POST)
    @ResponseBody
    public Map delete(@PathVariable("buildingId") String buildingId) throws Exception {
        Map result = new HashMap();
        buildingService.deleteBuilding(buildingId);
        return result;
    }

    @RequestMapping(value = "{buildingId}",method = RequestMethod.POST)
    @ResponseBody
    public Map findById(@PathVariable("buildingId") String buildingId) throws Exception {
    	Map result = new HashMap();
    	Building building = null;
        building = buildingService.findBuildingById(buildingId);
        result.put("building",building);
        return result;
    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map findBuildingList(String userId) throws Exception {
    	Map result = new HashMap();
    	List<Building> buildingList = new ArrayList();
        buildingList = buildingService.findBuildingList(userId);
        result.put("buildingList",buildingList);
        return result;
    }

    @RequestMapping(value = "deleteBuildingList",method = RequestMethod.POST)
    @ResponseBody
    public Map deleteBuildingList(List<String> buildingList) throws Exception {
    	Map result = new HashMap();
        buildingService.deleteBuildingList(buildingList);
        return result;
    }

}
