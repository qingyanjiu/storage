package stream.mokulive.storage.service;

import stream.mokulive.storage.vo.BaseData;

import java.util.List;

public interface IBaseDataService {

    void addBaseData(BaseData baseData) throws Exception;

    void updateBaseData(BaseData baseData) throws Exception;

    void deleteBaseData(String baseDataId) throws Exception;

    List<BaseData> findBaseDataList(String baseDataId, String dataType) throws Exception;
}
