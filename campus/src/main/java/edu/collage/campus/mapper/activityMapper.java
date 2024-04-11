package edu.collage.campus.mapper;

import edu.collage.campus.entity.activity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.collage.campus.entity.activity_images;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface activityMapper extends BaseMapper<activity> {
    List<activity_images> getImages(@Param("activity_id") Long activity_id);
}




