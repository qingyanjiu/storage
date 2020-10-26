package live.moku.storage.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import live.moku.common.utils.PageUtils;
import live.moku.common.utils.Query;

import live.moku.storage.dao.StorageBuildingDao;
import live.moku.storage.entity.StorageBuildingEntity;
import live.moku.storage.service.StorageBuildingService;


@Service("storageBuildingService")
public class StorageBuildingServiceImpl extends ServiceImpl<StorageBuildingDao, StorageBuildingEntity> implements StorageBuildingService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StorageBuildingEntity> page = this.page(
                new Query<StorageBuildingEntity>().getPage(params),
                new QueryWrapper<StorageBuildingEntity>()
        );

        return new PageUtils(page);
    }

}