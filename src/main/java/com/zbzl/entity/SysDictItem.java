package com.zbzl.entity;

public class SysDictItem {
    private String itemId;

    private String itemCode;

    private String dictId;

    private String dictCode;

    private String itemName;

    private String itemValid;

    private String itemEnable;

    private String remark;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId == null ? null : dictId.trim();
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode == null ? null : dictCode.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getItemValid() {
        return itemValid;
    }

    public void setItemValid(String itemValid) {
        this.itemValid = itemValid == null ? null : itemValid.trim();
    }

    public String getItemEnable() {
        return itemEnable;
    }

    public void setItemEnable(String itemEnable) {
        this.itemEnable = itemEnable == null ? null : itemEnable.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}