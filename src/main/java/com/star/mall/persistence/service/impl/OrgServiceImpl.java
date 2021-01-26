package com.star.mall.persistence.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.star.mall.persistence.entity.Org;
import com.star.mall.persistence.entity.OrgUser;
import com.star.mall.persistence.mapper.OrgMapper;
import com.star.mall.persistence.service.IOrgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.star.mall.persistence.service.IOrgUserService;
import com.star.mall.utils.TreeUtil;
import com.star.mall.utils.UniqueIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 组织表  服务实现类
 * </p>
 *
 * @author 邱喜达
 * @since 2021-01-17
 */
@Service
public class OrgServiceImpl extends ServiceImpl<OrgMapper, Org> implements IOrgService {

    @Autowired
    IOrgUserService orgUserService;

    @Override
    public List<Org> getOrgTree(String orgId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("path_", orgId+".");
        List<Org> orgs = list(wrapper);
        return TreeUtil.listToTree(orgs);
    }

    @Override
    public void addByParentId(Org org) {
        if (StrUtil.isEmpty(org.getParentId()))
            throw new RuntimeException("请添加父级组织ID");
        Org orgFromDb = getById(org.getParentId());
        if (ObjectUtil.isNotEmpty(orgFromDb)) {
            String id = UniqueIdUtil.getSid();
            org.setId(id);
            StringBuffer sb = new StringBuffer(orgFromDb.getPath());
            sb.append(id);
            sb.append(".");
            org.setPath(sb.toString());
            save(org);
        }else {
            throw new RuntimeException("无上级组织");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdateOrgUsers(List<String> userIds, String id) {
        Org org = getById(id);
        if (ObjectUtil.isNotEmpty(org)) {
            userIds.forEach(userId -> {
                QueryWrapper wrapper = new QueryWrapper();
                wrapper.eq("user_id_", userId);
                wrapper.eq("org_id_", id);
                OrgUser orgUser = orgUserService.getOne(wrapper);
                if (ObjectUtil.isEmpty(orgUser)) {
                    orgUser = new OrgUser();
                    orgUser.setUserId(userId);
                    orgUser.setOrgId(id);
                    orgUserService.save(orgUser);
                }
            });
        }else
            throw new RuntimeException("组织不存在");
    }

}
