package com.yxb.byapicommon.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yxb.byapicommon.model.entity.User;


/**
 * 用户服务
 *
 * @author yupi
 */
public interface InnerUserService {

    /**
     * 1.去数据库中查找是否已分配给用户密钥（ak、sk）
     * @param accessKey
     * @return
     */
    User getInvokeUser(String accessKey);

}
