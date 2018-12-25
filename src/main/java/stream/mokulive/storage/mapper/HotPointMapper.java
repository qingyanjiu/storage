package stream.mokulive.storage.mapper;

import org.springframework.stereotype.Repository;
import stream.mokulive.storage.vo.Goods;
import stream.mokulive.storage.vo.HotPoint;

import java.util.List;
import java.util.Map;

@Repository
public interface HotPointMapper {

    void addHotPoint(HotPoint hotPoint);

    void updateHotPoint(HotPoint hotPoint);

    void deleteHotPoint(Map params);

    HotPoint findHotPointById(Map params);

    List<HotPoint> findAllHotPointList(Map params);

}
