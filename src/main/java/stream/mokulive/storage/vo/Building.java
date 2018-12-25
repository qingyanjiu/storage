package stream.mokulive.storage.vo;

/**
 * 基础数据，保存物品类型或者标签的信息
 */
public class Building {

    private static final String BUILDING_STATUS_ENABLED = "1";
    private static final String BUILDING_STATUS_DISABLED = "0";

    private String buildingId;

    private String userId;

    private String buildingName;

    private String planPicture;

    private String comment;

    private String status = BUILDING_STATUS_ENABLED;

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getPlanPicture() {
        return planPicture;
    }

    public void setPlanPicture(String planPicture) {
        this.planPicture = planPicture;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
