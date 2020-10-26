package live.moku.storage.dao;

import live.moku.storage.entity.StorageBuildingEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 建筑物表
 * 
 * @author LL
 * @email qingyanjiu@hotmail.com
 * @date 2020-10-26 13:24:58
 */
@Mapper
public interface StorageBuildingDao extends BaseMapper<StorageBuildingEntity> {
	
}
