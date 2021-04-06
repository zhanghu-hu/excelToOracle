package cn.excel.entity;

import java.math.BigDecimal;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author author：ZH
 * @since 2021-04-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)  和easyExcel冲突
@TableName("JS_LINE")
public class JsLine implements Serializable {

    private static final long serialVersionUID = 506506505132L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    @ExcelIgnore
    private Double id;

    @TableField("object_id")
    @ExcelProperty("OBJECTID")
    private Long objectID;

    /**
     * 二维码编号
     */
    @TableField("QR_CODE")
    @ExcelProperty("二维码编号")
    private String qrCode;

    /**
     * 线编码
     */
    @TableField("LINE_CODE")
    @ExcelProperty("线编码")
    private String lineCode;

    /**
     * 起点点号
     */
    @TableField("TO_POINT")
    @ExcelProperty("起点点号")
    private String toPoint;

    /**
     * 终点点号
     */
    @TableField("END_POINT")
    @ExcelProperty("终点点号")
    private String endPoint;

    /**
     * 起点埋深
     */
    @TableField("TO_DEPTH")
    @ExcelProperty("起点埋深")
    private BigDecimal toDepth;

    /**
     * 终点埋深
     */
    @TableField("END_DEPTH")
    @ExcelProperty("终点埋深")
    private BigDecimal endDepth;

    /**
     * 埋设类型
     */
    @TableField("TYPE")
    @ExcelProperty("埋设类型")
    private String type;

    /**
     * 材质
     */
    @TableField("TEXTURE")
    @ExcelProperty("材质")
    private String texture;

    /**
     * 管径
     */
    @TableField("PIP_DIAMETER")
    @ExcelProperty("管径")
    private BigDecimal pipDiameter;

    /**
     * 建设年代
     */
    @TableField("BUILD_TIME")
    @ExcelProperty("建设年代")
    private String buildTime;

    /**
     * lnumber
     */
    @TableField("LNUMBER")
    @ExcelIgnore
    private String lnumber;

    /**
     * 线型
     */
    @TableField("LINE_TYPE")
    @ExcelProperty("线型")
    private String lineType;

    /**
     * 道路名称
     */
    @TableField("ROAD_NAME")
    @ExcelProperty("所在道路")
    private String roadName;

    /**
     * 管沟连接码
     */
    @TableField("CONNECTION_CODE")
    @ExcelProperty("管沟连接码")
    private String connectionCode;

    /**
     * 起点高程
     */
    @TableField("TO_ELEVATION")
    @ExcelProperty("起点高程")
    private String toElevation;

    /**
     * 终点高程
     */
    @TableField("END_ELEVATION")
    @ExcelProperty("终点高程")
    private String endElevation;

    /**
     * 探测时间
     */
    @TableField("DETECT_TIME")
    @ExcelProperty("探测时间")
    private String detectTime;

    /**
     * 权属单位
     */
    @TableField("OWNER")
    @ExcelProperty("权属单位")
    private String owner;

    /**
     * 探测单位
     */
    @TableField("DETECTION_UNIT")
    @ExcelProperty("探测单位")
    private String detectionUnit;

    /**
     * 入水口小区
     */
    @TableField("IN_COMMUNITY")
    @ExcelProperty("入水口小区")
    private String inCommunity;

    /**
     * 片区
     */
    @TableField("AREA")
    @ExcelProperty("片区")
    private String area;

    @TableField("ELEMSTIME")
    @ExcelProperty("ElemSTime")
    private String ElemSTime;

    @TableField("ELEMETIME")
    @ExcelProperty("ElemETime")
    private String ElemETime;

    @TableField("SHAPE_LENGTH")
    @ExcelProperty("SHAPE_Length")
    private Double SHAPELength;
}
