package com.ias.admin.system.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author dududu
 * @email 345912664@qq.com
 * @date 2018-03-22
 */
public class LogPO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //功能
    private String functions;
    //操作
    private String operation;
    //记录
    private String record;
    //内容
    private String content;
    //操作人id
    private Integer operatorId;
    //操作时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date operationTime;

    private AdminPO operator;

    public AdminPO getOperator() {
        return operator;
    }

    public void setOperator(AdminPO operator) {
        this.operator = operator;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFunctions() {
        return functions;
    }

    public void setFunctions(String functions) {
        this.functions = functions;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    @Override
    public String toString(){
        return "Log{" +
                "id=" + id + '\'' +
                ", functions=" + functions + '\'' +
                ", operation=" + operation + '\'' +
                ", record=" + record + '\'' +
                ", content=" + content + '\'' +
                ", operatorId=" + operatorId + '\'' +
                ", operationTime=" + operationTime +
                '}';
    }
}
