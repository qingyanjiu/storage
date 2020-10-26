package live.moku.storage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import live.moku.common.utils.PageUtils;
import live.moku.storage.entity.StorageHotPointsEntity;

import java.util.Map;

/**
 * 热点（收纳家具）表
 *
 * @author LL
 * @email qingyanjiu@hotmail.com
 * @date 2020-10-26 13:24:58
 */
public interface StorageHotPointsService extends IService<StorageHotPointsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

