package com.codurance.dip;

import java.util.Objects;

public class Email {
    private final String to;
    private final String subject;
    private final String message;

    Email(String to, String subject, String message) {
        this.to = to;
        this.subject = subject;
        this.message = message;
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(to, email.to) && Objects.equals(subject, email.subject) && Objects.equals(message, email.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(to, subject, message);
    }
}
