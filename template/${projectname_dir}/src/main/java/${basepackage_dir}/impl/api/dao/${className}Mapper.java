<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.impl.api.dao;

import ${basepackage}.impl.api.dao.BaseMapper;
import org.springframework.stereotype.Repository;
import ${basepackage}.api.model.*;

<#include "/java_copyright.include">
@Repository
public interface ${className}Mapper extends  BaseMapper<${className}, ${className}Example> {
	
}
