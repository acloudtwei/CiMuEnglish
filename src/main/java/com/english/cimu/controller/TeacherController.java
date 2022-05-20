package com.english.cimu.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import com.english.cimu.ToneEntity.TbeanCollect;
import com.english.cimu.entity.Tcoll;
import com.english.cimu.service.TcollService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/collect")
public class TeacherController {

    @Autowired
    TcollService tcollService;

    @SaCheckLogin
    @RequestMapping(value = "/Tcoll", method = RequestMethod.GET)
    public List<TbeanCollect> showTcoll(HttpSession httpSession) {

        String username = (String) httpSession.getAttribute("username");

        List<TbeanCollect> tbeanCollect = tcollService.Selecttcoll(username);

        System.out.println(tbeanCollect.get(0).toString());

        return tbeanCollect;
    }

    }


