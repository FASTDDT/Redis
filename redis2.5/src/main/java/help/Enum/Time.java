package help.Enum;

public enum  Time implements BaseEnum {
    MIN("分钟",60),
    HOUR("小时",60*60),
    DAY("一天",60*60*24),
    WEEK("一周",60*60*24*7),
    MONTH("一个月",60*60*24*30),
    HALF_YEAR("半年",60*60*24*180),
    YEAR("一年",60*60*24*365)
    ;

    private String disc;
    private Integer seconds;

    @Override
    public Integer getCode() {
        return this.seconds;
    }


    @Override
    public String getDisc() {
        return this.disc;
    }
    Time(String disc,Integer seconds){
        this.disc=disc;
        this.seconds=seconds;
    }
}
