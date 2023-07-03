package com.melek.yilmaz.jpabasic;





import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class Data {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)//İd değeri ıdentity mantığına göre üretilecek kendiliğinden artan
    private long dataId;
    private String dataName;
    private double dataValue;
    
    
    public long getDataId() {
        return dataId;
    }
    public void setDataId(long dataId) {
        this.dataId = dataId;
    }
    public String getDataName() {
        return dataName;
    }
    public void setDataName(String dataName) {
        this.dataName = dataName;
    }
    public double getDataValue() {
        return dataValue;
    }
    public void setDataValue(double dataValue) {
        this.dataValue = dataValue;
    }


}