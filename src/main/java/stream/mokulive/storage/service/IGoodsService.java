package stream.mokulive.storage.service;

import stream.mokulive.storage.vo.Goods;

import java.util.List;

public interface IGoodsService {

    void addGoods(Goods goods);

    void updateGoods(Goods goods);

    void deleteGoods(String goodsId);

    List<Goods> findGoodsListByName(String goodsName, String userId);

    Goods findGoodsById(String goodsId);

    List<Goods> findAllGoodsList(String userId);

    List<Goods> findGoodsListUnrelatedToHotPoint(String userId);
}
