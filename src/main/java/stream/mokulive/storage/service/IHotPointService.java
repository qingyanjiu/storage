package stream.mokulive.storage.service;

import stream.mokulive.storage.vo.HotPoint;

import java.util.List;

public interface IHotPointService {

    void addHotPoint(HotPoint hotPoint);

    void updateHotPoint(HotPoint hotPoint);

    void deleteHotPoint(String hotPointId);

    HotPoint findHotPointById(String hotPointId, String userId);

    List<HotPoint> findAllHotPointList(String userId);

}
