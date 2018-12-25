package stream.mokulive.storage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stream.mokulive.storage.mapper.BuildingMapper;
import stream.mokulive.storage.service.IBuildingService;
import stream.mokulive.storage.vo.Building;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BuildingService implements IBuildingService {

    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public void addBuilding(Building building) {
        buildingMapper.addBuilding(building);
    }

    @Override
    public void updateBuilding(Building building) {
        buildingMapper.updateBuilding(building);
    }

    @Override
    public void deleteBuilding(String buildingId) {
        Map params = new HashMap();
        params.put("buildingId",buildingId);
        buildingMapper.deleteBuilding(params);
    }

    @Override
    public Building findBuildingById(String buildingId) {
        Building building = new Building();
        Map params = new HashMap();
        params.put("buildingId",buildingId);
        List<Building> list = new ArrayList();
        list = buildingMapper.findBuildingList(params);
        if(list.size()>0){
            building = list.get(0);
        }
        return building;
    }

    @Override
    public List<Building> findBuildingList(String userId) {
        Map params = new HashMap();
        params.put("userId",userId);
        return buildingMapper.findBuildingList(params);
    }
}
