<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.test;

import com.ratel.common.model.base.Result;
import ${basepackage}.api.domain.*;
import ${basepackage}.api.model.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import ${basepackage}.api.query.*;
import com.ratel.common.model.page.Pagination;
import com.ratel.common.model.MoChecker;

public class ${className}ApiTest extends BaseTest {
    @Autowired
    private ${className}Api api;
	
	@Test
	public void testAll(){
		add${className}();
		get${className}ById();
		update${className}();
		get${className}ListByCondition();
		get${className}PageListByCondition();
		del${className}ById();
	}

    @Test
    public void add${className}() {
		${className} entity = new ${className}();
		<#list table.columns as column>  
		entity.set${column.columnName}();
		</#list>  
        Result<${className}> result = api.add${className}(entity, "test");
        Assert.assertTrue(result.getResult().getId() != null);
    }
	
	
	@Test
    public void get${className}ById() {
		Result<${className}> result = api.get${className}ById(1, "test");
        Assert.assertTrue(result.getResult() != null);
    }
	
	@Test
    public void update${className}() {
		${className} entity = new ${className}();
        entity.setId(1);
        <#list table.columns as column>  
		entity.set${column.columnName}();
		</#list>  
        Result<Boolean> result = api.update${className}(entity,"test");
        Assert.assertTrue(result.isSuccess());
    }
	
	@Test
    public void get${className}ListByCondition() {
		${className}SearchParameter searchVo = new ${className}SearchParameter();
		<#list table.columns as column>  
		searchVo.set${column.columnName}();
		</#list>  
		Result<List<${className}>> result = api.get${className}ListByCondition(searchVo,"test");
		Assert.assertTrue(result.getResult().size()>0);
    }
	
	@Test
	public void get${className}PageListByCondition(){
		Pagination pagination = new Pagination();
        pagination.setPage(1);
        pagination.setPageSize(10);
		
		${className}SearchParameter searchVo = new ${className}SearchParameter();
		<#list table.columns as column>  
		searchVo.set${column.columnName}();
		</#list>  
		
		Result<Pagination<${className}>> list = api.get${className}PageListByCondition(searchVo,pagination,"test");
        Assert.assertTrue(list.getResult().getTotalPage()>0);
	}
	
	@Test
    public void del${className}ById() {
		Result<Boolean> result = api.del${className}ById(1,"test");
		Assert.assertTrue(result.isSuccess());
    }
}
