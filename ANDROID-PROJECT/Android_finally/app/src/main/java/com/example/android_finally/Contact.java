package com.example.android_finally;

public class Contact {
    private int accountId;
    private Account friend;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Account getFriend() {
        return friend;
    }

    public void setFriend(Account friend) {
        this.friend = friend;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "accountId=" + accountId +
                ", friend=" + friend +
                '}';
    }
}
