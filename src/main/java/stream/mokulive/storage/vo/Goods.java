package stream.mokulive.storage.vo;

public class Goods {

    private static final String GOODS_STATUS_ENABLED = "1";
    private static final String GOODS_STATUS_DISABLED = "0";

    /**
     * 物品 id
     */
    private String goodsId;
    /**
     * 物品名称
     */
    private String goodsName;
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
    private String comment;
    /**
     * 物品状态 (1-有效 0-失效)
     */
    private String status;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
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

    public double getHotPointId() {
        return hotPointId;
    }

    public void setHotPointId(double hotPointId) {
        this.hotPointId = hotPointId;
    }
}
