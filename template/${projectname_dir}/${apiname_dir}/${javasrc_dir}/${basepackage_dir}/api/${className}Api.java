<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.api;

import com.ratel.common.model.base.Result;
import com.ratel.common.model.page.Pagination;
import ${basepackage}.model.*;
import ${basepackage}.query.*;

import java.util.List;

<#include "/java_copyright.include">
public interface ${className}Api {
	
	/**
	* @Description:
	* @version 1.0 <#if now??>${now?string('yyyy/MM/dd hh:mm')}</#if> by 李浩（lihao@cloud-young.com）创建
	* @param entity
	* @param sessionId
	* @return
	*/
	Result<${className}> add${className}(${className} entity, String sessionId);
	
	/**
	* @Description:
	* @version 1.0 <#if now??>${now?string('yyyy/MM/dd hh:mm')}</#if> by 李浩（lihao@cloud-young.com）创建
	* @param id
	* @param sessionId
	* @return
	*/
	Result<Boolean> del${className}ById(${table.getPkColumn().javaType} id, String sessionId);
	
	/**
	* @Description:
	* @version 1.0 <#if now??>${now?string('yyyy/MM/dd hh:mm')}</#if> by 李浩（lihao@cloud-young.com）创建
	* @param id
	* @param sessionId
	* @return
	*/
	Result<${className}> get${className}ById(${table.getPkColumn().javaType} id, String sessionId);
	
	/**
	 * @Description:
	 * @version 1.0 <#if now??>${now?string('yyyy/MM/dd hh:mm')}</#if> by 李浩（lihao@cloud-young.com）创建
	 * @param entity
	 * @param sessionId
	 * @return
	 */
	Result<Boolean> update${className}(${className} entity, String sessionId);
	
	/**
	 * @Description:
	 * @version 1.0 <#if now??>${now?string('yyyy/MM/dd hh:mm')}</#if> by 李浩（lihao@cloud-young.com）创建
	 * @param searchVo
	 * @param sessionId
	 * @return
	 */
	Result<List<${className}>> get${className}ListByCondition(${className}SearchParameter searchVo,String sessionId);
	
	/**
	 * @Description:
	 * @version 1.0 <#if now??>${now?string('yyyy/MM/dd hh:mm')}</#if> by 李浩（lihao@cloud-young.com）创建
	 * @param searchVo
	 * @param page
	 * @param sessionId
	 * @return
	 */
	Result<Pagination<${className}>> get${className}PageListByCondition(${className}SearchParameter searchVo,Pagination page,String sessionId);
}
