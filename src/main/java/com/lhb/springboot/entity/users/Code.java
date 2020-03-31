package com.lhb.springboot.entity.users;

/**
 * @author: yaya
 * @create: 2020/3/29
 */
public class Code {
    private Long codeId;
    private Long emailId;
    private String codeName;

    public Long getCodeId() {
        return codeId;
    }

    public void setCodeId(Long codeId) {
        this.codeId = codeId;
    }

    public Long getEmailId() {
        return emailId;
    }

    public void setEmailId(Long emailId) {
        this.emailId = emailId;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }
}
