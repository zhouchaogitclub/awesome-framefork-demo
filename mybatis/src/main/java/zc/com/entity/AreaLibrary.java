package zc.com.entity;

import lombok.ToString;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * 地址库表(AreaLibrary)实体类
 *
 * @author yeyu
 * @since 2021-12-24 17:57:10
 */
@ToString
public class AreaLibrary implements Serializable {
    private static final long serialVersionUID = 171225205137815380L;
    /**
     * 地区代码
     */
    private Integer code;
    /**
     * 地区自增id
     */
    private Long id;
    /**
     * 地区名称
     */
    private String name;
    /**
     * 地区父级代码
     */
    private Integer pid;
    /**
     * 地区级别
     */
    private Integer level;
    /**
     * 是否弃用 0:未弃用、1:已弃用
     */
    private Integer isDelete;
    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;
    /**
     * 修改时间
     */
    private LocalDateTime gmtModify;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(LocalDateTime gmtModify) {
        this.gmtModify = gmtModify;
    }

}