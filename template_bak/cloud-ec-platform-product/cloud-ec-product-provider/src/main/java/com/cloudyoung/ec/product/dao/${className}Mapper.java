<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao;

import ${basepackage}.dao.BaseMapper;
import org.springframework.stereotype.Repository;
import ${basepackage}.model.${className};
import ${basepackage}.model.${className}Example;

<#include "/java_copyright.include">
@Repository
public interface ${className}Mapper extends  BaseMapper<${className}, ${className}Example> {
	
}
