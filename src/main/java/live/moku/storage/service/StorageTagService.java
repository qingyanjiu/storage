package live.moku.storage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import live.moku.common.utils.PageUtils;
import live.moku.storage.entity.StorageTagEntity;

import java.util.Map;

/**
 * 
 *
 * @author LL
 * @email qingyanjiu@hotmail.com
 * @date 2020-10-26 13:24:58
 */
public interface StorageTagService extends IService<StorageTagEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

