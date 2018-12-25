package stream.mokulive.storage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stream.mokulive.storage.mapper.BaseDataMapper;
import stream.mokulive.storage.service.IBaseDataService;
import stream.mokulive.storage.vo.BaseData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BaseDataService implements IBaseDataService {

    @Autowired
    private BaseDataMapper baseDataMapper;

    @Override
    public void addBaseData(BaseData baseData) throws Exception {
        baseDataMapper.addBaseData(baseData);
    }

    @Override
    public void updateBaseData(BaseData baseData) throws Exception {
        baseDataMapper.updateBaseData(baseData);
    }

    @Override
    public void deleteBaseData(String baseDataId) throws Exception{
        Map params = new HashMap();
        params.put("baseDataId",baseDataId);
        baseDataMapper.deleteBaseData(params);
    }

    @Override
    public List<BaseData> findBaseDataList(String baseDataId, String dataType) throws Exception {
        Map params = new HashMap();
        params.put("baseDataId",baseDataId);
        params.put("dataType",dataType);
        return baseDataMapper.findBaseDataList(params);
    }

}
