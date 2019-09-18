package com.mall.userservice.bean;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 返回json结果集
 * @author 86182
 */
@Data
@Accessors(chain = true)
public class JsonResult {

    /**
     * 状态码
     */
    private int code;

    /**
     * 描述信息
     */
    private String msg;

    /**
     * 数据
     */
    private Object data;

    /**
     * 成功处理
     * @return
     */
    public static JsonResult success(){
        return new JsonResult().setCode(200).setMsg("操作成功");
    }

    /**
     * 传入描述信息
     * @param msg
     * @return
     */
    public static JsonResult success(String msg){
        return new JsonResult().setCode(200).setMsg(msg);
    }

    /**
     * 传入数据
     * @param data
     * @return
     */
    public static JsonResult success(Object data){
        return new JsonResult().setCode(200).setData(data);
    }

    /**
     * 传入描述信息和数据
     * @param msg
     * @param data
     * @return
     */
    public static JsonResult success(String msg,Object data){
        return new JsonResult().setCode(200).setMsg(msg).setData(data);
    }


    /**
     * 失败处理
     * @return
     */
    public static JsonResult error(){
        return new JsonResult().setCode(500).setMsg("操作失败");
    }

    /**
     * 传入描述信息
     * @param msg
     * @return
     */
    public static JsonResult error(String msg){
        return new JsonResult().setCode(500).setMsg(msg);
    }

    /**
     * 传入数据
     * @param data
     * @return
     */
    public static JsonResult error(Object data){
        return new JsonResult().setCode(500).setMsg("操作失败").setData(data);
    }

    /**
     * 传入描述信息和数据
     * @param msg
     * @param data
     * @return
     */
    public static JsonResult error(String msg,Object data){
        return new JsonResult().setCode(500).setMsg(msg).setData(data);
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
