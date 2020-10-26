package live.moku.storage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import live.moku.common.utils.PageUtils;
import live.moku.storage.entity.StorageGoodsEntity;

import java.util.Map;

/**
 * 物品表
 *
 * @author LL
 * @email qingyanjiu@hotmail.com
 * @date 2020-10-26 13:24:58
 */
public interface StorageGoodsService extends IService<StorageGoodsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

