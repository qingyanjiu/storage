package live.moku.storage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 物品标签表

 * 
 * @author LL
 * @email qingyanjiu@hotmail.com
 * @date 2020-10-26 13:24:58
 */
@Data
@TableName("storage_type")
public class StorageTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String typeid;
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
