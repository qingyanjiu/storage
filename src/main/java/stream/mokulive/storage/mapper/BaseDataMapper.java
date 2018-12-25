package stream.mokulive.storage.mapper;

import org.springframework.stereotype.Repository;
import stream.mokulive.storage.vo.BaseData;

import java.util.List;
import java.util.Map;

@Repository
public interface BaseDataMapper {

    void addBaseData(BaseData baseData);

    void updateBaseData(BaseData baseData);

    void deleteBaseData(Map params);

    List<BaseData> findBaseDataList(Map params);
}
