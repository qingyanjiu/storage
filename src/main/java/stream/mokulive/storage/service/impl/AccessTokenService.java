package stream.mokulive.storage.service.impl;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import stream.mokulive.storage.mapper.AccessTokenMapper;
import stream.mokulive.storage.service.IAccessTokenService;
import stream.mokulive.storage.utils.AccessTokenHelper;
import stream.mokulive.storage.vo.AccessToken;

@Service
public class AccessTokenService implements IAccessTokenService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${custom.token.expireThreshold}")
    private int expireThreshold;

    @Autowired
    private AccessTokenMapper accessTokenMapper;


    @Autowired
    private AccessTokenHelper accessTokenHelper;


    @Override
    public void updateAccessToken() {
        String accessToken = null;
        int count = accessTokenMapper.accessTokenCount();
        if(count == 0){
            try {
                logger.info("access token记录不存在，准备获取access token并开始插入新记录");
                accessToken = accessTokenHelper.getAccessToken();
                accessTokenMapper.insertAccessToken(accessToken);
                logger.info("插入access token成功");
            } catch (UnirestException e) {
                logger.error("获取新access token出错 -- accessTokenMapper.insertAccessToken", e);
            }
        }
        else if(count == 1){
            boolean isNeedUpdate = accessTokenMapper.isTokenNeedToUpdate(expireThreshold);
            if(isNeedUpdate) {
                try {
                    logger.info("access token即将过期,准备获取access token并开始更新");
                    accessToken = accessTokenHelper.getAccessToken();
                    accessTokenMapper.updateAccessToken(accessToken);
                    logger.info("access token更新成功");
                } catch (UnirestException e) {
                    logger.error("获取新access token出错 -- accessTokenMapper.updateAccessToken", e);
                }
            }
        }
    }

    @Override
    public AccessToken getAccessToken() {
        return accessTokenMapper.getAccessToken();
    }
}
