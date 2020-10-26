package live.moku.storage.controller;

import java.util.Arrays;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import live.moku.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import live.moku.storage.entity.StorageTagEntity;
import live.moku.storage.service.StorageTagService;
import live.moku.common.utils.PageUtils;
import live.moku.common.utils.R;



/**
 * 
 *
 * @author LL
 * @email qingyanjiu@hotmail.com
 * @date 2020-10-26 13:24:58
 */
@RestController
@RequestMapping("storage/storagetag")
@Api("标签接口")
public class StorageTagController extends AbstractController {
    @Autowired
    private StorageTagService storageTagService;

    /**
     * 列表
     */
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    @ApiOperation("标签列表")
    @RequiresPermissions("storage:storagetag:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = storageTagService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/info/{tagid}", method = {RequestMethod.GET})
    @ApiOperation("标签信息")
    @RequiresPermissions("storage:storagetag:info")
    public R info(@PathVariable("tagid") String tagid){
		StorageTagEntity storageTag = storageTagService.getById(tagid);

        return R.ok().put("storageTag", storageTag);
    }

    /**
     * 保存
     */
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    @ApiOperation("新增标签")
    @RequiresPermissions("storage:storagetag:save")
    public R save(@RequestBody StorageTagEntity storageTag){
		storageTagService.save(storageTag);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update", method = {RequestMethod.PUT})
    @ApiOperation("更新标签")
    @RequiresPermissions("storage:storagetag:update")
    public R update(@RequestBody StorageTagEntity storageTag){
		storageTagService.updateById(storageTag);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    @ApiOperation("删除标签")
    @RequiresPermissions("storage:storagetag:delete")
    public R delete(@RequestBody String[] tagids){
		storageTagService.removeByIds(Arrays.asList(tagids));

        return R.ok();
    }

}
