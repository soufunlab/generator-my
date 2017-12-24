<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.api.impl;

import ${basepackage}.api.${className}Api;
import ${basepackage}.service.*;
import org.springframework.stereotype.Service;
import ${basepackage}.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import ${basepackage}.service.*;
import ${basepackage}.model.*;
import com.ratel.common.model.base.Result;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import ${basepackage}.constants.*;
import ${basepackage}.query.*;
import com.ratel.common.model.page.Pagination;
import com.ratel.common.model.MoChecker;
import com.ratel.common.utils.ExceptionUtils;

<#include "/java_copyright.include">
@Service("${classNameLower}Api")
public class ${className}ApiImpl implements ${className}Api {
	
	private static LogUtil logger = LogUtil.build(${className}ApiImpl.class);
	
	@Autowired
    private ${className}Service service;
	
	@Override
	public Result<${className}> get${className}ById(${table.getPkColumn().javaType} id, String sessionId){
		try {
            if (id == null) {
				return new Result(ErroType.PARAMETER_ERROR.value(),ErroType.PARAMETER_ERROR.message());
            }

            ${className} result = service.selectByPrimaryKey(id);
            if (result != null) {
                return new Result<${className}>(result);
            }
            return new Result(ErroType.BUSINESS_ERROR.value(), ErroType.BUSINESS_ERROR.message());
        } catch (Exception ex) {
            logger.error("get${className}", ex);
            return new Result(ErroType.INNER_ERROR.value(), ErroType.INNER_ERROR.message() + ":" + ExceptionUtils.errInfo(ex));
        }
	}
	
	@Override
	public Result<${className}> add${className}(${className} entity, String sessionId){
		
        try {
            String cs = MoChecker.checkInsert(entity);
            if (StringUtils.isNotEmpty(cs)) {
                return new Result(ErroType.PARAMETER_ERROR.value(), cs + ErroType.PARAMETER_ERROR.message() + ":" + cs);
            }

            int count = service.insertSelective(entity);
            if (count > 0) {
                return new Result<${className}>(entity);
            }
            return new Result(ErroType.BUSINESS_ERROR.value(), ErroType.BUSINESS_ERROR.message());
        } catch (Exception ex) {
            logger.error("add${className}", ex);
            return new Result(ErroType.INNER_ERROR.value(), ErroType.INNER_ERROR.message() + ":" + ExceptionUtils.errInfo(ex));
        }
    }
	
	@Override
	public Result<Boolean> del${className}ById(${table.getPkColumn().javaType} id, String sessionId) {
        try {
            if (id == null) {
                return new Result(ErroType.PARAMETER_ERROR.value(),ErroType.PARAMETER_ERROR.message());
            }
			
			${className} entity = service.selectByPrimaryKey(id);
			if (entity != null) {
				entity.setIsActive(0);
				int count = service.updateByPrimaryKeySelective(entity);
				if (count > 0) {
					return new Result<Boolean>(true);
				}
			}
            return new Result(ErroType.BUSINESS_ERROR.value(), ErroType.BUSINESS_ERROR.message());
        } catch (Exception ex) {
            logger.error("updateProductGoods", ex);
            return new Result(ErroType.INNER_ERROR.value(), ErroType.INNER_ERROR.message() + ":" + ExceptionUtils.errInfo(ex));
        }
    }
	
	@Override
	public Result<Boolean> update${className}(${className} entity, String sessionId){
		
        try {
            String cs = MoChecker.checkUpdate(entity);
            if (StringUtils.isNotEmpty(cs)) {
               return new Result(ErroType.PARAMETER_ERROR.value(), cs + ErroType.PARAMETER_ERROR.message() + ":" + cs);
            }
			
			int count = service.updateByPrimaryKeySelective(entity);
            if (count > 0) {
                return new Result(true);
            }
			
            return new Result(ErroType.BUSINESS_ERROR.value(), ErroType.BUSINESS_ERROR.message());
        } catch (Exception ex) {
            logger.error("update${className}", ex);
            return new Result(ErroType.INNER_ERROR.value(), ErroType.INNER_ERROR.message() + ":" + ExceptionUtils.errInfo(ex));
        }
    }
	
	@Override
	public Result<List<${className}>> get${className}ListByCondition(${className}SearchParameter searchVo,String sessionId){
        try {
            if (searchVo == null) {
                return new Result(ErroType.PARAMETER_ERROR.value(),ErroType.PARAMETER_ERROR.message());
            }
            List<${className}> list = service.get${className}ListByCondition(searchVo);
            return new Result<List<${className}>>(list);
        } catch (Exception ex) {
            logger.error("get${className}ListByCondition", ex);
            return new Result(ErroType.INNER_ERROR.value(), ErroType.INNER_ERROR.message() + ":" + ExceptionUtils.errInfo(ex));
        }
    }
	
	@Override
	public Result<Pagination<${className}>> get${className}PageListByCondition(${className}SearchParameter searchVo,Pagination page,String sessionId){
		try {
            if (searchVo == null||page == null) {
                return new Result(ErroType.PARAMETER_ERROR.value(),ErroType.PARAMETER_ERROR.message());
            }
            Pagination<${className}> list = service.get${className}PageListByCondition(searchVo,page);
            return new Result<Pagination<${className}>>(list);
        } catch (Exception ex) {
            logger.error("get${className}VoListByCondition", ex);
            return new Result(ErroType.INNER_ERROR.value(), ErroType.INNER_ERROR.message() + ":" + ExceptionUtils.errInfo(ex));
        }
	}
}
