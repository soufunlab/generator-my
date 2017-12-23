<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.service.impl;

import ${basepackage}.service.impl.BaseServiceImpl;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ${basepackage}.model.${className};
import ${basepackage}.model.${className}Example;
import ${basepackage}.service.${className}Service;

<#include "/java_copyright.include">
@Service("${classNameLower}Service")
@Transactional
public class ${className}ServiceImpl extends  BaseServiceImpl<${className}, ${className}Example> implements ${className}Service {
	
	public List<${className}> get${className}VoListByCondition(${className}SearchParameter searchVo){
		
		${className}Example example = new ${className}Example();
        ${className}Example.Criteria criteria = example.createCriteria();
        criteria.andIsActiveEqualTo(1);
		
		//手动书写逻辑，判断非空（字符串需判断""）才加入筛选条件
		
		
		List<${className}> list = this.selectByExample(example);
		return list;
	}
	
	public Pagination<${className}> get${className}VoPageListByCondition(${className}SearchParameter searchVo,Pagination page){
		
		${className}Example example = new ${className}Example();
        ${className}Example.Criteria criteria = example.createCriteria();
        criteria.andIsActiveEqualTo(1);
		
		PageHelper.startPage(pagination.getPage(), pagination.getPageSize());
		
		//手动书写逻辑，判断非空（字符串需判断""）才加入筛选条件
		
		
		List<${className}> list = this.selectByExample(example);
		
		PageInfo page = new PageInfo(list);
        pagination.setContent(list);
        pagination.setDataNumber(page.getTotal());
        return pagination;
		
	}

}
