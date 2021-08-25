package com.zhangzhen.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhangzhen.commontils.R;
import com.zhangzhen.eduservice.entity.EduTeacher;
import com.zhangzhen.eduservice.entity.vo.TeacherQuery;
import com.zhangzhen.eduservice.service.EduTeacherService;
import com.zhangzhen.servicebase.config.hanled.customException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-02-27
 */
@RestController
@Api("讲师")
@RequestMapping("/eduservice/teacher")
@CrossOrigin
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    @ApiOperation("查询讲师列表")
    @GetMapping("/findAll")
    public R findTeacherAll() {
        List<EduTeacher> list = eduTeacherService.list(null);
        return R.success().data("item", list);

    }

    @ApiOperation("讲师逻辑删除")
    @DeleteMapping("/{id}")
    public R deleteTeacher(@ApiParam(name = "id",value = "讲师id",required = true) @PathVariable(name = "id") String eduId) {
        boolean b = eduTeacherService.removeById(eduId);
        if (b) {
            return R.success();
        } else {
            return R.error();
        }
    }

    @ApiOperation("讲师分页查询")
    @GetMapping("/page/{current}/{limit}")
    public R pageTeach(@ApiParam(name = "current",value = "当前页",required = true) @PathVariable(name = "current") long current,
                       @ApiParam(name = "limit",value = "查询数",required = true) @PathVariable(name = "limit") long limit) {
        Page<EduTeacher> page = new Page<>(current,limit);
        IPage<EduTeacher> pageInfo = eduTeacherService.page(page, null);
        long total = pageInfo.getTotal();
        List<EduTeacher> records = pageInfo.getRecords();
        Map<String,Object> map = new HashMap<>();
        map.put("total",total);
        map.put("items",records);
        return R.success().data(map);
    }

    /**
     *
     * @param current 当前页
     * @param limit 查询数量
     * @param teacherQuery 查询多条件
     * @return 公共返回
     */
    @ApiOperation("讲师带条件查询")
    @PostMapping("/teacherQueryCodition/{current}/{limit}")
    public R teacherQueryCodition(@PathVariable(name = "current") long current,
                                  @PathVariable(name = "limit") long limit,
                                  @RequestBody(required = false)TeacherQuery teacherQuery) {
        // 分页条件
        Page<EduTeacher> page = new Page<>(current,limit);

        // 过滤多条件
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        if (!StringUtils.isEmpty(name)) {
            wrapper.like("name",name);
        }
        if (!StringUtils.isEmpty(level)) {
            wrapper.eq("level",level);
        }
        if (!StringUtils.isEmpty(begin)) {
            wrapper.ge("gmt_create",begin);
        }
        if (!StringUtils.isEmpty(end)) {
            wrapper.le("gmt_modified",end);
        }

        IPage<EduTeacher> pageInfo = eduTeacherService.page(page, wrapper);
        long total = pageInfo.getTotal();
        List<EduTeacher> records = pageInfo.getRecords();
        Map<String,Object> map = new HashMap<>();
        map.put("total",total);
        map.put("items",records);
        return R.success().data(map);
    }

    @ApiOperation("讲师添加")
    @PostMapping("/addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean save = eduTeacherService.save(eduTeacher);
        if (save) {
            return R.success();
        } else {
            return R.error();
        }
    }

    @ApiOperation("根据id查单个讲师")
    @GetMapping(value = "/{id}")
    public R queryTeacherById(@PathVariable(name = "id") long id) {
        try {
            int a = 10/0;
        } catch (Exception e) {
            throw new customException(20001,"进行了自定义异常处理");
        }
        EduTeacher eduTeacher = eduTeacherService.getById(id);
        return R.success().data("eduteacher",eduTeacher);
    }

    @ApiOperation("讲师修改")
    @PostMapping("/updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean update = eduTeacherService.updateById(eduTeacher);
        if (update) {
            return R.success();
        } else {
            return R.error();
        }
    }



}

