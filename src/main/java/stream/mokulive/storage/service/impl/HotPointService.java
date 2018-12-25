package stream.mokulive.storage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stream.mokulive.storage.mapper.HotPointMapper;
import stream.mokulive.storage.service.IHotPointService;
import stream.mokulive.storage.vo.HotPoint;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HotPointService implements IHotPointService {

    @Autowired
    private HotPointMapper hotPointMapper;

    @Override
    public void addHotPoint(HotPoint hotPoint) {
        hotPointMapper.addHotPoint(hotPoint);
    }

    @Override
    public void updateHotPoint(HotPoint hotPoint) {
        hotPointMapper.updateHotPoint(hotPoint);
    }

    @Override
    public void deleteHotPoint(String hotPointId) {
        Map params = new HashMap();
        params.put("hotPointId",hotPointId);
        hotPointMapper.deleteHotPoint(params);
    }

    @Override
    public HotPoint findHotPointById(String hotPointId, String userId) {
        Map params = new HashMap();
        params.put("hotPointId",hotPointId);
        params.put("userId",userId);
        return hotPointMapper.findHotPointById(params);
    }

    @Override
    public List<HotPoint> findAllHotPointList(String hotPointId) {
        Map params = new HashMap();
        params.put("hotPointId",hotPointId);
        return hotPointMapper.findAllHotPointList(params);
    }
}
