package stream.mokulive.storage;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import stream.mokulive.storage.service.IAccessTokenService;
import stream.mokulive.storage.vo.AccessToken;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccessTokenServiceTests {

	@Autowired
	private IAccessTokenService accessTokenService;

	@Test
	public void updateAccessToken() {
		try {
			accessTokenService.updateAccessToken();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getAccessToken() {
		AccessToken accessToken = null;
		try {
			accessToken = accessTokenService.getAccessToken();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(accessToken.getAccessToken().length()>2000);
	}

}

