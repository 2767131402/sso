package com.macro.cloud.mapper;

import com.macro.cloud.domain.OauthClientDetails;

import java.util.List;

/**
 * 公共接口
 */
public interface OauthClientDetailsMapper {

    OauthClientDetails getOauthClientDetailsByClientId(String clientId);
}
