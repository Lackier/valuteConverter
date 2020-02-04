package com.app.util;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType(name = "ValCurs",
        propOrder = {
        "date", "name", "valutes"
        })
@XmlRootElement(name = "ValCurs")
public class ValCurs {

    private String Date;

    private String name;

    private List<Valute> valutes;

    public ValCurs(){
        ;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }
    @XmlElement (name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @XmlElement (name = "valutes")
    public List<Valute> getValutes() {
        return valutes;
    }

    public void setValutes(List<Valute> valutes) {
        this.valutes = valutes;
    }
    @XmlElement (name = "Date")
    public String getDate() {
        return Date;
    }

    @Override
    public String toString() {
        return "ValCurs " + Date + " " + name + "\n" + valutes;
    }
}
