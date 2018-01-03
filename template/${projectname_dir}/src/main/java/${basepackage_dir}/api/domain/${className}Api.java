<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.api.domain;

import com.ratel.common.model.base.Result;
import com.ratel.common.model.page.Pagination;
import ${basepackage}.api.model.*;
import ${basepackage}.api.query.*;

import java.util.List;

<#include "/java_copyright.include">
public interface ${className}Api {
	
	/**
	* @Description:
	* @version 1.0 <#if now??>${now?string('yyyy/MM/dd hh:mm')}</#if> by 李浩（lihao@cloud-young.com）创建
	* @param entity
	* @return
	*/
	Result<${className}> add${className}(${className} entity);
	
	/**
	* @Description:
	* @version 1.0 <#if now??>${now?string('yyyy/MM/dd hh:mm')}</#if> by 李浩（lihao@cloud-young.com）创建
	* @param id
	* @return
	*/
	Result<Boolean> del${className}ById(${table.getPkColumn().javaType} id);
	
	/**
	* @Description:
	* @version 1.0 <#if now??>${now?string('yyyy/MM/dd hh:mm')}</#if> by 李浩（lihao@cloud-young.com）创建
	* @param id
	* @return
	*/
	Result<${className}> get${className}ById(${table.getPkColumn().javaType} id);
	
	/**
	 * @Description:
	 * @version 1.0 <#if now??>${now?string('yyyy/MM/dd hh:mm')}</#if> by 李浩（lihao@cloud-young.com）创建
	 * @param entity
	 * @return
	 */
	Result<Boolean> update${className}(${className} entity);
	
	/**
	 * @Description:
	 * @version 1.0 <#if now??>${now?string('yyyy/MM/dd hh:mm')}</#if> by 李浩（lihao@cloud-young.com）创建
	 * @param searchVo
	 * @return
	 */
	Result<List<${className}>> get${className}ListByCondition(${className}SearchParameter searchVo);
	
	/**
	 * @Description:
	 * @version 1.0 <#if now??>${now?string('yyyy/MM/dd hh:mm')}</#if> by 李浩（lihao@cloud-young.com）创建
	 * @param searchVo
	 * @param page
	 * @return
	 */
	Result<Pagination<${className}>> get${className}PageListByCondition(${className}SearchParameter searchVo,Pagination page);
}
