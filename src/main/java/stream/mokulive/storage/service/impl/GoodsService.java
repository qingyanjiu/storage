package stream.mokulive.storage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stream.mokulive.storage.exception.DuplicateNameException;
import stream.mokulive.storage.mapper.GoodsMapper;
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
        Map params = new HashMap();
        params.put("goodsName",goods.getGoodsName());
        int count = goodsMapper.checkName(params);
        if(count == 0) {
            goods.setGoodsId(IdGenerator.generate());
            goodsMapper.addGoods(goods);
        }else{
            throw new DuplicateNameException();
        }
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

    @Override
    public List<Goods> findGoodsListByName(String goodsName, String userId) throws Exception {
        Map params = new HashMap();
        params.put("goodsName",goodsName);
        params.put("userId",userId);
        return goodsMapper.findGoodsListByName(params);
    }

    @Override
    public Goods findGoodsById(String goodsId) throws Exception {
        Map params = new HashMap();
        params.put("goodsId",goodsId);
        return goodsMapper.findGoodsById(params);
    }

    @Override
    public List<Goods> findAllGoodsList(String userId) throws Exception {
        Map params = new HashMap();
        params.put("userId",userId);
        return goodsMapper.findAllGoodsList(params);
    }

    @Override
    public List<Goods> findGoodsListUnrelatedToHotPoint(String userId) throws Exception {
        Map params = new HashMap();
        params.put("userId",userId);
        return goodsMapper.findGoodsListUnrelatedToHotPoint(params);
    }
}
