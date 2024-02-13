package com.ruoyi.store.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 装机方案对象 tb_scheme
 * 
 * @author ruoyi
 * @date 2024-02-13
 */
public class TbScheme extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long schemeId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String userName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String name;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long motherboard;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long cpu;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long memory;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long powerSupply;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long graphicsCard;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long hardDrive;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long box;

    /** $table.subTable.functionName信息 */
    private List<TbSchemeReview> tbSchemeReviewList;

    public void setSchemeId(Long schemeId) 
    {
        this.schemeId = schemeId;
    }

    public Long getSchemeId() 
    {
        return schemeId;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setMotherboard(Long motherboard) 
    {
        this.motherboard = motherboard;
    }

    public Long getMotherboard() 
    {
        return motherboard;
    }
    public void setCpu(Long cpu) 
    {
        this.cpu = cpu;
    }

    public Long getCpu() 
    {
        return cpu;
    }
    public void setMemory(Long memory) 
    {
        this.memory = memory;
    }

    public Long getMemory() 
    {
        return memory;
    }
    public void setPowerSupply(Long powerSupply) 
    {
        this.powerSupply = powerSupply;
    }

    public Long getPowerSupply() 
    {
        return powerSupply;
    }
    public void setGraphicsCard(Long graphicsCard) 
    {
        this.graphicsCard = graphicsCard;
    }

    public Long getGraphicsCard() 
    {
        return graphicsCard;
    }
    public void setHardDrive(Long hardDrive) 
    {
        this.hardDrive = hardDrive;
    }

    public Long getHardDrive() 
    {
        return hardDrive;
    }
    public void setBox(Long box) 
    {
        this.box = box;
    }

    public Long getBox() 
    {
        return box;
    }

    public List<TbSchemeReview> getTbSchemeReviewList()
    {
        return tbSchemeReviewList;
    }

    public void setTbSchemeReviewList(List<TbSchemeReview> tbSchemeReviewList)
    {
        this.tbSchemeReviewList = tbSchemeReviewList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("schemeId", getSchemeId())
            .append("userName", getUserName())
            .append("name", getName())
            .append("motherboard", getMotherboard())
            .append("cpu", getCpu())
            .append("memory", getMemory())
            .append("powerSupply", getPowerSupply())
            .append("graphicsCard", getGraphicsCard())
            .append("hardDrive", getHardDrive())
            .append("box", getBox())
            .append("tbSchemeReviewList", getTbSchemeReviewList())
            .toString();
    }
}
