package stream.mokulive.storage.service;

import stream.mokulive.storage.vo.AccessToken;

public interface IAccessTokenService {

    void updateAccessToken();

    AccessToken getAccessToken();
}
