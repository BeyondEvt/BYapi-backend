package com.yxb.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yxb.project.common.ErrorCode;
import com.yxb.project.exception.BusinessException;
import com.yxb.project.model.entity.InterfaceInfo;
import com.yxb.project.model.entity.UserInterfaceInfo;
import com.yxb.project.mapper.UserInterfaceInfoMapper;
import com.yxb.project.service.UserInterfaceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
* @author 22617
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service实现
* @createDate 2023-10-02 09:34:16
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService{
    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userinterfaceInfo, boolean add) {

        if (userinterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }



        // 创建时，所有参数必须非空
        if (add) {
            if (userinterfaceInfo.getInterfaceInfoId() <= 0 || userinterfaceInfo.getUserId() <= 0){
                throw new BusinessException(ErrorCode.PARAMS_ERROR,"用户或接口不存在");
            }
        }
        //
        if (userinterfaceInfo.getLeftNum() <= 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "该接口剩余调用次数不足");
        }

    }

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        // 检验
        if (interfaceInfoId <= 0 || userId <= 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "该接口或当前用户不存在");
        }
        // 获得对应数据表数据 - 可能要加分布式锁，进行事务管理
        UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("interfaceInfoId", interfaceInfoId);
        updateWrapper.eq("userId",userId);
//        updateWrapper.gt('leftNum',  0);
        updateWrapper.setSql("leftNum = leftNum - 1, totalNum = totalNum + 1");
        this.update(updateWrapper);
        return this.update(updateWrapper);
    }
}




