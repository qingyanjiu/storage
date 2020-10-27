package live.moku.storage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import live.moku.common.utils.PageUtils;
import live.moku.storage.entity.StorageBuildingEntity;

import java.util.List;
import java.util.Map;

/**
 * 建筑物表
 *
 * @author LL
 * @email qingyanjiu@hotmail.com
 * @date 2020-10-26 13:24:58
 */
public interface StorageBuildingService extends IService<StorageBuildingEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<StorageBuildingEntity> qryUserBuildings(long userId);
}

