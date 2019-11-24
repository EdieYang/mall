package com.linkpets.responseModel;

import com.linkpets.model.SysUser;
import lombok.Data;

/**
 * @author edie
 */
@Data
public class SysUserInfo extends SysUser {
    private String roleType;
    private String roleName;
    private String shopId;
    private String shopName;
}
