package cn.excel.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {
    public static final long serialVersionUID=3L;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 描述
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    public Result success(Integer code, String msg, T data){
        Result r=new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public Result success(T data){
        return success(200,"操作成功",data);
    }

    public Result failed(Integer code, String msg, T data){
        Result r=new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public Result failed(String msg){
        return failed(400,msg,null);
    }
}
