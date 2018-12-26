package stream.mokulive.storage.mapper;

import org.springframework.stereotype.Repository;
import stream.mokulive.storage.vo.Goods;

import java.util.List;
import java.util.Map;

@Repository
public interface GoodsMapper {

    int checkName(Map params);

    void addGoods(Goods goods);

    void updateGoods(Goods goods);

    void deleteGoods(Map params);

    List<Goods> findGoodsListByName(Map params);

    Goods findGoodsById(Map params);

    List<Goods> findAllGoodsList(Map params);

    List<Goods> findGoodsListUnrelatedToHotPoint(Map params);

}
