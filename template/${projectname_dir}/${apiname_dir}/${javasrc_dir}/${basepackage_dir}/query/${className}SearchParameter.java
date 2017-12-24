<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.query;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.Serializable;

<#include "/java_copyright.include">
public class ${className}SearchParameter implements Serializable {

	//alias
	<#list table.columns as column>  
    <#if ! column.pk>
	/**
	*${column.remarks}
	*/
	</#if>
	private ${column.simpleJavaType} ${column.columnNameLower};  
    </#list> 
	

	<@generateJavaColumns/>
	
<#macro generateJavaColumns>  
    <#list table.columns as column>  
    
    public void set${column.columnName}(${column.simpleJavaType} ${column.columnNameLower}) {  
        this.${column.columnNameLower} = ${column.columnNameLower};  
    }  
      
    public ${column.simpleJavaType} get${column.columnName}() {  
        return this.${column.columnNameLower};  
    }  
    </#list>  
</#macro>

	//排序集合
	List<String> orderList = new ArrayList<String>();
	public String getOrderByClause(){
		if(orderList.size()>0){
			return String.join(",",orderList);
		}
		return null;
    }
	//alias
	<#list table.columns as column>  
   
	public void andOrderBy${column.columnName}ASC(){
		orderList.add("${table.getSqlName()}.${column.getSqlName()} ASC");
	}
	public void andOrderBy${column.columnName}DESC(){
		orderList.add("${table.getSqlName()}.${column.getSqlName()} DESC");
	}
    </#list> 
}
