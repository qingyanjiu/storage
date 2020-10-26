package live.moku.storage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import live.moku.common.utils.PageUtils;
import live.moku.storage.entity.StorageViewGoodsEntity;

import java.util.Map;

/**
 * VIEW
 *
 * @author LL
 * @email qingyanjiu@hotmail.com
 * @date 2020-10-26 13:24:58
 */
public interface StorageViewGoodsService extends IService<StorageViewGoodsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

