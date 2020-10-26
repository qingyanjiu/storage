package live.moku.storage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * VIEW
 * 
 * @author LL
 * @email qingyanjiu@hotmail.com
 * @date 2020-10-26 13:24:58
 */
@Data
@TableName("storage_view_goods")
public class StorageViewGoodsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String goodsid;
	/**
	 * 用户id
	 */
	private String userid;
	/**
	 * 物品名称
	 */
	private String goodsname;
	/**
	 * 所有者名字
	 */
	private String owername;
	/**
	 * 物品图片
	 */
	private String picture;
	/**
	 * 物品收纳位置
	 */
	private String location;
	/**
	 * 热点id
	 */
	private String hotpointid;
	/**
	 * 物品类型
	 */
	private String typeid;
	/**
	 * 物品tag
	 */
	private String tag;
	/**
	 * 购买时间
	 */
	private String buytime;
	/**
	 * 购买价格
	 */
	private String price;
	/**
	 * 丢弃时间
	 */
	private String throwtime;
	/**
	 * 最近修改时间
	 */
	private String modifytime;
	/**
	 * 备注
	 */
	private String goodscomment;
	/**
	 * 物品状态
	 */
	private String goodstatus;
	/**
	 * 建筑物id
	 */
	private String buildingid;
	/**
	 * 热点坐标
	 */
	private String xstart;
	/**
	 * 热点坐标
	 */
	private String ystart;
	/**
	 * 热点坐标
	 */
	private String xend;
	/**
	 * 热点坐标
	 */
	private String yend;
	/**
	 * 热点名称
	 */
	private String hotpointname;
	/**
	 * 热点描述
	 */
	private String hotpointcomment;
	/**
	 * 状态
	 */
	private String hotpointstatus;
	/**
	 * 建筑物名字
	 */
	private String buildingname;
	/**
	 * 平面图url
	 */
	private String planpicture;
	/**
	 * 描述
	 */
	private String buildingcomment;
	/**
	 * 类型的显示名称
	 */
	private String typename;
	/**
	 * 父类型id,如果为空说明是父类型
	 */
	private String parenttypeid;
	/**
	 * 
	 */
	private String typecomment;

}
