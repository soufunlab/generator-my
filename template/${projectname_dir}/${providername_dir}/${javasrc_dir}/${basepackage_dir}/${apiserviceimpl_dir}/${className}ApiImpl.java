<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.api.service.impl;

import ${basepackage}.api.service.${className}Api;
import ${basepackage}.service.*;
import org.springframework.stereotype.Service;
import ${basepackage}.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import ${basepackage}.service.*;
import ${basepackage}.model.*;
import com.cloudyoung.ec.common.model.base.Result;
import com.cloudyoung.ec.common.model.base.ParentModel;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import ${basepackage}.constants.*;
import ${basepackage}.parameter.*;
import com.cloudyoung.ec.common.model.page.Pagination;

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
				return new Result(${errconstants}.ERRCODE_100001,${errconstants}.ERRMSG_100001);
            }

            ${className} result = service.selectByPrimaryKey(id);
            if (result != null) {
                return new Result<${className}>(result);
            }
            return new Result(${errconstants}.ERRCODE_100002, ${errconstants}.ERRMSG_100002);
        } catch (Exception ex) {
            logger.error("get${className}", ex);
            return new Result(${errconstants}.ERRCODE_100000, ${errconstants}.ERRMSG_100000);
        }
	}
	
	@Override
	public Result<${className}> add${className}(${className} entity, String sessionId){
		
        try {
            String cs = entity.check(ParentModel.InsertMode);
            if (StringUtils.isNotEmpty(cs)) {
                return new Result(${errconstants}.ERRCODE_100001,
                        cs + ${errconstants}.ERRMSG_100001);
            }

            int count = service.insertSelective(entity);
            if (count > 0) {
                return new Result<${className}>(entity);
            }
            return new Result(${errconstants}.ERRCODE_100002, ${errconstants}.ERRMSG_100002);
        } catch (Exception ex) {
            logger.error("add${className}", ex);
            return new Result(${errconstants}.ERRCODE_100000, ${errconstants}.ERRMSG_100000);
        }
    }
	
	@Override
	public Result<Boolean> del${className}ById(${table.getPkColumn().javaType} id, String sessionId) {
        try {
            if (id == null) {
                return new Result(${errconstants}.ERRCODE_100001,${errconstants}.ERRMSG_100001);
            }
			
			${className} entity = service.selectByPrimaryKey(id);
			if (entity != null) {
				entity.setIsActive(0);
				int count = service.updateByPrimaryKeySelective(entity);
				if (count > 0) {
					return new Result<Boolean>(true);
				}
			}
            return new Result(${errconstants}.ERRCODE_100002, ${errconstants}.ERRMSG_100002);
        } catch (Exception ex) {
            logger.error("updateProductGoods", ex);
            return new Result(${errconstants}.ERRCODE_100000, ${errconstants}.ERRMSG_100000);
        }
    }
	
	@Override
	public Result<Boolean> update${className}(${className} entity, String sessionId){
		
        try {
            String cs = entity.check(ParentModel.UpdateMode);
            if (StringUtils.isNotEmpty(cs)) {
               return new Result(${errconstants}.ERRCODE_100001,
                       cs + ${errconstants}.ERRMSG_100001);
            }
			
			int count = service.updateByPrimaryKeySelective(entity);
            if (count > 0) {
                return new Result(true);
            }
			
            return new Result(${errconstants}.ERRCODE_100002, ${errconstants}.ERRMSG_100002);
        } catch (Exception ex) {
            logger.error("update${className}", ex);
            return new Result(${errconstants}.ERRCODE_100000, ${errconstants}.ERRMSG_100000);
        }
    }
	
	@Override
	public Result<List<${className}>> get${className}ListByCondition(${className}SearchParameter searchVo,String sessionId){
        try {
            if (searchVo == null) {
                return new Result(${errconstants}.ERRCODE_100001,
                        "searchVo" + ${errconstants}.ERRMSG_100001);
            }
            List<${className}> list = service.get${className}ListByCondition(searchVo);
            return new Result<List<${className}>>(list);
        } catch (Exception ex) {
            logger.error("get${className}ListByCondition", ex);
            return new Result(${errconstants}.ERRCODE_100000, ${errconstants}.ERRMSG_100000);
        }
    }
	
	@Override
	public Result<Pagination<${className}>> get${className}PageListByCondition(${className}SearchParameter searchVo,Pagination page,String sessionId){
		try {
            if (searchVo == null||page == null) {
                return new Result(${errconstants}.ERRCODE_100001,
                        "searchVo+page" + ${errconstants}.ERRMSG_100001);
            }
            Pagination<${className}> list = service.get${className}PageListByCondition(searchVo,page);
            return new Result<Pagination<${className}>>(list);
        } catch (Exception ex) {
            logger.error("get${className}VoListByCondition", ex);
            return new Result(${errconstants}.ERRCODE_100000, ${errconstants}.ERRMSG_100000);
        }
	}
}
