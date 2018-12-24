package stream.mokulive.storage.service;

import stream.mokulive.storage.vo.Goods;

import java.util.List;

public interface IGoodsService {

    void addGoods();

    void updateGoods(Goods goods);

    void deleteGoods(String goodsId);

    List<Goods> findGoodsListByName(String goodsName);

    Goods findGoodsById(String goodsId);

    List<Goods> findAllGoodsList();

    List<Goods> findGoodsListUnrelatedToHotPoint();
}
