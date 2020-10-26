package live.moku.storage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author LL
 * @email qingyanjiu@hotmail.com
 * @date 2020-10-26 13:24:58
 */
@Data
@TableName("storage_tag")
public class StorageTagEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String tagid;
	/**
	 * 类型的显示名称
	 */
	private String tagname;
	/**
	 * 
	 */
	private String tagcomment;

}
