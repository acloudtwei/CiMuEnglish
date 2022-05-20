package com.english.cimu.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("ptharticle")
public class ptharticle {
    @TableId("name")
    private String name;
    private String path;
}
