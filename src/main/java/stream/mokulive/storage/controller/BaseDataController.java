package stream.mokulive.storage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import stream.mokulive.storage.service.IAccessTokenService;
import stream.mokulive.storage.service.IBaseDataService;
import stream.mokulive.storage.utils.Utils;
import stream.mokulive.storage.vo.AccessToken;
import stream.mokulive.storage.vo.BaseData;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/baseData")
@Controller
public class BaseDataController {

    @Autowired
    private IBaseDataService baseDataService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Map add(BaseData baseData) {
    	Map result = new HashMap();
        try {
            baseDataService.addBaseData(baseData);
            Utils.tagResult(result,true);
        } catch (Exception e) {
            Utils.tagResult(result,false);
        }
        return result;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Map update(BaseData baseData) {
    	Map result = new HashMap();
        try {
            baseDataService.updateBaseData(baseData);
            Utils.tagResult(result,true);
        } catch (Exception e) {
            Utils.tagResult(result,false);
        }
        return result;
    }

    @RequestMapping(value = "delete/{baseDataId}", method = RequestMethod.POST)
    @ResponseBody
    public Map delete(@PathVariable("baseDataId") String baseDataId) {
    	Map result = new HashMap();
        try {
            baseDataService.deleteBaseData(baseDataId);
            Utils.tagResult(result,true);
        } catch (Exception e) {
            Utils.tagResult(result,false);
        }
        return result;
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public Map list(String baseDataId, String dataType) {
    	Map result = new HashMap();
        try {
            baseDataService.findBaseDataList(baseDataId, dataType);
            Utils.tagResult(result,true);
        } catch (Exception e) {
            Utils.tagResult(result,false);
        }
        return result;
    }

}
