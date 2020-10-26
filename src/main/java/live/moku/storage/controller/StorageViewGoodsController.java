package live.moku.storage.controller;

import java.util.Arrays;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import live.moku.storage.entity.StorageViewGoodsEntity;
import live.moku.storage.service.StorageViewGoodsService;
import live.moku.common.utils.PageUtils;
import live.moku.common.utils.R;



/**
 * VIEW
 *
 * @author LL
 * @email qingyanjiu@hotmail.com
 * @date 2020-10-26 13:24:58
 */
@RestController
@Api("收纳视图接口")
@RequestMapping("storage/storageviewgoods")
public class StorageViewGoodsController {
    @Autowired
    private StorageViewGoodsService storageViewGoodsService;

    /**
     * 列表
     */
    @RequestMapping(value = "/list" , method = {RequestMethod.GET})
    @ApiOperation("收纳列表")
    @RequiresPermissions("storage:storageviewgoods:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = storageViewGoodsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/info/{goodsid}", method = {RequestMethod.GET})
    @ApiOperation("收纳信息")
    @RequiresPermissions("storage:storageviewgoods:info")
    public R info(@PathVariable("goodsid") String goodsid){
		StorageViewGoodsEntity storageViewGoods = storageViewGoodsService.getById(goodsid);

        return R.ok().put("storageViewGoods", storageViewGoods);
    }

}
