package stream.mokulive.storage.vo;

public class Goods {

    private static final String GOODS_STATUS_ENABLED = "1";
    private static final String GOODS_STATUS_DISABLED = "0";

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
    private String owerName;
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
    private String typeId;
    /**
     * 物品标签,一个物品可以有多个标签，tagid用逗号隔开
     */
    private String tag;
    /**
     * 热点Id
     */
    private String hotPointId;
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
     * 丢弃时间
     */
    private String throwTime;
    /**
     * 备注
     */
    private String comment;
    /**
     * 物品状态 (1-有效 0-失效)
     */
    private String status = GOODS_STATUS_ENABLED;

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

    public String getOwerName() {
        return owerName;
    }

    public void setOwerName(String owerName) {
        this.owerName = owerName;
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

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getHotPointId() {
        return hotPointId;
    }

    public void setHotPointId(String hotPointId) {
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

    public String getThrowTime() {
        return throwTime;
    }

    public void setThrowTime(String throwTime) {
        this.throwTime = throwTime;
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
