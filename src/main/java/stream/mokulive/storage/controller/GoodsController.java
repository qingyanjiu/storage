package stream.mokulive.storage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import stream.mokulive.storage.exception.DuplicateNameException;
import stream.mokulive.storage.service.IGoodsService;
import stream.mokulive.storage.utils.Utils;
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
    public Map add(Goods goods) {
        Map result = new HashMap();
        try {
            goodsService.addGoods(goods);
            Utils.tagResult(result, true);
        } catch (Exception e) {
            Utils.tagResult(result,false);
            if(e instanceof DuplicateNameException){
                result.put("msg","Duplicate name");
            }
        }
        return result;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Map update(Goods goods) {
        Map result = new HashMap();
        try {
            goodsService.updateGoods(goods);
            Utils.tagResult(result, true);
        } catch (Exception e) {
            Utils.tagResult(result, false);
        }
        return result;
    }

    @RequestMapping(value = "delete/{goodsId}", method = RequestMethod.POST)
    @ResponseBody
    public Map delete(@PathVariable("goodsId") String goodsId) {
        Map result = new HashMap();
        try {
            goodsService.deleteGoods(goodsId);
            Utils.tagResult(result, true);
        } catch (Exception e) {
            Utils.tagResult(result, false);
        }
        return result;
    }

    @RequestMapping(value = "findByName", method = RequestMethod.POST)
    @ResponseBody
    public Map findByName(String goodsName, String userId) {
        Map result = new HashMap();
        List<Goods> goodsList = new ArrayList();
        try {
            goodsList = goodsService.findGoodsListByName(goodsName, userId);
            result.put("goodsList", goodsList);
            Utils.tagResult(result, true);
        } catch (Exception e) {
            Utils.tagResult(result, false);
        }
        return result;
    }

    @RequestMapping(value = "{goodsId}", method = RequestMethod.POST)
    @ResponseBody
    public Map findById(@PathVariable("goodsId") String goodsId) {
        Map result = new HashMap();
        Goods goods = new Goods();
        try {
            goods = goodsService.findGoodsById(goodsId);
            result.put("goods", goods);
            Utils.tagResult(result, true);
        } catch (Exception e) {
            Utils.tagResult(result,false);
            if(e.getClass().isInstance(DuplicateNameException.class)){
                result.put("msg","Duplicate name");
            }
        }
        return result;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Map findAll(String userId) {
        Map result = new HashMap();
        List<Goods> goodsList = new ArrayList();
        try {
            goodsList = goodsService.findAllGoodsList(userId);
            result.put("goodsList", goodsList);
            Utils.tagResult(result, true);
        } catch (Exception e) {
            Utils.tagResult(result, false);
        }
        return result;
    }

    @RequestMapping(value = "findUnrelated", method = RequestMethod.POST)
    @ResponseBody
    public Map findGoodsListUnrelatedToHotPoint(String userId) {
        Map result = new HashMap();
        List<Goods> goodsList = new ArrayList();
        try {
            goodsList = goodsService.findGoodsListUnrelatedToHotPoint(userId);
            result.put("goodsList", goodsList);
            Utils.tagResult(result, true);
        } catch (Exception e) {
            Utils.tagResult(result, false);
        }
        return result;
    }

}
