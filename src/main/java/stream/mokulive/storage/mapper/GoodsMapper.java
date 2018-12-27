package stream.mokulive.storage.mapper;

import org.springframework.stereotype.Repository;
import stream.mokulive.storage.mapper.bean.GoodsMapperBean;
import stream.mokulive.storage.vo.Goods;

import java.util.List;
import java.util.Map;

@Repository
public interface GoodsMapper {

    int checkName(Map params);

    void addGoods(Goods goods);

    void updateGoods(Goods goods);

    void deleteGoods(Map params);

    List<GoodsMapperBean> findGoodsListByName(Map params);

    GoodsMapperBean findGoodsById(Map params);

    List<GoodsMapperBean> findAllGoodsList(Map params);

    List<GoodsMapperBean> findGoodsListUnrelatedToHotPoint(Map params);

}
