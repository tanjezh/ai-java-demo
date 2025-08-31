package com.tan.ai.langchain4j;

import com.tan.ai.langchain4j.bean.Appointment;
import com.tan.ai.langchain4j.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author tanjezh
 * @create 2025-08-31 14:58
 */
@SpringBootTest
public class AppointmentServiceTest {

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testGet(){
        Appointment a = new Appointment();
        a.setUsername("张三");
        a.setIdCard("123456789012345678");
        a.setDepartment("内科");
        a.setDoctorName("李医生");
        a.setDate("2025-08-31");
        a.setTime("14:00");
        Appointment appointment = appointmentService.getOne(a);
        System.out.println(appointment);
    }

    @Test
    public void testAdd(){
        Appointment a = new Appointment();
        a.setUsername("张三");
        a.setIdCard("123456789012345678");
        a.setDepartment("内科");
        a.setDoctorName("李医生");
        a.setDate("2025-08-31");
        a.setTime("14:00");
        appointmentService.save(a);
    }

    @Test
    public void testRemove(){
        appointmentService.removeById(1L);
    }

}
