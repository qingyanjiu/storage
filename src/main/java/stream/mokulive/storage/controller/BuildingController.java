package stream.mokulive.storage.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import stream.mokulive.storage.service.IBuildingService;
import stream.mokulive.storage.utils.Utils;
import stream.mokulive.storage.vo.BaseData;
import stream.mokulive.storage.vo.Building;

@RequestMapping("/building")
@Controller
public class BuildingController {

    @Autowired
    private IBuildingService buildingService;

    @RequestMapping(value="add", method = RequestMethod.POST)
    @ResponseBody
    public Map add(Building building) {
        Map result = new HashMap();
        try {
            buildingService.addBuilding(building);
            Utils.tagResult(result,true);
        } catch (Exception e) {
            Utils.tagResult(result,false);
        }
        return result;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Map update(Building building) {
        Map result = new HashMap();
        try {
            buildingService.updateBuilding(building);
            Utils.tagResult(result,true);
        } catch (Exception e) {
            Utils.tagResult(result,false);
        }
        return result;
    }

    @RequestMapping(value = "delete/{buildingId}", method = RequestMethod.POST)
    @ResponseBody
    public Map delete(@PathVariable("buildingId") String buildingId) {
        Map result = new HashMap();
        try {
            buildingService.deleteBuilding(buildingId);
            Utils.tagResult(result,true);
        } catch (Exception e) {
            Utils.tagResult(result,false);
        }
        return result;
    }

    @RequestMapping(value = "{buildingId}",method = RequestMethod.POST)
    @ResponseBody
    public Map findById(@PathVariable("buildingId") String buildingId) {
    	Map result = new HashMap();
    	Building building = new Building();
        try {
            building = buildingService.findBuildingById(buildingId);
            Utils.tagResult(result,true);
            result.put("building",building);
        } catch (Exception e) {
            Utils.tagResult(result,false);
        }
        return result;
    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map findBuildingList(String userId) {
    	Map result = new HashMap();
    	List<Building> buildingList = new ArrayList();
        try {
            buildingList = buildingService.findBuildingList(userId);
            Utils.tagResult(result,true);
            result.put("buildingList",buildingList);
        } catch (Exception e) {
            Utils.tagResult(result,false);
        }
        return result;
    }

}
