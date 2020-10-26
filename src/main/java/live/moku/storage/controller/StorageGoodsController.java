package live.moku.storage.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import live.moku.common.utils.PageUtils;
import live.moku.common.utils.R;
import live.moku.modules.sys.controller.AbstractController;
import live.moku.storage.entity.StorageGoodsEntity;
import live.moku.storage.service.StorageGoodsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 物品表
 *
 * @author LL
 * @email qingyanjiu@hotmail.com
 * @date 2020-10-26 13:24:58
 */
@RestController
@RequestMapping("storage/storagegoods")
@Api("物品接口")
public class StorageGoodsController extends AbstractController {
    @Autowired
    private StorageGoodsService storageGoodsService;

    /**
     * 列表
     */
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    @ApiOperation("物品列表")
    @RequiresPermissions("storage:storagegoods:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = storageGoodsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/info/{goodsid}", method = {RequestMethod.GET})
    @ApiOperation("物品信息")
    @RequiresPermissions("storage:storagegoods:info")
    public R info(@PathVariable("goodsid") String goodsid){
		StorageGoodsEntity storageGoods = storageGoodsService.getById(goodsid);

        return R.ok().put("storageGoods", storageGoods);
    }

    /**
     * 保存
     */
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    @ApiOperation("新增物品")
    @RequiresPermissions("storage:storagegoods:save")
    public R save(@RequestBody StorageGoodsEntity storageGoods){
		storageGoodsService.save(storageGoods);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update", method = {RequestMethod.PUT})
    @ApiOperation("更新物品")
    @RequiresPermissions("storage:storagegoods:update")
    public R update(@RequestBody StorageGoodsEntity storageGoods){
		storageGoodsService.updateById(storageGoods);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    @ApiOperation("删除物品")
    @RequiresPermissions("storage:storagegoods:delete")
    public R delete(@RequestBody String[] goodsids){
		storageGoodsService.removeByIds(Arrays.asList(goodsids));

        return R.ok();
    }

}
