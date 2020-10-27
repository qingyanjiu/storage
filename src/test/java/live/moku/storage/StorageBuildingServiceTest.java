package live.moku.storage;

import live.moku.storage.entity.StorageBuildingEntity;
import live.moku.storage.service.StorageBuildingService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StorageBuildingServiceTest {
    @Autowired
    private StorageBuildingService storageBuildingService;

    @Test
    public void testQryUserBuildings() {
        List<StorageBuildingEntity> buildings = storageBuildingService.qryUserBuildings(1);
        System.out.println(buildings);
        Assertions.assertTrue(buildings != null && buildings.size() > 0);
    }
}
