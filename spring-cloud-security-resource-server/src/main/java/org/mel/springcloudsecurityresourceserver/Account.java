package org.mel.springcloudsecurityresourceserver;

public class Account {
    private int num;

    private String type;

    private String holder;

    private String bank;

    public Account(int num, String type, String holder, String bank) {
        this.num = num;
        this.type = type;
        this.holder = holder;
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "Account{" +
                "num=" + num +
                ", type='" + type + '\'' +
                ", holder='" + holder + '\'' +
                ", bank='" + bank + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public int getNum() {

        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
