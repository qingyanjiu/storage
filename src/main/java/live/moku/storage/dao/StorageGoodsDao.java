package live.moku.storage.dao;

import live.moku.storage.entity.StorageGoodsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 物品表
 * 
 * @author LL
 * @email qingyanjiu@hotmail.com
 * @date 2020-10-26 13:24:58
 */
@Mapper
public interface StorageGoodsDao extends BaseMapper<StorageGoodsEntity> {
	
}
