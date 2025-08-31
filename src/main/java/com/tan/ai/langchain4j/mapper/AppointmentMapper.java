package com.tan.ai.langchain4j.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tan.ai.langchain4j.bean.Appointment;
import org.apache.ibatis.annotations.Mapper;

/**
 * mapper 接口
 * @author tanjezh
 * @create 2025-08-31 14:41
 */
@Mapper
public interface AppointmentMapper extends BaseMapper<Appointment> {
}
