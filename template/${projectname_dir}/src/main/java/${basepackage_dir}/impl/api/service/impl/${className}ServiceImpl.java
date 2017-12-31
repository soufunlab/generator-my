<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.impl.api.service.impl;

import ${basepackage}.impl.api.service.impl.BaseServiceImpl;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ${basepackage}.api.model.${className};
import ${basepackage}.api.model.${className}Example;
import ${basepackage}.impl.api.service.${className}Service;
import ${basepackage}.api.query.*;
import java.util.List;
import com.ratel.common.model.page.Pagination;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Date;
import java.math.*;

<#include "/java_copyright.include">
@Service("${classNameLower}Service")
@Transactional
public class ${className}ServiceImpl extends  BaseServiceImpl<${className}, ${className}Example> implements ${className}Service {
	
	@Override
	public List<${className}> get${className}ListByCondition(${className}SearchParameter searchVo){
		
		${className}Example example = new ${className}Example();
		example.setOrderByClause(searchVo.getOrderByClause());
		
        ${className}Example.Criteria criteria = example.createCriteria();
        criteria.andIsActiveEqualTo(1);
		
		//手动书写逻辑，判断非空（字符串需判断""）才加入筛选条件
		<#list table.columns as column>   
		${column.simpleJavaType} ${column.columnNameLower} = searchVo.get${column.columnName}();
		if(${column.columnNameLower} != null){
			criteria.and${column.columnName}EqualTo(searchVo.get${column.columnName}());
		}
		</#list> 
		
		List<${className}> list = this.selectByExample(example);
		return list;
	}
	
	@Override
	public Pagination<${className}> get${className}PageListByCondition(${className}SearchParameter searchVo,Pagination page){
		
		${className}Example example = new ${className}Example();
		example.setOrderByClause(searchVo.getOrderByClause());
		
        ${className}Example.Criteria criteria = example.createCriteria();
        criteria.andIsActiveEqualTo(1);
		
		PageHelper.startPage(page.getPage(), page.getPageSize());
		
		//手动书写逻辑，判断非空（字符串需判断""）才加入筛选条件
		<#list table.columns as column>   
		${column.simpleJavaType} ${column.columnNameLower} = searchVo.get${column.columnName}();
		if(${column.columnNameLower} != null){
			criteria.and${column.columnName}EqualTo(searchVo.get${column.columnName}());
		}
		</#list> 
		
		List<${className}> list = this.selectByExample(example);
		
		PageInfo pageInfo = new PageInfo(list);
		page.setContent(list);
		page.setDataNumber(pageInfo.getTotal());
        return page;
		
	}

}
