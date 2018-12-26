package stream.mokulive.storage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stream.mokulive.storage.exception.DuplicateNameException;
import stream.mokulive.storage.mapper.BuildingMapper;
import stream.mokulive.storage.service.IBuildingService;
import stream.mokulive.storage.utils.IdGenerator;
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
    public void addBuilding(Building building) throws Exception {
        Map params = new HashMap();
        params.put("buildingName",building.getBuildingName());
        int count = buildingMapper.checkName(params);
        if(count == 0) {
            building.setBuildingId(IdGenerator.generate());
            buildingMapper.addBuilding(building);
        }else{
            throw new DuplicateNameException();
        }
    }

    @Override
    public void updateBuilding(Building building) throws Exception {
        buildingMapper.updateBuilding(building);
    }

    @Override
    public void deleteBuilding(String buildingId) throws Exception {
        Map params = new HashMap();
        params.put("buildingId",buildingId);
        buildingMapper.deleteBuilding(params);
    }

    @Override
    public Building findBuildingById(String buildingId) throws Exception {
        Building building = null;
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
    public List<Building> findBuildingList(String userId) throws Exception {
        Map params = new HashMap();
        params.put("userId",userId);
        return buildingMapper.findBuildingList(params);
    }
}
