package live.moku.storage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 物品表
 * 
 * @author LL
 * @email qingyanjiu@hotmail.com
 * @date 2020-10-26 13:24:58
 */
@Data
@TableName("storage_goods")
public class StorageGoodsEntity implements Serializable {
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
	private String goodname;
	/**
	 * 所有者名字
	 */
	private String owername;
	/**
	 * 物品图片
	 */
	private String picture;
	/**
	 * 热点id
	 */
	private String hotpointid;
	/**
	 * 物品收纳位置
	 */
	private String location;
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
	private String comment;
	/**
	 * 物品状态
	 */
	private String status;

}
