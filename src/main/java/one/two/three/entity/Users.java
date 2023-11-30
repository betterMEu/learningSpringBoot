package one.two.three.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName users
 */
@TableName(value ="users")
@Data
public class Users implements Serializable {
    /**
     * 
     */
    @TableId(value = "USERNAME")
    private String USERNAME;

    /**
     * 
     */
    @TableField(value = "PASSWORD")
    private String PASSWORD;

    /**
     * 
     */
    @TableField(value = "ENABLED")
    private Integer ENABLED;

    /**
     * 逻辑删除
     */
    @TableField(value = "DELETED")
    private Integer DELETED;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}