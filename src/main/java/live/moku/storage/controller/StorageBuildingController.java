package live.moku.storage.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import live.moku.common.utils.PageUtils;
import live.moku.common.utils.R;
import live.moku.modules.sys.controller.AbstractController;
import live.moku.storage.entity.StorageBuildingEntity;
import live.moku.storage.service.StorageBuildingService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 建筑物表
 *
 * @author LL
 * @email qingyanjiu@hotmail.com
 * @date 2020-10-26 13:24:58
 */
@RestController
@RequestMapping("storage/storagebuilding")
@Api("住房接口")
public class StorageBuildingController extends AbstractController {
    @Autowired
    private StorageBuildingService storageBuildingService;

    /**
     * 列表
     */
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    @ApiOperation("住房列表")
    @RequiresPermissions("storage:storagebuilding:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = storageBuildingService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/info/{buildingid}", method = {RequestMethod.GET})
    @ApiOperation("住房信息")
    @RequiresPermissions("storage:storagebuilding:info")
    public R info(@PathVariable("buildingid") String buildingid) {
        StorageBuildingEntity storageBuilding = storageBuildingService.getById(buildingid);

        return R.ok().put("storageBuilding", storageBuilding);
    }

    /**
     * 保存
     */
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    @ApiOperation("新增住房")
    @RequiresPermissions("storage:storagebuilding:save")
    public R save(@RequestBody StorageBuildingEntity storageBuilding) {
        storageBuilding.setUserid(getUserId());
        storageBuildingService.save(storageBuilding);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update", method = {RequestMethod.PUT})
    @ApiOperation("修改住房信息")
    @RequiresPermissions("storage:storagebuilding:update")
    public R update(@RequestBody StorageBuildingEntity storageBuilding) {
        storageBuildingService.updateById(storageBuilding);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    @ApiOperation("删除住房信息")
    @RequiresPermissions("storage:storagebuilding:delete")
    public R delete(@RequestBody String[] buildingids) {
        storageBuildingService.removeByIds(Arrays.asList(buildingids));

        return R.ok();
    }

}
