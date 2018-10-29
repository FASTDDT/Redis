package spring.redis.manager.impl;

import spring.redis.model.Project;
import spring.redis.mapper.ProjectMapper;
import spring.redis.manager.ProjectManager;
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
public class ProjectManagerImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectManager {

}
