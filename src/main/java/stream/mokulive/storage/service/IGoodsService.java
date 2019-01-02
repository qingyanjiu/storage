package stream.mokulive.storage.service;

import stream.mokulive.storage.exception.DuplicateNameException;
import stream.mokulive.storage.mapper.bean.GoodsMapperBean;
import stream.mokulive.storage.vo.Goods;

import java.util.List;

public interface IGoodsService {

    void addGoods(Goods goods) throws DuplicateNameException, Exception;

    void updateGoods(Goods goods) throws Exception;

    void deleteGoods(String goodsId) throws Exception;

    void deleteGoodsList(List<String> goodsIdList) throws Exception;

    List<GoodsMapperBean> findGoodsListByName(String goodsName, String userId) throws Exception;

    GoodsMapperBean findGoodsById(String goodsId) throws Exception;

    List<GoodsMapperBean> findAllGoodsList(String userId) throws Exception;

    List<GoodsMapperBean> findGoodsListUnrelatedToHotPoint(String userId) throws Exception;
}
