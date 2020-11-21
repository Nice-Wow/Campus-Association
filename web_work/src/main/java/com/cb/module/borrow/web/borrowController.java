package com.cb.module.borrow.web;


import com.cb.module.borrow.domain.borrow;
import com.cb.module.borrow.service.borrowService;
import com.cb.module.common.entity.AjaxResult;
import com.cb.module.items.domain.items;
import com.cb.module.items.service.itemsService;
import com.cb.module.user.domain.SysUserDetails;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "租借模块api")
@RequestMapping(value = "/borrow")
public class borrowController {

    @Autowired
    private borrowService borrowService;

    @Autowired
    private itemsService itemsService;

    @ApiOperation("添加租借")
    @PostMapping("/addBorrow")
    public AjaxResult addBorrow(@RequestBody long itemsId, @RequestBody String borrowNumbers) {
        items items = itemsService.selectItemsById(itemsId);

        if (Integer.parseInt(items.getNowNumbers()) < Integer.parseInt(borrowNumbers)) {
            return AjaxResult.error("库存不足");
        } else {
            items.setNowNumbers(String.valueOf(Integer.parseInt(items.getNowNumbers()) - Integer.parseInt(borrowNumbers)));
            itemsService.updateItemByItemId(items);
            borrow borrow = new borrow();
            SysUserDetails sysUserDetails = (SysUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            borrow.setId(sysUserDetails.getId());
            borrow.setBorrowNumbers(borrowNumbers);
            borrow.setItemsId(itemsId);
            borrow.setItemsName(items.getItemsName());
            return borrowService.addBorrow(borrow);
        }
    }

    @ApiOperation("归还租借")
    @PostMapping("/reBorrow")
    public AjaxResult reBorrow(@RequestBody long itemsId) {
        items items = itemsService.selectItemsById(itemsId);
        SysUserDetails sysUserDetails = (SysUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        borrow borrow = borrowService.selectBorrow(sysUserDetails.getId(),itemsId);
        items.setNowNumbers(String.valueOf(Integer.parseInt(items.getNowNumbers()) + Integer.parseInt(borrow.getBorrowNumbers())));
        itemsService.updateItemByItemId(items);
        borrowService.deleteBorrow(sysUserDetails.getId(),itemsId);
        return AjaxResult.success("归还成功");
    }

    @ApiOperation("查看我借用的物品")
    @PostMapping("/selectMyBorrow")
    public AjaxResult selectMyBorrow() {
        SysUserDetails sysUserDetails = (SysUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return AjaxResult.success(borrowService.selectMyBorrow(sysUserDetails.getId()));
    }
}
