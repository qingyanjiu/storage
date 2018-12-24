package stream.mokulive.storage.mapper;

import org.springframework.stereotype.Repository;
import stream.mokulive.storage.vo.AccessToken;

@Repository
public interface AccessTokenMapper {

    /**
     * 获取数据库中是否有access token记录 有-1 没有 0
     * @return
     */
    int accessTokenCount();

    /**
     * 插入access token记录
     * @param accessToken
     */
    void insertAccessToken(String accessToken);

    /**
     * 查询数据库中access token是否即将过期
     * @param expireThreshold 过期阈值，例如 28 代表28天过期，就直接更新
     * @return
     */
    boolean isTokenNeedToUpdate(int expireThreshold);

    /**
     * 更新access token
     * @param accessToken
     */
    void updateAccessToken(String accessToken);

    /**
     * 获取数据库中的access token
     */
    AccessToken getAccessToken();

}
