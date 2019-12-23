package com.linkpets.responseModel.system;

import com.linkpets.model.SysMenu;
import lombok.Data;

import java.util.List;

/**
 * @Author Edie
 */
@Data
public class SysMenuResp {

    private String id;

    private String parentId;

    private String title;

    private String path;

    private String icon;

    private Integer sort;

    private List<SysMenu> children;

    public SysMenuResp(String id, String parentId, String title, String path, String icon, Integer sort) {
        this.id = id;
        this.parentId = parentId;
        this.title = title;
        this.path = path;
        this.icon = icon;
        this.sort = sort;
    }
}
