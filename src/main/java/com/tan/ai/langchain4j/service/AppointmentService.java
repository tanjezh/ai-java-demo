package com.tan.ai.langchain4j.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tan.ai.langchain4j.bean.Appointment;

/**
 * appointment 服务类接口
 * @author tanjezh
 * @create 2025-08-31 14:45
 */
public interface AppointmentService extends IService<Appointment> {

    Appointment getOne(Appointment appointment);

}
