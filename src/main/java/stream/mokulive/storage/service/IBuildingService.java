package stream.mokulive.storage.service;

import stream.mokulive.storage.vo.Building;

import java.util.List;

public interface IBuildingService {

    void addBuilding(Building building);

    void updateBuilding(Building building);

    void deleteBuilding(String buildingId);

    Building findBuildingById(String buildingId);

    List<Building> findBuildingList(String userId);
}
