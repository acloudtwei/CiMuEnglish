package com.english.cimu.service.impl;

import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.english.cimu.Utils.TweiResult;
import com.english.cimu.dao.TtwoDao;
import com.english.cimu.entity.Ttwo;
import com.english.cimu.entity.Ttwo;
import com.english.cimu.service.TtwoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * (Ttwo)表服务实现类
 *
 * @author acloudtwei
 * @since 2021-12-31 00:52:39
 */
@Service("ttwoService")
public class TtwoServiceImpl implements TtwoService {

    @Resource
    TtwoDao ttwoDao;

    private boolean judgemethod(String str) {
        return str != null && str.length() != 0;
    }

    @Override
    public TweiResult getTtwo(Page<Ttwo> page, String two) {
        //		调用Mapper接口返回一个page对象
        Page<Ttwo> jobInfoPage = ttwoDao.selectPage(page, null);
        //page对象转list对象
        List<Ttwo> records = jobInfoPage.getRecords();

//        单个序号构造器
        QueryWrapper<Ttwo> wrapper = new QueryWrapper<>();
        wrapper.like("eg", two);
        List<Ttwo> thetwo = ttwoDao.selectList(wrapper);

        if (judgemethod(two)){
            if (thetwo.size() > 0) {
                return TweiResult.ok(thetwo.size() , thetwo);
            } else {
                return TweiResult.get(200, "数据库中没有相似的题目！", 0, "null");
            }
        }
        return TweiResult.ok(ttwoDao.selectCount(null), records);
    }

    @Override
    public SaResult Ttwodelete(String two) {
        QueryWrapper<Ttwo> wrapper = new QueryWrapper<>();
        Collection<String> trueword = Arrays.asList(two.split(","));
        boolean wordjudge = false;
        if (trueword.size() == 0) {
            return SaResult.error("请选择要删除的题目序号！");
        }
        if (trueword.size() == 1) {
            wrapper.eq("Trank", two.split(",")[0]);
            if (ttwoDao.delete(wrapper) > 0) {
                return SaResult.ok(two.split(",")[0] + "号题目已删除！");
            }
            return SaResult.error(two.split(",")[0] + "号题目不存在！！");
        } else {
            wrapper.in("Trank", trueword);
            if (ttwoDao.delete(wrapper) > 0) {
                wordjudge = true;
            }
        }
        if (wordjudge) {
            return SaResult.ok("所选题目删除成功！");
        }
        return SaResult.error();
    }

    @Override
    public SaResult Ttwoadd(Ttwo ttwo) {
        if (ttwoDao.insert(ttwo) > 0) {
            return SaResult.ok("添加成功");
        }
        return SaResult.error("添加失败！");
    }

    @Override
    public SaResult Ttwomodify(String two, String item, String keyword) {
        UpdateWrapper<Ttwo> updateWrapper = new UpdateWrapper<>();
        Ttwo ttwo = new Ttwo();
        if ("eg".equals(keyword)) {
            updateWrapper.eq("trank", two);
            ttwo.setEg(item);
            if (ttwoDao.update(ttwo, updateWrapper) > 0) {
                return SaResult.ok("修改成功");
            }
        } else if ("optiona".equals(keyword)) {
            updateWrapper.eq("trank", two);
            ttwo.setOptiona(item);
            if (ttwoDao.update(ttwo, updateWrapper) > 0) {
                return SaResult.ok("修改成功");
            }
        } else if ("optionb".equals(keyword)) {
            updateWrapper.eq("trank", two);
            ttwo.setOptionb(item);
            if (ttwoDao.update(ttwo, updateWrapper) > 0) {
                return SaResult.ok("修改成功");
            }
        }else if ("optionc".equals(keyword)) {
            updateWrapper.eq("trank", two);
            ttwo.setOptionc(item);
            if (ttwoDao.update(ttwo, updateWrapper) > 0) {
                return SaResult.ok("修改成功");
            }
        }else if ("optiond".equals(keyword)) {
            updateWrapper.eq("trank", two);
            ttwo.setOptiond(item);
            if (ttwoDao.update(ttwo, updateWrapper) > 0) {
                return SaResult.ok("修改成功");
            }
        }else if ("rights".equals(keyword)) {
            updateWrapper.eq("trank", two);
            ttwo.setRights(item);
            if (ttwoDao.update(ttwo, updateWrapper) > 0) {
                return SaResult.ok("修改成功");
            }
        }else {
            updateWrapper.eq("trank", two);
            ttwo.setAnalysis(item);
            if (ttwoDao.update(ttwo, updateWrapper) > 0) {
                return SaResult.ok("修改成功");
            }
        }
        return SaResult.error("修改失败！");
    }
}

