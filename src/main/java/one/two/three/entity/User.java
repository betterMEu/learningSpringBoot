package one.two.three.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

/**
 * 
 * @TableName users
 */
@TableName(value ="users")
@Data
@Builder
public class User implements Serializable {
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

    @TableField(value = "DELETED")
    private String DELETED;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}