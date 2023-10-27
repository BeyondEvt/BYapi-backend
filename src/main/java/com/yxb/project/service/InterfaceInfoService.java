package com.yxb.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yxb.byapicommon.model.entity.InterfaceInfo;

/**
* @author 22617
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-09-18 21:41:43
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
