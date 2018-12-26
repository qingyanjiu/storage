package stream.mokulive.storage.service;

import stream.mokulive.storage.vo.HotPoint;

import java.util.List;

public interface IHotPointService {

    void addHotPoint(HotPoint hotPoint) throws Exception;

    void updateHotPoint(HotPoint hotPoint) throws Exception;

    void deleteHotPoint(String hotPointId) throws Exception;

    HotPoint findHotPointById(String hotPointId) throws Exception;

    List<HotPoint> findAllHotPointList(String userId) throws Exception;

}
