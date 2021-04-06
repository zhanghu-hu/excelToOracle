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
//@Accessors(chain = true) 和easyExcel冲突
@TableName("JS_POINT")
public class JsPoint implements Serializable {

    private static final long serialVersionUID = 1565463225605L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    @ExcelIgnore
    private BigDecimal id;

    @TableField("OBJECTID")
    @ExcelProperty("OBJECTID")
    private BigDecimal objectID;

    /**
     * 二维码编号
     */
    @TableField("QR_CODE")
    @ExcelProperty("二维码编号")
    private String qrCode;

    /**
     * 图上点号
     */
    @TableField("FIGURE_POINT")
    @ExcelProperty("图上点号")
    private String figurePoint;

    /**
     * 物探点号
     */
    @TableField("GP_POINT")
    @ExcelProperty("物探点号")
    private String gpPoint;

    /**
     * 点代码
     */
    @TableField("POINT_CODE")
    @ExcelProperty("点代码")
    private String pointCode;

    /**
     * 特征
     */
    @TableField("CHARACTERISTICS")
    @ExcelProperty("特征点")
    private String characteristics;

    /**
     * 附属物
     */
    @TableField("APPENDAGES")
    @ExcelProperty("附属物")
    private String appendages;

    @TableField("X")
    @ExcelProperty("X坐标")
    private BigDecimal x;

    @TableField("Y")
    @ExcelProperty("Y坐标")
    private BigDecimal y;

    /**
     * 地面高程
     */
    @TableField("ELEVATION")
    @ExcelProperty("地面高程")
    private BigDecimal elevation;

    /**
     * 专业图点号X
     */
    @TableField("FIGURE_POINT_X")
    @ExcelProperty("专业图点号X坐标")
    private BigDecimal figurePointX;

    /**
     * 专业图点号Y
     */
    @TableField("FIGURE_POINT_Y")
    @ExcelProperty("专业图点号Y坐标")
    private BigDecimal figurePointY;

    /**
     * 道路名称
     */
    @TableField("ROAD_NAME")
    @ExcelProperty("所在道路")
    private String roadName;

    /**
     * 图幅号
     */
    @TableField("MAP_NUMBER")
    @ExcelProperty("所在图幅")
    private String mapNumber;

    /**
     * 辅助类型
     */
    @TableField("AUXILIARY_TYPE")
    @ExcelProperty("辅助类型")
    private String auxiliaryType;

    /**
     * 删除标记
     */
    @TableField("DELETE_TAG")
    @ExcelProperty("删除标记")
    private String deleteTag;

    /**
     * 井盖材料
     */
    @TableField("MC_MATERIAL")
    @ExcelProperty("井盖材料")
    private String mcMaterial;

    /**
     * 井盖直径
     */
    @TableField("MC_DIAMETER")
    @ExcelProperty("井盖直径")
    private String mcDiameter;

    /**
     * 井盖类型
     */
    @TableField("MC_TYPE")
    @ExcelProperty("井盖类型")
    private String mcType;

    /**
     * 偏心井位
     */
    @TableField("MC_OFFSET")
    @ExcelProperty("偏心井位")
    private String mcOffset;

    /**
     * expno
     */
    @TableField("EXPNO")
    @ExcelIgnore
    private String expno;

    /**
     * 备注
     */
    @TableField("REMARK")
    @ExcelProperty("备注")
    private String remark;

    /**
     * 操作库
     */
    @TableField("OPERATION_LIBRARY")
    @ExcelProperty("操作库")
    private String operationLibrary;

    /**
     * 井底深
     */
    @TableField("WELL_DEPTH")
    @ExcelProperty("井底深")
    private String wellDepth;

    /**
     * 探测方法
     */
    @TableField("DETECTION_METHODS")
    @ExcelProperty("探测方法")
    private String detectionMethods;

    /**
     * 探测时间
     */
    @TableField("DETECTION_TIME")
    @ExcelProperty("探测时间")
    private String detectionTime;

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
    @ExcelIgnore
    private String area;

    /**
     * 点编码
     */
    @TableField("point_coding")
    @ExcelProperty("点编码")
    private String pointCoding;

    @TableField("ELEMSTIME")
    @ExcelProperty("ElemSTime")
    private String ElemSTime;

    @TableField("ELEMETIME")
    @ExcelProperty("ElemETime")
    private String ElemETime;
}
