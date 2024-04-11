package edu.collage.campus.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.collage.campus.entity.activity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface activityService extends IService<activity> {
    List<activity> getList(QueryWrapper<activity> queryWrapper);
}
