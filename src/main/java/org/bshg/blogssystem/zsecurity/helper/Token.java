package org.bshg.blogssystem.zsecurity.helper;

import java.io.Serializable;
import java.util.Date;

public class Token implements Serializable {
    private final String value;
    private final Date issuedAt;
    private final Date expirationDate;

    public Token(String value, Date issuedAt, Date expirationDate) {
        this.value = value;
        this.issuedAt = issuedAt;
        this.expirationDate = expirationDate;
    }

    public String getValue() {
        return this.value;
    }

    public Date getIssuedAt() {
        return this.issuedAt;
    }

    public Date getExpirationDate() {
        return this.expirationDate;
    }
}
