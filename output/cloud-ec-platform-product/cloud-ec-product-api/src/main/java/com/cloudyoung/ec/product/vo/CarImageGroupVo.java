package com.cloudyoung.ec.car.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.Serializable;

/*
 * Description:
 * All Rights Reserved.
 * @version 1.0 2017/10/18 02:33  by  李浩（lihao@cloud-young.com）创建
 */

public class CarImageGroupVo implements Serializable {


	//alias
	private Integer id;  
	/**
	*分组名称
	*/
	private String groupName;  
	/**
	*
	*/
	private Integer isActive;  
	/**
	*分组唯一标识不能重复
	*/
	private String filterKey;  
	/**
	*创建时间
	*/
	private Date createTime;  
	/**
	*修改时间
	*/
	private Date updateTime;  
	

    
    public void setId(Integer id) {  
        this.id = id;  
    }  
      
    public Integer getId() {  
        return this.id;  
    }  
    
    public void setGroupName(String groupName) {  
        this.groupName = groupName;  
    }  
      
    public String getGroupName() {  
        return this.groupName;  
    }  
    
    public void setIsActive(Integer isActive) {  
        this.isActive = isActive;  
    }  
      
    public Integer getIsActive() {  
        return this.isActive;  
    }  
    
    public void setFilterKey(String filterKey) {  
        this.filterKey = filterKey;  
    }  
      
    public String getFilterKey() {  
        return this.filterKey;  
    }  
    
    public void setCreateTime(Date createTime) {  
        this.createTime = createTime;  
    }  
      
    public Date getCreateTime() {  
        return this.createTime;  
    }  
    
    public void setUpdateTime(Date updateTime) {  
        this.updateTime = updateTime;  
    }  
      
    public Date getUpdateTime() {  
        return this.updateTime;  
    }  
	
	

}
