<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.api.service;

<#include "/java_copyright.include">
public interface ${className}Api {
	
	Result<${className}> add${className}(${className} entity, String sessionId);
	
	Result<Boolean> del${className}ById(${table.getPkColumn().javaType} id, String sessionId);
	
	Result<${className}> get${className}ById(${table.getPkColumn().javaType} id, String sessionId);
	
	Result<Boolean> update${className}(${className} entity, String sessionId);
	
	Result<List<${className}>> get${className}VoListByCondition(${className}SearchParameter searchVo,String sessionId);
	
	Result<Pagination<${className}>> get${className}VoPageListByCondition(${className}SearchParameter searchVo,Pagination page,String sessionId);
}
