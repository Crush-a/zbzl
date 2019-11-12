package com.zbzl.entity;

import java.util.List;

public class SysDict {
    private String dictId;

    private String dictName;

    private String dictCode;

    private String dictValid;

    private String remark;

    public String getDictTs() {
        return dictTs;
    }

    public void setDictTs(String dictTs) {
        this.dictTs = dictTs;
    }

    private String dictTs;

    public List<SysDictItem> getSysDictItems() {
        return sysDictItems;
    }

    public void setSysDictItems(List<SysDictItem> sysDictItems) {
        this.sysDictItems = sysDictItems;
    }

    private List<SysDictItem> sysDictItems;

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId == null ? null : dictId.trim();
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName == null ? null : dictName.trim();
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode == null ? null : dictCode.trim();
    }

    public String getDictValid() {
        return dictValid;
    }

    public void setDictValid(String dictValid) {
        this.dictValid = dictValid == null ? null : dictValid.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}