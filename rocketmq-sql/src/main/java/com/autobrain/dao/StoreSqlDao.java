package com.autobrain.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StoreSqlDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //添加约车信息
    public String addAboutCarInformation(List<Object[]> list) {
        try {
            String sql = "insert into tb_app_about_car (id,command_identifier,control_result,crc_check,domain_controllerid,gps_length,locationx,locationy,messageid," +
                    "message_length,package_amount,package_number,serial_number,serial_size,start_byte,time_stamp,instruct,oid,identify) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            jdbcTemplate.batchUpdate(sql, list);
            return "约车信息入库成功";
        } catch (Exception e) {
            return "约车信息入库失败" + e.toString() + e.getMessage();
        }
    }

    //添加取用还泊信息
    public String addTakeCarInformation(List<Object[]> list) {
        try {
            String sql = "insert into tb_app_take_car (id,car_state,command_identifier,control_result,crc_check,domain_controllerid,electricity,endurance_mileage,gps_length,locationx,locationy," +
                    "messageid,message_length,package_amount,package_number,serial_number,serial_size,start_byte,time_stamp,total_distance,voltage,oid,instruct,identify) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            jdbcTemplate.batchUpdate(sql, list);
            return "信息入库成功";
        } catch (Exception e) {
            return "信息入库失败" + e.toString() + e.getMessage();
        }
    }

    //添加gps信息
    public String addFiveSecondsGPS(List<Object[]> list) {
        try {
            String sql = "insert into tb_app_five_secondsgps (id,command_identifier,crc_check,domain_controllerid,gps_length,latitude,longitude,messageid,message_length,serial_number,start_byte,oid,instruct,time_stamp) " +
                    "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            jdbcTemplate.batchUpdate(sql, list);
            return "五秒GPS信息入库成功";
        } catch (Exception e) {
            return "五秒GPS信息入库失败" + e.toString() + e.getMessage();
        }
    }

    //添加警告信息
    public String addWarning(List<Object[]> list) {
        try {
            String sql = "insert into tb_app_warning (id,acceleration,angular_acceleration,command_identifier,crc_check,domain_controllerid,fault_code,gps_length,latitude,longitude,messageid,message_length,serial_number," +
                    "start_byte,time_stamp,voltage_value,warning_type,oid,instruct) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            jdbcTemplate.batchUpdate(sql, list);
            return "预警信息入库成功";
        } catch (Exception e) {
            return "预警信息入库失败" + e.toString() + e.getMessage();
        }
    }

    //添加里程信息
    public String addTotalElectricityMileage(List<Object[]> list) {
        try {
            String sql = "insert into tb_app_total_electricitymileage (id,battery_pack_power_battery_model,command_identifier,crc_check,domain_controllerid,messageid,message_length,power_battery_charging_current_value,power_battery_charging_voltage_value,power_cell_temperature,serial_number,serial_number_of_reply_instruction_message,start_byte," +
                    "state_of_the_vehicle,time_stamp,total_mileage,vehiclevincode,voltage_value_of_small_battery,residual_powersoc,life_mileage,oid,instruct) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            jdbcTemplate.batchUpdate(sql, list);
            return "电量、总里程和续航里程状态信息入库成功";
        } catch (Exception e) {
            return "电量、总里程和续航里程状态信息入库失败" + e.toString() + e.getMessage();
        }
    }

    // 车辆自动驾驶信息入库
    public String addCarAutoDriverInformation(List<Object[]> list) {
        try {
            String sql = "insert into car_automatic_drive_get_information (" +
                    "id,epb,gpstime,velocity_in_thexaxis_direction_of_the_obstacle,velocity_in_theyaxis_direction_of_the_obstacle,xcoordinate_of_the_locus,xcoordinate_of_the_obstacle_position," +
                    "ycoordinate_of_the_locus,ycoordinate_of_the_obstacle_position,accelerator_pedal_opening,barrier_high,barrier_long,barrier_state,barrier_width,bicycle_identification_moment," +
                    "bicycle_identification_number,brake_fluid_pressure,brake_lamp,brake_pedal_condition,brake_pedal_opening,car_door_state,car_speed,car_state,command_identifier,crc_check,danger_warning_light," +
                    "dipped_headlight,domain_controllerid,driving_mode_feedback,fog_lamps,gas_pedal_condition,gear_information,heartbeat_handshake_signal,high_beam,horizontal_fault_information,human_intervention," +
                    "instruct,locus_point_rate,longitudinal_acceleration,longitudinal_enabled_signal,longitudinal_fault_information,messageid,message_length,mode_switch,motor_vehicle_identification_moment," +
                    "number_of_motor_vehicle_identification,number_of_traffic_signs,o_id,obstacle_orientation,obstacle_priority,obstacle_trajectory_probability,obstaclesid,obstruction_behavior," +
                    "predicted_trajectory_duration,relative_time_of_locus_point,remaining_mileage,serial_number,signal_of_turn_signal_dial_rod_switch,speed_add_or_subtract_switch,start_byte,steering_angle," +
                    "steering_angular_velocity,steering_direction_indicator,steering_mode_feedback,steering_wheel_corner,steering_wheel_corner_turn_speed,steering_wheel_torque,switch_signals_such_as_danger_alarm," +
                    "target_acceleration,the_bicycle_recognizes_thexcoordinate,the_bicycle_recognizes_theycoordinate,the_roadidwhere_the_track_point_is,thexcoordinate_of_the_locus,theycoordinate_of_the_locus," +
                    "thezcoordinate_of_the_locus,time_stamp,to_identify,to_model,traffic_light_identification_moment,traffic_light_identification_number,traffic_lights_identifyxcoordinates," +
                    "traffic_lights_identifyycoordinates,traffic_sign_identification_time,traffic_signs_identifyxcoordinates,traffic_signs_identifyycoordinates,trajectory_point_acceleration," +
                    "trajectory_point_orientation,transverse_acceleration,transverse_enabling_signal,turn_signal,vehicle_identificationxcoordinates,vehicle_identificationycoordinates," +
                    "wheel_direction,wheel_speed,wheel_speed_mark,wheel_steering_angle,wiper,yawing_rate,pedestrian_recognition_time,pedestrian_recognition_times,pedestrian_recognitionxcoordinate," +
                    "pedestrian_recognitionycoordinate) " +
                    "value (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            jdbcTemplate.batchUpdate(sql, list);
            return "车辆自动驾驶信息入库成功";
        } catch (Exception e) {
            return "车辆自动驾驶信息入库失败" + e.toString() + e.getMessage();
        }
    }
    //车辆运动状态信息
    public String addCarExerciseStateInformation(List<Object[]> list){
        try {
            String sql = "insert into tb_app_car_exercise_state_information (id,angular_acceleration,cab_temperature,command_identifier,course_radian,crc_check,domain_controller_id,engine_speed,engine_temperature,gear,gps_speed," +
                    "instruct,message_id,message_length,oid,oil_mass,serial_number,speed,start_byte,three_axis_acceleration,time_stamp) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            jdbcTemplate.batchUpdate(sql, list);
            return "车辆运动状态信息入库成功";
        } catch (Exception e) {
            return "车辆运动状态信息入库失败" + e.toString() + e.getMessage();
        }
    }
}
