package com.zbzl.entity;

public class PageQuery {
  private int page;
  private int row;
  private String name;
  private String exSql;
  private String zwdw;
  private String zlfl;
  private String time;
  private String zlbq;


  public String getZwdw() {
    return zwdw;
  }

  public void setZwdw(String zwdw) {
    this.zwdw = zwdw;
  }

  public String getZlfl() {
    return zlfl;
  }

  public void setZlfl(String zlfl) {
    this.zlfl = zlfl;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getZlbq() {
    return zlbq;
  }

  public void setZlbq(String zlbq) {
    this.zlbq = zlbq;
  }


  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public int getRow() {
    return row;
  }

  public void setRow(int row) {
    this.row = row;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getExSql() {
    return exSql;
  }

  public void setExSql(String exSql) {
    this.exSql = exSql;
  }
}
