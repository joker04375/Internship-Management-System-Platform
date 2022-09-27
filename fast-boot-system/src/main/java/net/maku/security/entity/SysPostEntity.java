package net.maku.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.common.entity.BaseEntity;

/**
 * 岗位管理
 *
 * @author 阿沐 babamu@126.com
 */
@Data
public class SysPostEntity extends BaseEntity {
	/**
	* 岗位编码
	*/
	private String postCode;
	/**
	* 岗位名称
	*/
	private String postName;
	/**
	* 排序
	*/
	private Integer sort;
	/**
	* 状态  0：停用   1：正常
	*/
	private Integer status;

}