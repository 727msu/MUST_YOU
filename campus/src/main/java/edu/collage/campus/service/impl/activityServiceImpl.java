package edu.collage.campus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.collage.campus.entity.activity;
import edu.collage.campus.entity.activity_images;
import edu.collage.campus.mapper.activity_imagesMapper;
import edu.collage.campus.service.activityService;
import edu.collage.campus.mapper.activityMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class activityServiceImpl extends ServiceImpl<activityMapper, activity>
        implements activityService {

    final activityMapper activityMapper;

    final activity_imagesMapper activityImagesMapper;

    public activityServiceImpl(activityMapper activityMapper, activity_imagesMapper activityImagesMapper) {
        this.activityMapper = activityMapper;
        this.activityImagesMapper = activityImagesMapper;
    }

    @Override
    public List<activity> getList(QueryWrapper<activity> queryWrapper) {
        List<activity> activities = activityMapper.selectList(queryWrapper);
        for (var item : activities) {
            Long id = item.getId();
            QueryWrapper<activity_images> wrapper = new QueryWrapper<>();
            wrapper.eq("activity_id", id);
            List<activity_images> list = activityImagesMapper.selectList(wrapper);
            List<String> images = new ArrayList<>();
            for (var ii : list) {
                images.add(ii.getImageUrl());
            }
            item.setImages(images);
        }
        return activities;
    }
}




