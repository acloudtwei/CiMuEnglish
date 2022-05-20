package com.english.cimu.service.impl;

import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.english.cimu.Utils.TweiResult;

import com.english.cimu.dao.ToneDao;
import com.english.cimu.entity.Gaozhong;
import com.english.cimu.entity.Ttwo;
import com.english.cimu.service.ToneService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collection;
import com.english.cimu.entity.Tone;

import java.util.List;

/**
 * (Tone)表服务实现类
 *
 * @author acloudtwei
 * @since 2021-12-30 23:59:10
 */
@Service("toneService")
public class ToneServiceImpl implements ToneService {

    @Resource
    ToneDao toneDao;

    private boolean judgemethod(String str) {
        return str != null && str.length() != 0;
    }

    @Override
    public TweiResult getTone(Page<Tone> page, String one) {
        //		调用Mapper接口返回一个page对象
        Page<Tone> jobInfoPage = toneDao.selectPage(page, null);
        //page对象转list对象
        List<Tone> records = jobInfoPage.getRecords();

//        单个序号构造器
        QueryWrapper<Tone> wrapper = new QueryWrapper<>();
        wrapper.like("eg", one);
        List<Tone> theone = toneDao.selectList(wrapper);

        if (judgemethod(one)){
            if (theone.size() > 0) {
                return TweiResult.ok(theone.size() , theone);
            } else {
                return TweiResult.get(200, "数据库中没有相似的题目！", 0, "null");
            }
        }
        return TweiResult.ok(toneDao.selectCount(null), records);
    }

    @Override
    public SaResult Tonedelete(String one) {
        QueryWrapper<Tone> wrapper = new QueryWrapper<>();
        Collection<String> trueword = Arrays.asList(one.split(","));
        boolean wordjudge = false;
        if (trueword.size() == 0) {
            return SaResult.error("请选择要删除的题目序号！");
        }
        if (trueword.size() == 1) {
            wrapper.eq("Trank", one.split(",")[0]);
            if (toneDao.delete(wrapper) > 0) {
                return SaResult.ok(one.split(",")[0] + "号题目已删除！");
            }
            return SaResult.error(one.split(",")[0] + "号题目不存在！！");
        } else {
            wrapper.in("Trank", trueword);
            if (toneDao.delete(wrapper) > 0) {
                wordjudge = true;
            }
        }
        if (wordjudge) {
            return SaResult.ok("所选题目删除成功！");
        }
        return SaResult.error();
    }

    @Override
    public SaResult Toneadd(Tone tone) {
        if (toneDao.insert(tone) > 0) {
            return SaResult.ok("添加成功");
        }
        return SaResult.error("添加失败！");
    }

    @Override
    public SaResult Tonemodify(String one, String item, String keyword) {
        UpdateWrapper<Tone> updateWrapper = new UpdateWrapper<>();
        Tone tone = new Tone();
        if ("eg".equals(keyword)) {
            updateWrapper.eq("trank", one);
            tone.setEg(item);
            if (toneDao.update(tone, updateWrapper) > 0) {
                return SaResult.ok("修改成功");
            }
        } else if ("optiona".equals(keyword)) {
            updateWrapper.eq("trank", one);
            tone.setOptiona(item);
            if (toneDao.update(tone, updateWrapper) > 0) {
                return SaResult.ok("修改成功");
            }
        } else if ("optionb".equals(keyword)) {
            updateWrapper.eq("trank", one);
            tone.setOptionb(item);
            if (toneDao.update(tone, updateWrapper) > 0) {
                return SaResult.ok("修改成功");
            }
        }else if ("optionc".equals(keyword)) {
            updateWrapper.eq("trank", one);
            tone.setOptionc(item);
            if (toneDao.update(tone, updateWrapper) > 0) {
                return SaResult.ok("修改成功");
            }
        }else if ("optiond".equals(keyword)) {
            updateWrapper.eq("trank", one);
            tone.setOptiond(item);
            if (toneDao.update(tone, updateWrapper) > 0) {
                return SaResult.ok("修改成功");
            }
        }else if ("rights".equals(keyword)) {
            updateWrapper.eq("trank", one);
            tone.setRights(item);
            if (toneDao.update(tone, updateWrapper) > 0) {
                return SaResult.ok("修改成功");
            }
        }else {
            updateWrapper.eq("trank", one);
            tone.setAnalysis(item);
            if (toneDao.update(tone, updateWrapper) > 0) {
                return SaResult.ok("修改成功");
            }
        }
        return SaResult.error("修改失败！");
    }

}

