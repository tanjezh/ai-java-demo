package com.tan.ai.langchain4j.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tan.ai.langchain4j.bean.Appointment;
import com.tan.ai.langchain4j.mapper.AppointmentMapper;
import com.tan.ai.langchain4j.service.AppointmentService;
import org.springframework.stereotype.Service;

/**
 * 具体实现类
 * @author tanjezh
 * @create 2025-08-31 14:47
 */
@Service
public class AppointmentServiceImpl extends ServiceImpl<AppointmentMapper, Appointment> implements AppointmentService {

    /**
     * 查询订单是否存在
     * @param appointment
     * @return
     */
    @Override
    public Appointment getOne(Appointment appointment) {
        LambdaQueryWrapper<Appointment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Appointment::getUsername, appointment.getUsername());
        queryWrapper.eq(Appointment::getIdCard, appointment.getIdCard());
        queryWrapper.eq(Appointment::getDepartment, appointment.getDepartment());
        queryWrapper.eq(Appointment::getDate, appointment.getDate());
        queryWrapper.eq(Appointment::getTime, appointment.getTime());

        Appointment appointmentInDB = baseMapper.selectOne(queryWrapper);
        return appointmentInDB;
    }
}
