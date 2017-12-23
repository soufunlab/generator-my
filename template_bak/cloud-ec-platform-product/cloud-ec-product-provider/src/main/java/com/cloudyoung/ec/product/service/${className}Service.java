<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.service;

import ${basepackage}.service.BaseService;
import ${basepackage}.model.${className};
import ${basepackage}.model.${className}Example;

<#include "/java_copyright.include">
public interface ${className}Service extends BaseService<${className}, ${className}Example> {
	
	List<${className}> get${className}VoListByCondition(${className}SearchParameter searchVo);
	
	Pagination<${className}> get${className}VoPageListByCondition(${className}SearchParameter searchVo,Pagination page);
}
