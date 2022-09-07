package net.maku.framework.common.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import net.maku.framework.common.query.Query;
import net.maku.framework.common.service.BaseService;


import java.util.List;


/**
 * 基础服务类，所有Service都要继承
 *
 * @author 阿沐 babamu@126.com
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T>  extends ServiceImpl<M, T> implements BaseService<T> {

    /**
     * 获取分页对象
     * @param query   分页参数
     */
    protected IPage<T> getPage(Query query) {
        Page<T> page = new Page<>(query.getPage(), query.getLimit());

        // 排序
        if(StringUtils.isNotBlank(query.getOrder())){
            if(query.isAsc()) {
                return page.addOrder(OrderItem.asc(query.getOrder()));
            }else {
                return page.addOrder(OrderItem.desc(query.getOrder()));
            }
        }

        return page;
    }
}