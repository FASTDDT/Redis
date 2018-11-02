package spring.redis.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import spring.redis.model.Comment;
import spring.redis.mapper.CommentMapper;
import spring.redis.manager.CommentManager;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author father
 * @since 2018-10-29
 */
@Service
public class CommentManagerImpl extends ServiceImpl<CommentMapper , Comment> implements CommentManager {
//    CommentMapper commentMapper;
    @Override
    public void deleteAll() {
  //      commentMapper.deleteAll();
    }
}
