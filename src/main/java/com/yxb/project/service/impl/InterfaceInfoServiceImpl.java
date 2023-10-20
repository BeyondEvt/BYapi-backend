package com.yxb.project.service.impl;
import java.util.Date;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yxb.project.common.ErrorCode;
import com.yxb.project.exception.BusinessException;
import com.yxb.project.model.entity.InterfaceInfo;
import com.yxb.project.service.InterfaceInfoService;
import com.yxb.project.mapper.InterfaceInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
* @author 22617
* @description 针对表【interface_info(接口信息)】的数据库操作Service实现
* @createDate 2023-09-18 21:41:43
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService {

    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {

        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }


        String name = interfaceInfo.getName();
        String description = interfaceInfo.getDescription();
        String url = interfaceInfo.getUrl();
        String method = interfaceInfo.getMethod();
//        String request_header = interfaceInfo.getRequest_header();
//        String response_header = interfaceInfo.getResponse_header();



        // 创建时，所有参数必须非空
        if (add) {
//            if (StringUtils.isAnyBlank(name, description, url, method) ||
//                    ObjectUtils.anyNull(id,status,user_id,create_time,update_time,is_deleted)) {
            if (StringUtils.isAnyBlank(name, description, url, method)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "输入值不可以为空，请重新输入！");
            }
        }
        // 参数校验
        // 更新时只考虑参数是否合格
        if (StringUtils.isNotBlank(name) && name.length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "名称过长");
        }
        if (StringUtils.isNotBlank(description) && description.length() >= 100) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "描述过长");
        }
        if (StringUtils.isNotBlank(url) && url.length() >= 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "链接过长");
        }

    }

}




