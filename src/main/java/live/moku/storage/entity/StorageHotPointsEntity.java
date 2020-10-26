package live.moku.storage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 热点（收纳家具）表
 * 
 * @author LL
 * @email qingyanjiu@hotmail.com
 * @date 2020-10-26 13:24:58
 */
@Data
@TableName("storage_hot_points")
public class StorageHotPointsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 用户id
	 */
	private String userid;
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
	private String comment;
	/**
	 * 状态
	 */
	private String status;

}
