package stream.mokulive.storage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import stream.mokulive.storage.mapper.bean.GoodsMapperBean;
import stream.mokulive.storage.service.IGoodsService;
import stream.mokulive.storage.vo.Goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/goods")
@Controller
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Map add(@RequestBody Goods goods) throws Exception {
        Map result = new HashMap();
        goodsService.addGoods(goods);
        return result;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Map update(@RequestBody Goods goods) throws Exception {
        Map result = new HashMap();
        goodsService.updateGoods(goods);
        return result;
    }

    @RequestMapping(value = "delete/{goodsId}", method = RequestMethod.POST)
    @ResponseBody
    public Map delete(@PathVariable("goodsId") String goodsId) throws Exception {
        Map result = new HashMap();
        goodsService.deleteGoods(goodsId);
        return result;
    }

    @RequestMapping(value = "deleteGoodsList", method = RequestMethod.POST)
    @ResponseBody
    public Map deleteGoodsList(@RequestBody List<String> goodsIdList) throws Exception {
        Map result = new HashMap();
        goodsService.deleteGoodsList(goodsIdList);
        return result;
    }

    @RequestMapping(value = "findByName", method = RequestMethod.POST)
    @ResponseBody
    public Map findByName(String goodsName, String userId) throws Exception {
        Map result = new HashMap();
        List<GoodsMapperBean> goodsList = new ArrayList();
        goodsList = goodsService.findGoodsListByName(goodsName, userId);
        result.put("goodsList", goodsList);
        return result;
    }

    @RequestMapping(value = "{goodsId}", method = RequestMethod.POST)
    @ResponseBody
    public Map findById(@PathVariable("goodsId") String goodsId) throws Exception {
        Map result = new HashMap();
        GoodsMapperBean goods = null;
        goods = goodsService.findGoodsById(goodsId);
        result.put("goods", goods);
        return result;
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public Map findAll(String userId) throws Exception {
        Map result = new HashMap();
        List<GoodsMapperBean> goodsList = new ArrayList();
        goodsList = goodsService.findAllGoodsList(userId);
        result.put("goodsList", goodsList);
        return result;
    }

    @RequestMapping(value = "findUnrelated", method = RequestMethod.POST)
    @ResponseBody
    public Map findGoodsListUnrelatedToHotPoint(String userId) throws Exception {
        Map result = new HashMap();
        List<GoodsMapperBean> goodsList = new ArrayList();
        goodsList = goodsService.findGoodsListUnrelatedToHotPoint(userId);
        result.put("goodsList", goodsList);
        return result;
    }

}
