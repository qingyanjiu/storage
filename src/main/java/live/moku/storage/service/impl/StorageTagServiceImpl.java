package live.moku.storage.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import live.moku.common.utils.PageUtils;
import live.moku.common.utils.Query;

import live.moku.storage.dao.StorageTagDao;
import live.moku.storage.entity.StorageTagEntity;
import live.moku.storage.service.StorageTagService;


@Service("storageTagService")
public class StorageTagServiceImpl extends ServiceImpl<StorageTagDao, StorageTagEntity> implements StorageTagService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StorageTagEntity> page = this.page(
                new Query<StorageTagEntity>().getPage(params),
                new QueryWrapper<StorageTagEntity>()
        );

        return new PageUtils(page);
    }

}