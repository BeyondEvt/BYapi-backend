package com.yxb.byapicommon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yxb.byapicommon.model.entity.InterfaceInfo;
import com.yxb.byapicommon.model.entity.User;
import com.yxb.byapicommon.model.entity.UserInterfaceInfo;

/**
* @author 22617
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2023-10-02 09:34:16
*/
public interface InnerUserInterfaceInfoService {

    /**
     * 调用接口统计
     * @param interfaceInfoId 调用接口ID
     * @param userId 调用用户ID
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);
}
