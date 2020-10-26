package live.moku.storage.controller;

import java.util.Arrays;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import live.moku.storage.entity.StorageHotPointsEntity;
import live.moku.storage.service.StorageHotPointsService;
import live.moku.common.utils.PageUtils;
import live.moku.common.utils.R;



/**
 * 热点（收纳家具）表
 *
 * @author LL
 * @email qingyanjiu@hotmail.com
 * @date 2020-10-26 13:24:58
 */
@RestController
@RequestMapping("storage/storagehotpoints")
@Api("热点接口")
public class StorageHotPointsController {
    @Autowired
    private StorageHotPointsService storageHotPointsService;

    /**
     * 列表
     */
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    @ApiOperation("热点列表")
    @RequiresPermissions("storage:storagehotpoints:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = storageHotPointsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/info/{id}", method = {RequestMethod.GET})
    @ApiOperation("热点信息")
    @RequiresPermissions("storage:storagehotpoints:info")
    public R info(@PathVariable("id") String id){
		StorageHotPointsEntity storageHotPoints = storageHotPointsService.getById(id);

        return R.ok().put("storageHotPoints", storageHotPoints);
    }

    /**
     * 保存
     */
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    @ApiOperation("新增热点")
    @RequiresPermissions("storage:storagehotpoints:save")
    public R save(@RequestBody StorageHotPointsEntity storageHotPoints){
		storageHotPointsService.save(storageHotPoints);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update", method = {RequestMethod.PUT})
    @ApiOperation("更新热点")
    @RequiresPermissions("storage:storagehotpoints:update")
    public R update(@RequestBody StorageHotPointsEntity storageHotPoints){
		storageHotPointsService.updateById(storageHotPoints);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    @ApiOperation("删除热点")
    @RequiresPermissions("storage:storagehotpoints:delete")
    public R delete(@RequestBody String[] ids){
		storageHotPointsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
