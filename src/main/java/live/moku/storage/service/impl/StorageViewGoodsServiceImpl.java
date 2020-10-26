package live.moku.storage.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import live.moku.common.utils.PageUtils;
import live.moku.common.utils.Query;

import live.moku.storage.dao.StorageViewGoodsDao;
import live.moku.storage.entity.StorageViewGoodsEntity;
import live.moku.storage.service.StorageViewGoodsService;


@Service("storageViewGoodsService")
public class StorageViewGoodsServiceImpl extends ServiceImpl<StorageViewGoodsDao, StorageViewGoodsEntity> implements StorageViewGoodsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StorageViewGoodsEntity> page = this.page(
                new Query<StorageViewGoodsEntity>().getPage(params),
                new QueryWrapper<StorageViewGoodsEntity>()
        );

        return new PageUtils(page);
    }

}