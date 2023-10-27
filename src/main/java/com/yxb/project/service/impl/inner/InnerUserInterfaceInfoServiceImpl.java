package com.yxb.project.service.impl.inner;

import com.yxb.byapicommon.model.entity.UserInterfaceInfo;
import com.yxb.byapicommon.service.InnerUserInterfaceInfoService;
import com.yxb.project.service.UserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    public UserInterfaceInfoService userInterfaceInfoService;

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        return userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
    }
}
