package live.moku.storage.controller;

import java.util.Arrays;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import live.moku.storage.entity.StorageTypeEntity;
import live.moku.storage.service.StorageTypeService;
import live.moku.common.utils.PageUtils;
import live.moku.common.utils.R;



/**
 * 物品标签表

 *
 * @author LL
 * @email qingyanjiu@hotmail.com
 * @date 2020-10-26 13:24:58
 */
@RestController
@RequestMapping("storage/storagetype")
@Api("收纳类型接口")
public class StorageTypeController {
    @Autowired
    private StorageTypeService storageTypeService;

    /**
     * 列表
     */
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    @ApiOperation("类型列表")
    @RequiresPermissions("storage:storagetype:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = storageTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/info/{typeid}", method = {RequestMethod.GET})
    @ApiOperation("类型信息")
    @RequiresPermissions("storage:storagetype:info")
    public R info(@PathVariable("typeid") String typeid){
		StorageTypeEntity storageType = storageTypeService.getById(typeid);

        return R.ok().put("storageType", storageType);
    }

    /**
     * 保存
     */
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    @ApiOperation("新增类型")
    @RequiresPermissions("storage:storagetype:save")
    public R save(@RequestBody StorageTypeEntity storageType){
		storageTypeService.save(storageType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update", method = {RequestMethod.PUT})
    @ApiOperation("修改类型")
    @RequiresPermissions("storage:storagetype:update")
    public R update(@RequestBody StorageTypeEntity storageType){
		storageTypeService.updateById(storageType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    @ApiOperation("删除类型")
    @RequiresPermissions("storage:storagetype:delete")
    public R delete(@RequestBody String[] typeids){
		storageTypeService.removeByIds(Arrays.asList(typeids));

        return R.ok();
    }

}
