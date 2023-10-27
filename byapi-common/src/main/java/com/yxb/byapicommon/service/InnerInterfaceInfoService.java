package com.yxb.byapicommon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yxb.byapicommon.model.entity.InterfaceInfo;


/**
* @author 22617
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-09-18 21:41:43
*/
public interface InnerInterfaceInfoService {

    /**
     * 从数据库中查询模拟接口是否存在（请求路径、请求方法）
     * @param path
     * @param method
     * @return
     */
    InterfaceInfo getInterfaceInfo(String path, String method);

}
