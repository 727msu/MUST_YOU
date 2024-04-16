package edu.collage.campus.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.collage.campus.entity.users;
import edu.collage.campus.service.usersService;
import edu.collage.campus.mapper.usersMapper;
import org.springframework.stereotype.Service;


@Service
public class usersServiceImpl extends ServiceImpl<usersMapper, users>
    implements usersService{

}




