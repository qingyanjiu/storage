package stream.mokulive.storage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stream.mokulive.storage.exception.DuplicateNameException;
import stream.mokulive.storage.mapper.HotPointMapper;
import stream.mokulive.storage.service.IHotPointService;
import stream.mokulive.storage.utils.IdGenerator;
import stream.mokulive.storage.vo.HotPoint;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HotPointService implements IHotPointService {

    @Autowired
    private HotPointMapper hotPointMapper;

    @Override
    public void addHotPoint(HotPoint hotPoint) throws Exception{
        Map params = new HashMap();
        params.put("hotPointName",hotPoint.getHotPointName());
        params.put("userId",hotPoint.getUserId());
        int count = hotPointMapper.checkName(params);
        if(count == 0) {
            hotPoint.setId(IdGenerator.generate());
            hotPointMapper.addHotPoint(hotPoint);
        }else{
            throw new DuplicateNameException();
        }
    }

    @Override
    public void updateHotPoint(HotPoint hotPoint) throws Exception {
        hotPointMapper.updateHotPoint(hotPoint);
    }

    @Override
    public void deleteHotPoint(String hotPointId) throws Exception {
        Map params = new HashMap();
        params.put("hotPointId",hotPointId);
        hotPointMapper.deleteHotPoint(params);
    }

    @Override
    public HotPoint findHotPointById(String hotPointId) throws Exception {
        Map params = new HashMap();
        params.put("hotPointId",hotPointId);
        return hotPointMapper.findHotPointById(params);
    }

    @Override
    public List<HotPoint> findAllHotPointList(String userId) throws Exception {
        Map params = new HashMap();
        params.put("userId",userId);
        return hotPointMapper.findAllHotPointList(params);
    }
}
