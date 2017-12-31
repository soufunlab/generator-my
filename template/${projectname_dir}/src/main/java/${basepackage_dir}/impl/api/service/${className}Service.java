<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.impl.api.service;

import ${basepackage}.impl.api.service.BaseService;
import ${basepackage}.api.model.*;
import ${basepackage}.api.query.*;
import java.util.List;
import com.ratel.common.model.page.Pagination;

<#include "/java_copyright.include">
public interface ${className}Service extends BaseService<${className}, ${className}Example> {
	
	/**
	 * @Description:
	 * @version 1.0 <#if now??>${now?string('yyyy/MM/dd hh:mm')}</#if> by 李浩（lihao@cloud-young.com）创建
	 * @param searchVo
	 * @return
	 */
	List<${className}> get${className}ListByCondition(${className}SearchParameter searchVo);
	
	/**
	 * @Description:
	 * @version 1.0 <#if now??>${now?string('yyyy/MM/dd hh:mm')}</#if> by 李浩（lihao@cloud-young.com）创建
	 * @param searchVo
	 * @param page
	 * @return
	 */	
	Pagination<${className}> get${className}PageListByCondition(${className}SearchParameter searchVo,Pagination page);
}
