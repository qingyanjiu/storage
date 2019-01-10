package stream.mokulive.storage.service;

import stream.mokulive.storage.vo.Building;

import java.util.List;

public interface IBuildingService {

    void addBuilding(Building building) throws Exception;

    void updateBuilding(Building building) throws Exception;

    void deleteBuilding(String buildingId) throws Exception;

    Building findBuildingById(String buildingId) throws Exception;

    List<Building> findBuildingList(String userId) throws Exception;

    void deleteBuildingList(List<String> buildingIdList) throws Exception;
}
