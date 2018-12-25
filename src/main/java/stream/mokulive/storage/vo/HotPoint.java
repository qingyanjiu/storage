package stream.mokulive.storage.vo;

/**
 * 热点，可以理解为储存柜或者橱子，存放物品的容器
 */
public class HotPoint {

    private static final String HOTPOINT_STATUS_ENABLED = "1";
    private static final String HOTPOINT_STATUS_DISABLED = "0";

    /**
     * 热点id
     */
    private String id;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 建筑物id
     */
    private String buildingId;
    /**
     * 物品收纳位置 平面图起始点横坐标
     */
    private String xstart;
    /**
     * 物品收纳位置 平面图起始点纵坐标
     */
    private String ystart;
    /**
     * 物品收纳位置 平面图终止点横坐标
     */
    private String xend;
    /**
     * 物品收纳位置 平面图终止点纵坐标
     */
    private String yend;
    /**
     * 名称
     */
    private String hotPointName;
    /**
     * 备注
     */
    private String comment;
    /**
     * 状态 (1-有效 0-失效)
     */
    private String status = HOTPOINT_STATUS_ENABLED;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getXstart() {
        return xstart;
    }

    public void setXstart(String xstart) {
        this.xstart = xstart;
    }

    public String getYstart() {
        return ystart;
    }

    public void setYstart(String ystart) {
        this.ystart = ystart;
    }

    public String getXend() {
        return xend;
    }

    public void setXend(String xend) {
        this.xend = xend;
    }

    public String getYend() {
        return yend;
    }

    public void setYend(String yend) {
        this.yend = yend;
    }

    public String getHotPointName() {
        return hotPointName;
    }

    public void setHotPointName(String hotPointName) {
        this.hotPointName = hotPointName;
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
