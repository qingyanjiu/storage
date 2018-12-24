package stream.mokulive.storage.mapper;

import org.springframework.stereotype.Repository;
import stream.mokulive.storage.vo.Goods;

import java.util.List;

@Repository
public interface GoodsMapper {

    void addGoods(Goods goods);

    void updateGoods(Goods goods);

    List<Goods> findGoodsListByName(String goodsName);

    Goods findGoodsById(String goodsId);

    List<Goods> findAllGoodsList();

    List<Goods> findGoodsListUnrelatedToHotPoint();

}
