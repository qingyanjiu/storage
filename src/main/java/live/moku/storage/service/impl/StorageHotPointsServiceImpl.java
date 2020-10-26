package live.moku.storage.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import live.moku.common.utils.PageUtils;
import live.moku.common.utils.Query;

import live.moku.storage.dao.StorageHotPointsDao;
import live.moku.storage.entity.StorageHotPointsEntity;
import live.moku.storage.service.StorageHotPointsService;


@Service("storageHotPointsService")
public class StorageHotPointsServiceImpl extends ServiceImpl<StorageHotPointsDao, StorageHotPointsEntity> implements StorageHotPointsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StorageHotPointsEntity> page = this.page(
                new Query<StorageHotPointsEntity>().getPage(params),
                new QueryWrapper<StorageHotPointsEntity>()
        );

        return new PageUtils(page);
    }

}