package live.moku.storage.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import live.moku.common.utils.PageUtils;
import live.moku.common.utils.Query;

import live.moku.storage.dao.StorageTypeDao;
import live.moku.storage.entity.StorageTypeEntity;
import live.moku.storage.service.StorageTypeService;


@Service("storageTypeService")
public class StorageTypeServiceImpl extends ServiceImpl<StorageTypeDao, StorageTypeEntity> implements StorageTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StorageTypeEntity> page = this.page(
                new Query<StorageTypeEntity>().getPage(params),
                new QueryWrapper<StorageTypeEntity>()
        );

        return new PageUtils(page);
    }

}