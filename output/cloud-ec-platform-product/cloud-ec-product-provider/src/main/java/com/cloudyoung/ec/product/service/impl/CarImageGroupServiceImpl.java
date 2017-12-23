package com.cloudyoung.ec.car.service.impl;

import com.cloudyoung.ec.car.service.impl.BaseServiceImpl;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cloudyoung.ec.car.model.CarImageGroup;
import com.cloudyoung.ec.car.model.CarImageGroupExample;
import com.cloudyoung.ec.car.service.CarImageGroupService;

/*
 * Description:
 * All Rights Reserved.
 * @version 1.0 2017/10/18 02:33  by  李浩（lihao@cloud-young.com）创建
 */

@Service("carImageGroupService")
@Transactional
public class CarImageGroupServiceImpl extends  BaseServiceImpl<CarImageGroup, CarImageGroupExample> implements CarImageGroupService {
	

}
