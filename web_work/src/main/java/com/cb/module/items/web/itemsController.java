package com.cb.module.items.web;


import com.cb.module.common.entity.AjaxResult;
import com.cb.module.items.domain.items;
import com.cb.module.items.service.itemsService;
import com.cb.module.user.domain.SysUserDetails;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "物品模块api")
@RequestMapping(value = "/items")
public class itemsController {

    @Autowired
    private itemsService itemsService;


    @ApiOperation("添加物品")
    @PostMapping("/addItems")
    public AjaxResult addItems(@RequestBody items items){
        if(StringUtils.isEmpty(items.getItemsName())){
            return AjaxResult.error("物品名为空");
        }
        if(items.getNumbers().equals(null)){
            return AjaxResult.error("物品数量为空");
        }
        SysUserDetails sysUserDetails = (SysUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        items.setId(sysUserDetails.getId());

        return itemsService.addItems(items);
    }

    @ApiOperation("查看所有可借用的物品")
    @GetMapping("/listAllproduct")
    public AjaxResult listAllproduct(){

        return AjaxResult.success(itemsService.listAllproduct());
    }

    @ApiOperation("查看自己所有的物品")
    @GetMapping("/listProductByUserId")
    public AjaxResult listProductByUserId(){
        SysUserDetails sysUserDetails = (SysUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return AjaxResult.success(itemsService.listProductByUserId(sysUserDetails.getId()));
    }

    @ApiOperation("根据物品Id修改物品属性")
    @PostMapping("/updateItemByItemId")
    public AjaxResult updateItemByItemId(@RequestBody items items){
        return AjaxResult.success(itemsService.updateItemByItemId(items));
    }

    @ApiOperation("根据物品名字查询物品")
    @PostMapping("/listProductByItemsName")
    public AjaxResult listProductByItemsName(@RequestBody String itemsName){
        return AjaxResult.success(itemsService.listProductByItemsName(itemsName));
    }

    @ApiOperation("根据物品Id删除物品")
    @PostMapping("/deleteItemByItemId")
    public AjaxResult deleteItemByItemId(@RequestBody long itemsId){
        return AjaxResult.success(itemsService.deleteItemByItemId(itemsId));
    }
}
