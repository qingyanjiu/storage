package stream.mokulive.storage.mapper.bean;

public class GoodsMapperBean {
    /**
     * 物品 id
     */
    private String goodsId;
    /**
     * 用户 id
     */
    private String userId;
    /**
     * 物品名称
     */
    private String goodsName;
    /**
     * 物品所有者名称
     */
    private String owername;
    /**
     * 物品图片
     */
    private String picture;
    /**
     * 物品收纳位置说明
     */
    private String location;
    /**
     * 物品类型，一个物品只有一个类型
     */
    private double typeId;
    /**
     * 物品标签,一个物品可以有多个标签，tagid用逗号隔开
     */
    private double tagId;
    /**
     * 热点Id
     */
    private double hotPointId;
    /**
     * 价格
     */
    private double price;
    /**
     * 购买时间
     */
    private String buyTime;
    /**
     * 最近修改时间
     */
    private String modifyTime;
    /**
     * 备注
     */
    private String goodsComment;
    /**
     * 物品状态 (1-有效 0-失效)
     */
    private String goodsStatus;



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
    private String hotPointComment;
    /**
     * 状态 (1-有效 0-失效)
     */
    private String hotPointStatus;



    private String typeName;

    private String parentTypeId;

    private String typeComment;

    private String buildingName;

    private String planPicture;

    private String buildingComment;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getOwername() {
        return owername;
    }

    public void setOwername(String owername) {
        this.owername = owername;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getTypeId() {
        return typeId;
    }

    public void setTypeId(double typeId) {
        this.typeId = typeId;
    }

    public double getTagId() {
        return tagId;
    }

    public void setTagId(double tagId) {
        this.tagId = tagId;
    }

    public double getHotPointId() {
        return hotPointId;
    }

    public void setHotPointId(double hotPointId) {
        this.hotPointId = hotPointId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getGoodsComment() {
        return goodsComment;
    }

    public void setGoodsComment(String goodsComment) {
        this.goodsComment = goodsComment;
    }

    public String getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(String goodsStatus) {
        this.goodsStatus = goodsStatus;
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

    public String getHotPointComment() {
        return hotPointComment;
    }

    public void setHotPointComment(String hotPointComment) {
        this.hotPointComment = hotPointComment;
    }

    public String getHotPointStatus() {
        return hotPointStatus;
    }

    public void setHotPointStatus(String hotPointStatus) {
        this.hotPointStatus = hotPointStatus;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getParentTypeId() {
        return parentTypeId;
    }

    public void setParentTypeId(String parentTypeId) {
        this.parentTypeId = parentTypeId;
    }

    public String getTypeComment() {
        return typeComment;
    }

    public void setTypeComment(String typeComment) {
        this.typeComment = typeComment;
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

    public String getBuildingComment() {
        return buildingComment;
    }

    public void setBuildingComment(String buildingComment) {
        this.buildingComment = buildingComment;
    }
}
