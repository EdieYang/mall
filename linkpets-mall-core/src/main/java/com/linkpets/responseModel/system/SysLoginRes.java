package com.linkpets.responseModel.system;

import lombok.Data;

import java.util.List;

/**
 * @Author Edie
 */
@Data
public class SysLoginRes {

    private String userId;
    private String userName;
    private List<String> userRoles;
    private List<String> userPermissions;
    private List<SysMenuRes> accessMenus;
    private List<SysLoginRouteRes> accessRoutes;

}
