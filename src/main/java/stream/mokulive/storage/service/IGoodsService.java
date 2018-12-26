package stream.mokulive.storage.service;

import stream.mokulive.storage.exception.DuplicateNameException;
import stream.mokulive.storage.vo.Goods;

import java.util.List;

public interface IGoodsService {

    void addGoods(Goods goods) throws DuplicateNameException, Exception;

    void updateGoods(Goods goods) throws Exception;

    void deleteGoods(String goodsId) throws Exception;

    List<Goods> findGoodsListByName(String goodsName, String userId) throws Exception;

    Goods findGoodsById(String goodsId) throws Exception;

    List<Goods> findAllGoodsList(String userId) throws Exception;

    List<Goods> findGoodsListUnrelatedToHotPoint(String userId) throws Exception;
}
