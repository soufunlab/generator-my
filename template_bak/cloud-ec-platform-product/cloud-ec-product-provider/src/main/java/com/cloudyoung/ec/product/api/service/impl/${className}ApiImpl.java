<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.api.service.impl;

import ${basepackage}.api.service.${className}Api;
import org.springframework.stereotype.Service;

<#include "/java_copyright.include">
@Service("${classNameLower}Api")
public class ${className}ApiImpl implements ${className}Api {
	
	private static LogUtil logger = LogUtil.build(${className}ApiImpl.class);
	
	@Autowired
    private ${className}Service service;
	
	@Override
	public Result<${className}> get${className}ById(${table.getPkColumn().javaType} id, String sessionId){
		try {
            if (id != null) {
				return new Result(ProductErrorConstants.ERRCODE_100001,ProductErrorConstants.ERRMSG_100001);
            }

            ${className} result = service.selectByPrimaryKey(id);
            if (result != null) {
                return new Result<${className}>(result);
            }
            return new Result(ProductErrorConstants.ERRCODE_100004, ProductErrorConstants.ERRMSG_100004);
        } catch (Exception ex) {
            logger.error("get${className}", ex);
            return new Result(ProductErrorConstants.ERRCODE_100000, ProductErrorConstants.ERRMSG_100000);
        }
	}
	
	@Override
	public Result<${className}> add${className}(${className} entity, String sessionId){
		
        try {
            String cs = entity.check(ParentModel.InsertMode);
            if (StringUtils.isNotEmpty(cs)) {
                return new Result(ProductErrorConstants.ERRCODE_100001,
                        cs + ProductErrorConstants.ERRMSG_100001);
            }

            ${className} result = service.add${className}(entity);
            if (result != null) {
                return new Result<${className}>(result);
            }
            return new Result(ProductErrorConstants.ERRCODE_100004, ProductErrorConstants.ERRMSG_100004);
        } catch (Exception ex) {
            logger.error("add${className}", ex);
            return new Result(ProductErrorConstants.ERRCODE_100000, ProductErrorConstants.ERRMSG_100000);
        }
    }
	
	@Override
	public Result<Boolean> del${className}ById(${table.getPkColumn().javaType} id, String sessionId) {
		
        try {

            if (id != null) {
                return new Result(ProductErrorConstants.ERRCODE_100001,ProductErrorConstants.ERRMSG_100001);
            }
			
			${className} entity = service.selectByPrimaryKey(id);
			if (entity != null) {
				entity.setIsActive(0);
				int count = service.updateByPrimaryKeySelective(entity);
				if (count > 0) {
					return new Result<Boolean>(true);
				}
			}
            return new Result(ProductErrorConstants.ERRCODE_100004, ProductErrorConstants.ERRMSG_100004);
        } catch (Exception ex) {
            logger.error("updateProductGoods", ex);
            return new Result(ProductErrorConstants.ERRCODE_100000, ProductErrorConstants.ERRMSG_100000);
        }
    }
	
	@Override
	public Result<Boolean> update${className}(${className} entity, String sessionId){
		
        try {
            String cs = entity.check(ParentModel.UpdateMode);
            if (StringUtils.isNotEmpty(cs)) {
               return new Result(ProductErrorConstants.ERRCODE_100001,
                       cs + ProductErrorConstants.ERRMSG_100001);
            }
			
			int count = service.updateByPrimaryKeySelective(entity);
            if (count > 0) {
                return new Result(true);
            }
			
            return new Result(ProductErrorConstants.ERRCODE_100004, ProductErrorConstants.ERRMSG_100004);
        } catch (Exception ex) {
            logger.error("update${className}", ex);
            return new Result(ProductErrorConstants.ERRCODE_100000, ProductErrorConstants.ERRMSG_100000);
        }
    }
	
	@Override
	public Result<List<${className}>> get${className}VoListByCondition(${className}SearchParameter searchVo,String sessionId){
        try {
            if (searchVo == null) {
                return new Result(ProductErrorConstants.ERRCODE_100001,
                        "searchVo" + ProductErrorConstants.ERRMSG_100001);
            }
            List<${className}Vo> list = service.get${className}VoListByCondition(searchVo);
            return new Result<List<ProductGoodsVo>>(list);
        } catch (Exception ex) {
            logger.error("get${className}VoListByCondition", ex);
            return new Result(ProductErrorConstants.ERRCODE_100000, ProductErrorConstants.ERRMSG_100000);
        }
    }
	
	@Override
	public Result<Pagination<${className}>> get${className}VoPageListByCondition(${className}SearchParameter searchVo,Pagination page,String sessionId){
		try {
            if (searchVo == null||page == null) {
                return new Result(ProductErrorConstants.ERRCODE_100001,
                        "searchVo+page" + ProductErrorConstants.ERRMSG_100001);
            }
            Pagination<${className}Vo> list = service.get${className}VoPageListByCondition(searchVo,page);
            return new Result<Pagination<ProductGoodsVo>>(list);
        } catch (Exception ex) {
            logger.error("get${className}VoListByCondition", ex);
            return new Result(ProductErrorConstants.ERRCODE_100000, ProductErrorConstants.ERRMSG_100000);
        }
	}
}
