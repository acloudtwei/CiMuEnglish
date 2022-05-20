package com.english.cimu.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("pthdata")
public class pthdata {
    @TableId("name")
    private String name;
    private String path;
}
