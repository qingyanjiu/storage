package live.moku.storage.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import live.moku.common.utils.PageUtils;
import live.moku.common.utils.Query;

import live.moku.storage.dao.StorageGoodsDao;
import live.moku.storage.entity.StorageGoodsEntity;
import live.moku.storage.service.StorageGoodsService;


@Service("storageGoodsService")
public class StorageGoodsServiceImpl extends ServiceImpl<StorageGoodsDao, StorageGoodsEntity> implements StorageGoodsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StorageGoodsEntity> page = this.page(
                new Query<StorageGoodsEntity>().getPage(params),
                new QueryWrapper<StorageGoodsEntity>()
        );

        return new PageUtils(page);
    }

}