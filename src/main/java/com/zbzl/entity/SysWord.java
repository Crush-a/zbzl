package com.zbzl.entity;

import java.util.List;

public class SysWord {
    private String wordId;

    private String wordCode;

    private String wordName;

    private String wordClassify;

    private String wordLabel;

    private String wordTime;

    private String wordHerf;

    private String remark;

    private String wordOrg;

    private String wordUser;

    private String wordMj;

    private String wordStat;

    private String wordEnd;

    private String wordLabelName;

    private  String wordClassifyName;

    public List<SysFile> getSysFiles() {
        return sysFiles;
    }

    public void setSysFiles(List<SysFile> sysFiles) {
        this.sysFiles = sysFiles;
    }

    private List<SysFile> sysFiles;

    public String getWordLabelName() {
        return wordLabelName;
    }

    public void setWordLabelName(String wordLabelName) {
        this.wordLabelName = wordLabelName;
    }

    public String getWordClassifyName() {
        return wordClassifyName;
    }

    public void setWordClassifyName(String wordClassifyName) {
        this.wordClassifyName = wordClassifyName;
    }

    public String getWordStat() {
        return wordStat;
    }

    public void setWordStat(String wordStat) {
        this.wordStat = wordStat;
    }

    public String getWordEnd() {
        return wordEnd;
    }

    public void setWordEnd(String wordEnd) {
        this.wordEnd = wordEnd;
    }



    public String getWordId() {
        return wordId;
    }

    public void setWordId(String wordId) {
        this.wordId = wordId == null ? null : wordId.trim();
    }

    public String getWordCode() {
        return wordCode;
    }

    public void setWordCode(String wordCode) {
        this.wordCode = wordCode == null ? null : wordCode.trim();
    }

    public String getWordName() {
        return wordName;
    }

    public void setWordName(String wordName) {
        this.wordName = wordName == null ? null : wordName.trim();
    }

    public String getWordClassify() {
        return wordClassify;
    }

    public void setWordClassify(String wordClassify) {
        this.wordClassify = wordClassify == null ? null : wordClassify.trim();
    }

    public String getWordLabel() {
        return wordLabel;
    }

    public void setWordLabel(String wordLabel) {
        this.wordLabel = wordLabel == null ? null : wordLabel.trim();
    }

    public String getWordTime() {
        return wordTime;
    }

    public void setWordTime(String wordTime) {
        this.wordTime = wordTime == null ? null : wordTime.trim();
    }

    public String getWordHerf() {
        return wordHerf;
    }

    public void setWordHerf(String wordHerf) {
        this.wordHerf = wordHerf == null ? null : wordHerf.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getWordOrg() {
        return wordOrg;
    }

    public void setWordOrg(String wordOrg) {
        this.wordOrg = wordOrg == null ? null : wordOrg.trim();
    }

    public String getWordUser() {
        return wordUser;
    }

    public void setWordUser(String wordUser) {
        this.wordUser = wordUser == null ? null : wordUser.trim();
    }

    public String getWordMj() {
        return wordMj;
    }

    public void setWordMj(String wordMj) {
        this.wordMj = wordMj == null ? null : wordMj.trim();
    }
}