package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 法定日期管理对象 yg_holiday
 *
 * @author kunsoft
 * @date 2023-04-07
 */
public class Holiday extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 法定日期 */
    @Excel(name = "法定日期")
    private String holiday;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setHoliday(String holiday)
    {
        this.holiday = holiday;
    }

    public String getHoliday()
    {
        return holiday;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("holiday", getHoliday())
            .toString();
    }
}
