<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import com.ratel.common.model.annotation.*;

<#include "/java_copyright.include">
public class ${className} implements Serializable {


	//alias
	<#list table.columns as column>  
    <#if ! column.pk>
	/**
	*${column.remarks}
	*/
	@InsertRequiredAnno
	</#if>
	<#if  column.pk>
	@UpdateRequiredAnno
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
	

}
