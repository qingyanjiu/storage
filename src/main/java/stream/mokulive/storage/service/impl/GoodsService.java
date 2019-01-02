package stream.mokulive.storage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stream.mokulive.storage.exception.DuplicateNameException;
import stream.mokulive.storage.mapper.GoodsMapper;
import stream.mokulive.storage.mapper.bean.GoodsMapperBean;
import stream.mokulive.storage.service.IGoodsService;
import stream.mokulive.storage.utils.IdGenerator;
import stream.mokulive.storage.vo.Goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsService implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public void addGoods(Goods goods) throws Exception {
//        Map params = new HashMap();
//        params.put("goodsName",goods.getGoodsName());
//        params.put("userId",goods.getUserId());
//        int count = goodsMapper.checkName(params);
//        if(count == 0) {
            goods.setGoodsId(IdGenerator.generate());
            goodsMapper.addGoods(goods);
//        }else{
//            throw new DuplicateNameException();
//        }
    }

    @Override
    public void updateGoods(Goods goods) throws Exception {
        goodsMapper.updateGoods(goods);
    }

    @Override
    public void deleteGoods(String goodsId) throws Exception {
        Map params = new HashMap();
        params.put("goodsId",goodsId);
        goodsMapper.deleteGoods(params);
    }

    @Transactional
    @Override
    public void deleteGoodsList(List<String> goodsIdList) throws Exception {
        Map map = new HashMap();
        for (String goodsId:goodsIdList) {
            map.clear();
            map.put("goodsId",goodsId);
            goodsMapper.deleteGoods(map);
        }
    }

    @Override
    public List<GoodsMapperBean> findGoodsListByName(String goodsName, String userId) throws Exception {
        Map params = new HashMap();
        params.put("goodsName",goodsName);
        params.put("userId",userId);
        return goodsMapper.findGoodsListByName(params);
    }

    @Override
    public GoodsMapperBean findGoodsById(String goodsId) throws Exception {
        Map params = new HashMap();
        params.put("goodsId",goodsId);
        return goodsMapper.findGoodsById(params);
    }

    @Override
    public List<GoodsMapperBean> findAllGoodsList(String userId) throws Exception {
        Map params = new HashMap();
        params.put("userId",userId);
        return goodsMapper.findAllGoodsList(params);
    }

    @Override
    public List<GoodsMapperBean> findGoodsListUnrelatedToHotPoint(String userId) throws Exception {
        Map params = new HashMap();
        params.put("userId",userId);
        return goodsMapper.findGoodsListUnrelatedToHotPoint(params);
    }
}
