package live.moku.storage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 建筑物表
 * 
 * @author LL
 * @email qingyanjiu@hotmail.com
 * @date 2020-10-26 13:24:58
 */
@Data
@TableName("storage_building")
public class StorageBuildingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private String buildingid;
	/**
	 * 用户id
	 */
	private Long userid;
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
	private String comment;
	/**
	 * 状态
	 */
	private String status;

}
