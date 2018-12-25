package stream.mokulive.storage.mapper;

import org.springframework.stereotype.Repository;
import stream.mokulive.storage.vo.BaseData;
import stream.mokulive.storage.vo.Building;

import java.util.List;
import java.util.Map;

@Repository
public interface BuildingMapper {

    void addBuilding(Building building);

    void updateBuilding(Building building);

    void deleteBuilding(Map params);

    List<Building> findBuildingList(Map params);
}
